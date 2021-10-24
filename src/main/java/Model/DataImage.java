package Model;

import java.util.ArrayList;
import java.util.List;

public class DataImage {
    private String type;
    private List<String> list_tag = new ArrayList<>();
    private String text;

    public DataImage(String type, List<String> list_tag, String text) {
        this.type = type;
        this.list_tag = list_tag;
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getList_tag() {
        return list_tag;
    }

    public void addToList_tag(String tag) {
        this.list_tag.add(tag);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
