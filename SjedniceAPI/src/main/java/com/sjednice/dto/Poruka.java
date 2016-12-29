/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.dto;

/**
 *
 * @author faris
 */
public class Poruka {
    private String ucesnik;
    private String tekst;

    public Poruka(String ucesnik, String tekst) {
        this.ucesnik = ucesnik;
        this.tekst = tekst;
    }

    
    
    public String getUcesnik() {
        return ucesnik;
    }

    public void setUcesnik(String ucesnik) {
        this.ucesnik = ucesnik;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
    
}
