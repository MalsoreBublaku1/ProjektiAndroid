package com.example.hp.projektiandroid.explore;



public class ExploreModel {
    String name;
    int image;
    String location;
    String cmimi;

public ExploreModel(){


}
    public ExploreModel(String name, int image, String location, String cmimi) {
        this.name = name;
        this.image = image;
        this.location = location;
        this.cmimi = cmimi;
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



