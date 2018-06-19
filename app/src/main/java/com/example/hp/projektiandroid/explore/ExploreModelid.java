package com.example.hp.projektiandroid.explore;

import android.content.Intent;

import java.io.Serializable;

//qekjo bohet per me mundesu me marr ID-ne

public class ExploreModelid implements Serializable{
    String id;
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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





    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCmimi() {
        return cmimi;
    }

    public void setCmimi(String cmimi) {
        this.cmimi = cmimi;
    }

    public String getFotojaURL() {
        return fotojaURL;
    }

    public void setFotojaURL(String fotojaURL) {
        this.fotojaURL = fotojaURL;
    }

    public String getNoOfGuests() {
        return noOfGuests;
    }

    public void setNoOfGuests(String noOfGuests) {
        this.noOfGuests = noOfGuests;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTipi() {
        return tipi;
    }

    public void setTipi(String tipi) {
        this.tipi = tipi;
    }

    public Boolean getSaved() {
        return isSaved;
    }

    public void setSaved(Boolean saved) {
        isSaved = saved;
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

    public ExploreModelid(String id, String noOfBeds, String name, String location, String cmimi, String fotojaURL, String noOfGuests, String date, String tipi, String noOfBedR, String noOfBathR, String nights, Boolean isSaved) {
        this.id = id;
        this.noOfBeds = noOfBeds;
        this.name = name;
        this.location = location;
        this.cmimi = cmimi;
        this.fotojaURL = fotojaURL;
        this.noOfGuests = noOfGuests;
        this.date = date;
        this.tipi = tipi;
        this.isSaved = isSaved;
        this.noOfBedR = noOfBedR;
        this.noOfBathR = noOfBathR;
        this.nights = nights;
    }


}
