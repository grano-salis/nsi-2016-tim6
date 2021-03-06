/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    @SequenceGenerator(name = "generator", sequenceName = "STAVKA_DNEVNOG_REDA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "sjednica_id")
    private Integer sjednicaId;

    @Column(name = "redni_broj")
    private int redniBroj;

    @Column(name = "naslov")
    private String naslov;

    @Column(name = "opis")
    private String opis;

    @Column(name = "status_stavke_dr_id")
    private int statusStavkeDrId;

    @OneToMany(mappedBy = "stavkaDnevnogRedaId")
    @LazyCollection(LazyCollectionOption.FALSE) 
    private Set<Glas> glasovi;

    public Set<Glas> getGlasovi() {
        return glasovi;
    }

    void setGlasovi(Set<Glas> glasovi) {
        this.glasovi = glasovi;
    }
    
    
    @OneToMany(mappedBy = "stavkaDnevnogRedaId")
    @LazyCollection(LazyCollectionOption.FALSE)    
    private Set<ChatPoruka> poruke;

    public Set<ChatPoruka> getPoruke() {
        return poruke;
    }

    void setPoruke(Set<ChatPoruka> poruke) {
        this.poruke = poruke;
    }

    public Integer getSjednicaId() {
        return sjednicaId;
    }

    public void setSjednicaId(Integer sjednicaId) {
        this.sjednicaId = sjednicaId;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public int getStatusStavkeDrId() {
        return statusStavkeDrId;
    }

    public void setStatusStavkeDrId(int statusStavkeDrId) {
        this.statusStavkeDrId = statusStavkeDrId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
