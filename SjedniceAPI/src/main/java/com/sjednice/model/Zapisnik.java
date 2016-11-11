/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author Aida
 */
@Entity
@Table(name = "ucesnik")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Zapisnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "ZAPISNIK_ID_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "tekst")
    private String tekst;

    @Column(name = "sjednica_id")
    private int sjednica_id;

    @Column(name = "prilog_id")
    private int prilog_id;

    @Column(name = "kreator_id")
    private int kreator_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getSjednica_id() {
        return sjednica_id;
    }

    public void setSjednica_id(int sjednica_id) {
        this.sjednica_id = sjednica_id;
    }

    public int getPrilog_id() {
        return prilog_id;
    }

    public void setPrilog_id(int prilog_id) {
        this.prilog_id = prilog_id;
    }

    public int getKreator_id() {
        return kreator_id;
    }

    public void setKreator_id(int kreator_id) {
        this.kreator_id = kreator_id;
    }
}
