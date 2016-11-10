package com.sjednice.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "chat_poruka")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ChatPoruka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "ucesnik_id")
    private int ucesnik_id;

    @Column(name = "poruka")
    private String poruka;

    @Column(name = "vrijeme")
    private Date vrijeme;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUcesnik_id() {
        return ucesnik_id;
    }

    public void setUcesnik_id(int ucesnik_id) {
        this.ucesnik_id = ucesnik_id;
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
