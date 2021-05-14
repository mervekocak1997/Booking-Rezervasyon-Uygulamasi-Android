package com.example.myapplication;

public class Mulkler {
    private int mulk_id;
    private String mulk_ad;
    private String mulk_tip;
    private String mulk_adres;
    private String mulk_ucret;
    private String mulk_oda;
    private String mulk_isitma;
    private String mulk_kat;
    private String mulk_aidat;

    public Mulkler(){

    }

    public Mulkler(int mulk_id, String mulk_ad,String mulk_tip,String mulk_adres, String mulk_ucret, String mulk_oda, String mulk_isitma, String mulk_kat, String mulk_aidat){
        this.mulk_id = mulk_id;
        this.mulk_ad = mulk_ad;
        this.mulk_tip = mulk_tip;
        this.mulk_adres = mulk_adres;
        this.mulk_ucret = mulk_ucret;
        this.mulk_oda = mulk_oda;
        this.mulk_isitma = mulk_isitma;
        this.mulk_kat = mulk_kat;
        this.mulk_aidat = mulk_aidat;

    }


    public int getMulk_id(){
        return mulk_id;
    }
public void setMulk_id(int mulk_id){
        this.mulk_id = mulk_id;
}


    public String getMulk_ad(){
        return mulk_ad;
    }
    public void setMulk_ad(String mulk_ad){
        this.mulk_ad = mulk_ad;
    }


    public String getMulk_tip(){
        return mulk_tip;
    }
    public void setMulk_tip(String mulk_tip){
        this.mulk_tip = mulk_tip;
    }


    public String getMulk_adres(){
        return mulk_adres;
    }
    public void setMulk_adres(String mulk_adres){
        this.mulk_adres = mulk_adres;
    }

    public String getMulk_ucret(){
        return mulk_ucret;
    }
    public void setMulk_ucret(String mulk_ucret){
        this.mulk_ucret = mulk_ucret;
    }


    public String getMulk_oda(){
        return mulk_oda;
    }
    public void setMulk_oda(String mulk_oda){
        this.mulk_oda = mulk_oda;
    }


    public String getMulk_isitma(){
        return mulk_isitma;
    }
    public void setMulk_isitma(String mulk_isitma){
        this.mulk_isitma = mulk_isitma;
    }


    public String getMulk_kat(){
        return mulk_kat;
    }
    public void setMulk_kat(String mulk_kat){
        this.mulk_kat = mulk_kat;
    }

    public String getMulk_aidat(){
        return mulk_aidat;
    }
    public void setMulk_aidat(String mulk_aidat){
        this.mulk_aidat = mulk_aidat;
    }
}
