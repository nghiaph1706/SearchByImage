

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import net.sourceforge.tess4j.Tesseract;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class XAPI {
    static String credentialsToEncode = "acc_bff6cc66a4f1e99" + ":" + "1ba3a48bc0f52fbd4ecb0eec59a919f0";
    static String basicAuth = Base64.getEncoder().encodeToString(credentialsToEncode.getBytes(StandardCharsets.UTF_8));
    static String endpoint_url_byTags = "https://api.imagga.com/v2/tags";
    static List<String> Image_Tags_List = new ArrayList();
    static String filepath = "";

    static void getTagsImage(String image_upload_id) throws IOException, ParseException {
        Image_Tags_List.clear();
        String url = endpoint_url_byTags + "?image_upload_id=" + image_upload_id;
        URL urlObject = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

        connection.setRequestProperty("Authorization", "Basic " + basicAuth);

        int responseCode = connection.getResponseCode();

        BufferedReader connectionInput = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String jsonResponse = connectionInput.readLine();

        connectionInput.close();

        JSONParser parser = new JSONParser();

        JSONObject data = (JSONObject) parser.parse(jsonResponse);

        JSONObject result = (JSONObject) data.get("result");
        JSONArray tags = (JSONArray) result.get("tags");

        for (int i = 0; i < tags.size(); i++) {
            JSONObject jsdt = (JSONObject) tags.get(i);
            JSONObject tag = (JSONObject) jsdt.get("tag");
            String en = (String) tag.get("en");
            Image_Tags_List.add(en);
        }


    }

    static String upLoad() throws IOException, ParseException {
        File fileToUpload = new File(filepath);

        String endpoint = "/uploads";

        String crlf = "\r\n";
        String twoHyphens = "--";
        String boundary =  "Image Upload";

        URL urlObject = new URL("https://api.imagga.com/v2" + endpoint);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        connection.setRequestProperty("Authorization", "Basic " + basicAuth);
        connection.setUseCaches(false);
        connection.setDoOutput(true);

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setRequestProperty("Cache-Control", "no-cache");
        connection.setRequestProperty(
                "Content-Type", "multipart/form-data;boundary=" + boundary);

        DataOutputStream request = new DataOutputStream(connection.getOutputStream());

        request.writeBytes(twoHyphens + boundary + crlf);
        request.writeBytes("Content-Disposition: form-data; name=\"image\";filename=\"" + fileToUpload.getName() + "\"" + crlf);
        request.writeBytes(crlf);


        InputStream inputStream = new FileInputStream(fileToUpload);
        int bytesRead;
        byte[] dataBuffer = new byte[1024];
        while ((bytesRead = inputStream.read(dataBuffer)) != -1) {
            request.write(dataBuffer, 0, bytesRead);
        }

        request.writeBytes(crlf);
        request.writeBytes(twoHyphens + boundary + twoHyphens + crlf);
        request.flush();
        request.close();

        InputStream responseStream = new BufferedInputStream(connection.getInputStream());

        BufferedReader responseStreamReader = new BufferedReader(new InputStreamReader(responseStream));

        String line = "";
        StringBuilder stringBuilder = new StringBuilder();

        while ((line = responseStreamReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        responseStreamReader.close();

        String response = stringBuilder.toString();

        JSONParser parser = new JSONParser();

        JSONObject data = (JSONObject) parser.parse(response);

        JSONObject result = (JSONObject) data.get("result");
        String upload_id = (String) result.get("upload_id");



        System.err.println("upload_id: "+upload_id);

        responseStream.close();
        connection.disconnect();
        return upload_id;
    }

    static void getTextImage(){
        Tesseract tesseract = new Tesseract();
        try {
            tesseract.setDatapath("C:\\tessdata");
            String text = tesseract.doOCR(new File(filepath));
            System.out.println(text);

        } catch (Exception e) {
        }
    }

    public void getImageContent(String imagePath) throws IOException, ParseException {
        Boolean checkText = false;
        filepath = imagePath;
        getTagsImage(upLoad());
        for (String tag:Image_Tags_List){
            if (tag.equals("text")){
                checkText = true;
            }
        }
        if (checkText){
            System.out.println("TEXT IN PICTURE: ");
            getTextImage();
        } else {
            System.out.println("OBJECT IN PICTURE: ");
            for (int i = 0; i < 5; i++){
                System.out.println(Image_Tags_List.get(i));
            }
        }

    }
}
