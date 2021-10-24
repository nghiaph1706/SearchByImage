package Utilitie;

import GUI.mainFrame;
import Model.ModelResult;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static Utilitie.Final.list_Result;

public class SearchAPI {
    static String url_part1 = "https://serpapi.com/search.json?engine=google&q=";
    static String url_part2 = "ls&location=Seattle-Tacoma%2C+WA%2C+Washington%2C+United+States&hl=en&gl=us&google_domain=google.com&num=10&start=10&safe=active&api_key=";
    static String api_key = "c94a5846daf6012ce7576a89967fa987a02b000e8fe1abe173252d69125bfafe";
    // url_part1 + key_word + url_part2 + api_key

    public static void getResult(String keyword) throws IOException, ParseException {
        list_Result.clear();
        keyword.trim();
        keyword.replaceAll("\\s+","");
        String endpoint = url_part1 + keyword + url_part2 + api_key;
        StringBuilder sb = new StringBuilder();
        URL url = new URL(endpoint);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            // read in the bytes
            InputStream inputStream = urlConnection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            // read them as characters.
            InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // read one line at a time.
            String inputLine = bufferedReader.readLine();
            while (inputLine != null) {
                // add this to our output
                sb.append(inputLine);
                // reading the next line
                inputLine = bufferedReader.readLine();
            }
        } finally {
            urlConnection.disconnect();
        }

        String jsonResponse = sb.toString();
        JSONParser parser = new JSONParser();

        JSONObject data = (JSONObject) parser.parse(jsonResponse);

        JSONArray organic_results = (JSONArray) data.get("organic_results");
        for (int i = 0; i< organic_results.size();i++){
            JSONObject jsdt = (JSONObject) organic_results.get(i);
            String title = (String) jsdt.get("title");
            String link = (String) jsdt.get("link");
            String displayed_link = (String) jsdt.get("displayed_link");
            String snippet = (String) jsdt.get("snippet");
            ModelResult modelResult = new ModelResult(Final.TYPE_DATA.TAGS.toString(),title,link,displayed_link,snippet);
            list_Result.add(modelResult);
        }

    }
}
