/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;

/**
 *
 * @author Aida
 */
@Entity
@Table(name = "glas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Glas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "GLAS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "stavka_dnevnog_reda_id")
    private int stavkaDnevnogRedaId;
       
    

    @Column(name = "tip_glasa_id")
    private int tipGlasaId;

    @Column(name = "ucesnik_id")
    private int ucesnikId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStavkaDnevnogRedaId() {
        return stavkaDnevnogRedaId;
    }

    public void setStavkaDnevnogRedaId(int stavkaDnevnogRedaId) {
        this.stavkaDnevnogRedaId = stavkaDnevnogRedaId;
    }

    public int getTipGlasaId() {
        return tipGlasaId;
    }

    public void setTipGlasaId(int tipGlasaId) {
        this.tipGlasaId = tipGlasaId;
    }

    public int getUcesnikId() {
        return ucesnikId;
    }

    public void setUcesnikId(int ucesnikId) {
        this.ucesnikId = ucesnikId;
    }

  
}
