/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "sjednica")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sjednica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "SJEDNICA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "sala")
    private String sala;

    @Column(name = "datum_odrzavanja_od")
    private Date datumOdrzavanjaOd;

    @Column(name = "datum_odrzavanja_do")
    private Date datumOdrzavanjaDo;

    @Column(name = "dnevni_red_id")
    private Integer dnevniRedId;

    @Column(name = "status_sjednice_id")
    private Integer statusSjedniceId;

    @Column(name = "zapisnik_id")
    private Integer zapisnikId;

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

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Date getDatumOdrzavanjaOd() {
        return datumOdrzavanjaOd;
    }

    public void setDatumOdrzavanjaOd(Date datumOdrzavanjaOd) {
        this.datumOdrzavanjaOd = datumOdrzavanjaOd;
    }

    public Date getDatumOdrzavanjaDo() {
        return datumOdrzavanjaDo;
    }

    public void setDatumOdrzavanjaDo(Date datumOdrzavanjaDo) {
        this.datumOdrzavanjaDo = datumOdrzavanjaDo;
    }

    public Integer getDnevniRedId() {
        return dnevniRedId;
    }

    public void setDnevniRedId(Integer dnevniRedId) {
        this.dnevniRedId = dnevniRedId;
    }

    public Integer getStatusSjedniceId() {
        return statusSjedniceId;
    }

    public void setStatusSjedniceId(Integer statusSjedniceId) {
        this.statusSjedniceId = statusSjedniceId;
    }

    public Integer getZapisnikId() {
        return zapisnikId;
    }

    public void setZapisnikId(Integer zapisnikId) {
        this.zapisnikId = zapisnikId;
    }

}
