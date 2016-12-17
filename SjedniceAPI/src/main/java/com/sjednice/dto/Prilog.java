/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author faris
 */
public class Prilog {        

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getSjednicaId() {
        return sjednicaId;
    }

    public void setSjednicaId(Integer sjednicaId) {
        this.sjednicaId = sjednicaId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public MultipartFile getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(MultipartFile sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    private Integer id;
    
    private String naziv;
    
    private Integer sjednicaId;
    
    private String contentType;
    
    private MultipartFile sadrzaj;
}
