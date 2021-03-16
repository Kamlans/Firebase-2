package com.example.firebase_2;

public class Model {

    public Model() {
    }

    String ff , sf;

    public Model(String ff, String sf) {
        this.ff = ff;
        this.sf = sf;
    }

    public void setall( String ff , String sf){
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
