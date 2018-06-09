package com.example.hp.projektiandroid;

/**
 * Created by HP on 6/8/2018.
 */

public class ProfileModel1 {

    String pershkrimi;
    int image;



    public ProfileModel1(String pershkrimi,int image)
    {
        this.pershkrimi=pershkrimi;
        this.image=image;







    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPershkrimi() {
        return pershkrimi;
    }

    public void setPershkrimi(String pershkrimi) {
        this.pershkrimi = pershkrimi;
    }
}
