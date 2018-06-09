package com.example.hp.projektiandroid;

/**
 * Created by HP on 6/9/2018.
 */

public class users {
    public String emri;
    public String mbiemri;
    public String email;
    public String pass;





    public users(String emri,String mbiemri,String email,String pass)
    {
        this.emri=emri;
        this.mbiemri=mbiemri;
        this.pass=pass;
        this.email=email;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
