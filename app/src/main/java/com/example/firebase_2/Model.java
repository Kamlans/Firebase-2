package com.example.firebase_2;

import android.net.Uri;
import android.widget.ImageView;

import com.google.firebase.firestore.FieldPath;

public class Model {

    public Model() {
    }

    String ff , sf;

    String  Img;

    public Model(String ff, String sf , String img) {
        this.ff = ff;
        this.sf = sf;
        img = Img;
    }




    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public void setall(String ff , String sf){
        this.ff = ff;
        this.sf =sf;
    }
    public String getFf() {
        return ff;
    }

    public void setFf(String ff) {
        this.ff = ff;
    }

    public String getSf() {
        return sf;
    }

    public void setSf(String sf) {
        this.sf = sf;
    }
}
