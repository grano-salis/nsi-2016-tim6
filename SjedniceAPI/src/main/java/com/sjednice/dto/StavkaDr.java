/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.dto;

import java.util.List;

/**
 *
 * @author faris
 */
public class StavkaDr {
    private Integer id;
    private String naziv;
    private Integer brojGlasovaZa;
    private Integer brojGlasovaProtiv;
    private Integer brojGlasovaSuzdrzan;
    private String status;
    private List<Poruka> poruke;

    public StavkaDr(Integer id, String naziv, Integer brojGlasovaZa, Integer brojGlasovaProtiv, Integer brojGlasovaSuzdrzan, String status, List<Poruka> poruke) {
        this.id = id;
        this.naziv = naziv;
        this.brojGlasovaZa = brojGlasovaZa;
        this.brojGlasovaProtiv = brojGlasovaProtiv;
        this.brojGlasovaSuzdrzan = brojGlasovaSuzdrzan;
        this.status = status;
        this.poruke = poruke;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getBrojGlasovaZa() {
        return brojGlasovaZa;
    }

    public void setBrojGlasovaZa(Integer brojGlasovaZa) {
        this.brojGlasovaZa = brojGlasovaZa;
    }

    public Integer getBrojGlasovaProtiv() {
        return brojGlasovaProtiv;
    }

    public void setBrojGlasovaProtiv(Integer brojGlasovaProtiv) {
        this.brojGlasovaProtiv = brojGlasovaProtiv;
    }

    public Integer getBrojGlasovaSuzdrzan() {
        return brojGlasovaSuzdrzan;
    }

    public void setBrojGlasovaSuzdrzan(Integer brojGlasovaSuzdrzan) {
        this.brojGlasovaSuzdrzan = brojGlasovaSuzdrzan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Poruka> getPoruke() {
        return poruke;
    }

    public void setPoruke(List<Poruka> poruke) {
        this.poruke = poruke;
    }
    
}
