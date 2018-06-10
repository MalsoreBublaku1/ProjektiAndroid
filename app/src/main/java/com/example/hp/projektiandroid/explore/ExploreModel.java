package com.example.hp.projektiandroid.explore;



public class ExploreModel {
    String noOfBeds;
    String name;
    String location;
    String cmimi;
    String fotojaURL;
    String noOfGuests;
    String date;


    public ExploreModel(){


    }
    public ExploreModel(String name, String location, String cmimi,String noOfBeds,String fotojaURL,String noOfGuests,String date) {
        this.name = name;
        //this.fotojaUrl=fotojaUrl;
        this.noOfBeds=noOfBeds;
        this.location = location;
        this.cmimi = cmimi;
        this.fotojaURL=fotojaURL;
        this.noOfGuests=noOfGuests;
        this.date=date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNoOfGuests() {
        return noOfGuests;
    }

    public void setNoOfGuests(String noOfGuests) {
        this.noOfGuests = noOfGuests;
    }

    public String getFotojaURL() {
        return fotojaURL;
    }

    public void setFotojaURL(String fotojaURL) {
        this.fotojaURL = fotojaURL;
    }

    public String getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(String noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public String getName() {
        return name;
    }



    public String getLocation() {
        return location;
    }

    public String getCmimi() {
        return cmimi;
    }
}


