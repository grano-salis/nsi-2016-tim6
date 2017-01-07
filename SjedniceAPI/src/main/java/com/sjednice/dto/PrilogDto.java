/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.dto;

import java.io.Serializable;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author Aida
 */
@Entity
@Table(name = "prilog")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PrilogDto implements Serializable {

    private static final long serialVersionUID = 1L;

//    public Prilog(Integer id, String naziv, Integer sjednicaId, String contentType) {
//        this.id = id;
//        this.naziv = naziv;
//        this.sjednicaId = sjednicaId;
//        this.contentType = contentType;
//    }   
    
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "PRILOG_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "sjednica_id")
    private Integer sjednicaId;

    @Column(name = "content_type")
    private String contentType;
    
    @Lob
    @Column(name = "sadrzaj")    
    private byte[] sadrzaj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSjednicaId() {
        return sjednicaId;
    }

    public void setSjednicaId(Integer sjednicaId) {
        this.sjednicaId = sjednicaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String content_type) {
        this.contentType = content_type;
    }

    public byte[] getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(byte[] sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

}
