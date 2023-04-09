package com.example.consumoapifilmes.model;

import com.example.consumoapifilmes.model.FilmeModel;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FilmeSerializable {

    @SerializedName("Search")
    public ArrayList<FilmeModel> filmeSerializableArrayList;


}
