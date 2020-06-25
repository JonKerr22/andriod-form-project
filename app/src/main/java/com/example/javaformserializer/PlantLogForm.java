package com.example.javaformserializer;

import com.google.gson.*;

public class PlantLogForm {

    public String EntryDate;
    public String PlantId;
    public GrowthStage Stage;
    public String Notes;

    public PlantLogForm(String date, String id, GrowthStage stage, String notes){
        this.EntryDate = date;
        this.PlantId = id;
        this.Stage = stage;
        this.Notes = notes;

    }

    @Override
    public String toString() {
        return "PlantLogForm{" +
                "EntryDate='" + EntryDate + '\'' +
                ", PlantId='" + PlantId + '\'' +
                ", Stage=" + Stage +
                ", Notes='" + Notes + '\'' +
                '}';
    }

    public String toJsonString(){
        Gson gsonConverter = new Gson();
        return  gsonConverter.toJson(this);
    }
}
