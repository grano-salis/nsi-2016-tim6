package com.sjednice.model;

import java.io.Serializable;
import java.util.Date;
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

/**
 *
 * @author Aida
 */
@Entity
@Table(name = "chat_poruka")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ChatPoruka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "CHAT_PORUKA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "ucesnik_id")
    private int ucesnikId;

    @Column(name = "poruka")
    private String poruka;
    
    @Column(name = "stavka_dnevnog_reda_id")        
    private Integer stavkaDnevnogRedaId;
  
    @Column(name = "vrijeme")
    private Date vrijeme;

    public int getUcesnikId() {
        return ucesnikId;
    }

    public void setUcesnikId(int ucesnikId) {
        this.ucesnikId = ucesnikId;
    }

    public Integer getStavkaDnevnogRedaId() {
        return stavkaDnevnogRedaId;
    }

    public void setStavkaDnevnogRedaId(Integer stavkaDnevnogRedaId) {
        this.stavkaDnevnogRedaId = stavkaDnevnogRedaId;
    }
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Date getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(Date vrijeme) {
        this.vrijeme = vrijeme;
    }
}
