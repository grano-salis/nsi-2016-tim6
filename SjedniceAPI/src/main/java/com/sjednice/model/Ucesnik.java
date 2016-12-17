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
    @SequenceGenerator(name = "generator", sequenceName = "UCESNIK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "id")
    private Integer id;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "uposlenik_id")
    private UserInfo userInfo;

    @Column(name = "sjednica_id")
    private Integer sjednica_id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tip_ucesnika_id")
    private TipUcesnika tipUcesnika;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_ucesnika_id")
    private StatusUcesnika statusUcesnika;

    public TipUcesnika getTipUcesnika() {
        return tipUcesnika;
    }

    public void setTipUcesnika(TipUcesnika tipUcesnika) {
        this.tipUcesnika = tipUcesnika;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }


    public int getSjednica_id() {
        return sjednica_id;
    }

    public void setSjednica_id(int sjednica_id) {
        this.sjednica_id = sjednica_id;
    }

    public StatusUcesnika getStatusUcesnika() {
        return statusUcesnika;
    }

    public void setStatusUcesnika(StatusUcesnika statusUcesnika) {
        this.statusUcesnika = statusUcesnika;
    }

   
}
