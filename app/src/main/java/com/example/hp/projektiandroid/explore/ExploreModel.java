package com.example.hp.projektiandroid.explore;



public class ExploreModel {
    String noOfBeds;
    String name;
    int image;
    String location;
    String cmimi;

public ExploreModel(){


}
    public ExploreModel(String name, int image, String location, String cmimi,String noOfBeds) {
        this.name = name;
        this.noOfBeds=noOfBeds;
        this.image = image;
        this.location = location;
        this.cmimi = cmimi;
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

    public int getImage() {
        return image;
    }

    public String getLocation() {
        return location;
    }

    public String getCmimi() {
        return cmimi;
    }
}



