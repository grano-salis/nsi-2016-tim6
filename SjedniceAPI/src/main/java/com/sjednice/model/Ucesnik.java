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
@Table(name = "ucesnik")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ucesnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "uposlenik_id")
    private int uposlenik_id;

    @Column(name = "sjednica_id")
    private int sjednica_id;

    @Column(name = "tip_ucesnika_id")
    private int tip_ucesnika_id;

    @Column(name = "status_ucesnika_id")
    private int status_ucesnika_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUposlenik_id() {
        return uposlenik_id;
    }

    public void setUposlenik_id(int uposlenik_id) {
        this.uposlenik_id = uposlenik_id;
    }

    public int getSjednica_id() {
        return sjednica_id;
    }

    public void setSjednica_id(int sjednica_id) {
        this.sjednica_id = sjednica_id;
    }

    public int getTip_ucesnika_id() {
        return tip_ucesnika_id;
    }

    public void setTip_ucesnika_id(int tip_ucesnika_id) {
        this.tip_ucesnika_id = tip_ucesnika_id;
    }

    public int getStatus_ucesnika_id() {
        return status_ucesnika_id;
    }

    public void setStatus_ucesnika_id(int status_ucesnika_id) {
        this.status_ucesnika_id = status_ucesnika_id;
    }

}
