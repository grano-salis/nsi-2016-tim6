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
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

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
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "stavka_dnevnog_reda_id")
    private int stavka_dnevnog_reda_id;

    @Column(name = "tip_glasa_id")
    private int tip_glasa_id;

    @Column(name = "ucesnik_id")
    private int ucesnik_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStavka_dnevnog_reda_id() {
        return stavka_dnevnog_reda_id;
    }

    public void setStavka_dnevnog_reda_id(int stavka_dnevnog_reda_id) {
        this.stavka_dnevnog_reda_id = stavka_dnevnog_reda_id;
    }

    public int getTip_glasa_id() {
        return tip_glasa_id;
    }

    public void setTip_glasa_id(int tip_glasa_id) {
        this.tip_glasa_id = tip_glasa_id;
    }

    public int getUcesnik_id() {
        return ucesnik_id;
    }

    public void setUcesnik_id(int ucesnik_id) {
        this.ucesnik_id = ucesnik_id;
    }

}
