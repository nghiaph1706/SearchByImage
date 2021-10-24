package Utilitie;

import GUI.mainFrame;
import Model.ModelResult;

import java.util.ArrayList;
import java.util.List;

public interface Final {
    enum TYPE_DATA{
        TEXT, TAGS
    }
    List<ModelResult> list_Result = new ArrayList<>();
    List<String> list_Tags = new ArrayList<>();
}
