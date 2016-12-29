/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author faris
 */
public class Izvjestaj {
    private Integer sjednicaId;
    private String naslov;    
    private Date DatumOdrzavanja;
    private String lokacija;
    private List<StavkaDr> stavkeDr;

    public Izvjestaj(Integer sjednicaId, String naslov, Date DatumOdrzavanja, String lokacija, List<StavkaDr> stavkeDr) {
        this.sjednicaId = sjednicaId;
        this.naslov = naslov;        
        this.DatumOdrzavanja = DatumOdrzavanja;
        this.stavkeDr = stavkeDr;
        this.lokacija = lokacija;
    }

    public Izvjestaj(Integer sjednicaId, String naslov, Date DatumOdrzavanja, String lokacija) {
        this.sjednicaId = sjednicaId;
        this.naslov = naslov;        
        this.DatumOdrzavanja = DatumOdrzavanja;        
        this.lokacija = lokacija;
    }

    public Izvjestaj() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }
    
    public Integer getSjednicaId() {
        return sjednicaId;
    }

    public void setSjednicaId(Integer sjednicaId) {
        this.sjednicaId = sjednicaId;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public Date getDatumOdrzavanja() {
        return DatumOdrzavanja;
    }

    public void setDatumOdrzavanja(Date DatumOdrzavanja) {
        this.DatumOdrzavanja = DatumOdrzavanja;
    }

    public List<StavkaDr> getStavkeDr() {
        return stavkeDr;
    }

    public void setStavkeDr(List<StavkaDr> stavkeDr) {
        this.stavkeDr = stavkeDr;
    }
    
}
