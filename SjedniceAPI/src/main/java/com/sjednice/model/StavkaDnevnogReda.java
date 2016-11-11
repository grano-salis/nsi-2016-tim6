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
@Table(name = "stavka_dnevnog_reda")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StavkaDnevnogReda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "STAVKA_DNEVNOG_REDA_ID_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "dnevni_red_id")
    private int dnevni_red_id;

    @Column(name = "redni_broj")
    private int redni_broj;

    @Column(name = "naslov")
    private String naslov;

    @Column(name = "opis")
    private String opis;

    @Column(name = "status_stavke_dr_id")
    private int status_stavke_dr_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDnevni_red_id() {
        return dnevni_red_id;
    }

    public void setDnevni_red_id(int dnevni_red_id) {
        this.dnevni_red_id = dnevni_red_id;
    }

    public int getRedni_broj() {
        return redni_broj;
    }

    public void setRedni_broj(int redni_broj) {
        this.redni_broj = redni_broj;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getStatus_stavke_dr_id() {
        return status_stavke_dr_id;
    }

    public void setStatus_stavke_dr_id(int status_stavke_dr_id) {
        this.status_stavke_dr_id = status_stavke_dr_id;
    }

}
