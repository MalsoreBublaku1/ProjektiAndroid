package com.example.hp.projektiandroid.explore;

import java.io.Serializable;

/**
 * Created by HP on 6/18/2018.
 */

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

    public ExploreModelid(String id, String noOfBeds, String name, String location, String cmimi, String fotojaURL, String noOfGuests, String date, String tipi, Boolean isSaved) {
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
    }
}
