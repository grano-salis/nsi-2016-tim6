/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.dao;

import com.sjednice.dto.Izvjestaj;
import com.sjednice.dto.StavkaDr;
import com.sjednice.model.Sjednica;
import com.sjednice.model.StavkaDnevnogReda;
import com.sjednice.services.GlasServices;
import com.sjednice.services.SjednicaServices;
import com.sjednice.services.StavkaDnevnogRedaServices;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author faris
 */
public class IzvjestajDao {
    @Autowired
    SessionFactory sessionFactory;
    
        @Autowired
    SjednicaServices sjednicaServices;
        
            @Autowired
    StavkaDnevnogRedaServices stavkaDrServices;
            
                @Autowired
    GlasServices glasServices;

    Session session = null;
    Transaction tx = null;
    
    public Izvjestaj getIzvjestaj(Integer sjednicaId) {
        
        
        
        
        
        return null;
    }
   
        
}