package com.example.hp.projektiandroid.explore;


import java.io.Serializable;
//qetu veq merren te dhenat
public class ExploreModel implements Serializable {
    String noOfBeds;
    String name;
    String location;
    String cmimi;
    String fotojaURL;
    String noOfGuests;
    String date;
    String tipi;
    Boolean isSaved;
    String noOfBedR;
    String noOfBathR;
    String nights;

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCmimi(String cmimi) {
        this.cmimi = cmimi;
    }

    public Boolean getSaved1() {
        return isSaved;
    }

    public void setSaved1(Boolean saved) {
        isSaved = saved;
    }

    public ExploreModel(){


    }
    public ExploreModel(String name, String location, String cmimi ,String noOfBeds, String fotojaURL, String noOfGuests,String date,String tipi,String noOfBedR, String noOfBathR, String nights, Boolean isSaved) {
        this.name = name;
        //this.fotojaUrl=fotojaUrl;
        this.noOfBeds=noOfBeds;
        this.location = location;
        this.cmimi = cmimi;
        this.fotojaURL=fotojaURL;
        this.noOfGuests=noOfGuests;
        this.date=date;

        this.tipi=tipi;
        this.isSaved=isSaved;
        this.noOfBedR = noOfBedR;
        this.noOfBathR = noOfBathR;
        this.nights = nights;
    }

    public String getDate() {
        return date;
    }


    public Boolean getSaved() {
        return isSaved;
    }

    public void setSaved(Boolean saved) {
        isSaved = saved;
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


    public String getTipi() {
        return tipi;
    }

    public void setTipi(String tipi) {
        this.tipi = tipi;
    }

    public String getNoOfBedR() {
        return noOfBedR;
    }

    public void setNoOfBedR(String noOfBedR) {
        this.noOfBedR = noOfBedR;
    }

    public String getNoOfBathR() {
        return noOfBathR;
    }

    public void setNoOfBathR(String noOfBathR) {
        this.noOfBathR = noOfBathR;
    }

    public String getNights() {
        return nights;
    }

    public void setNights(String nights) {
        this.nights = nights;
    }
}


