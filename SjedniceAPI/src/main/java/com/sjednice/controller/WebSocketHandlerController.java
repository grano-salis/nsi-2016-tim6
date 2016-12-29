/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.controller;

/**
 *
 * @author faris
 */
import com.sjednice.model.ChatPoruka;
import com.sjednice.model.Glas;
import com.sjednice.model.StavkaDnevnogReda;
import com.sjednice.services.ChatPorukaServices;
import com.sjednice.services.GlasServices;
import com.sjednice.services.StavkaDnevnogRedaServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*", allowedHeaders = {"Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers"}, exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"})
@Controller
public class WebSocketHandlerController {

    @Autowired
    GlasServices glasService;

    @Autowired
    ChatPorukaServices chatService;

    @Autowired
    StavkaDnevnogRedaServices stavkaDrService;

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public ChatPoruka chat(ChatPoruka message) throws Exception {                        
        return chatService.addEntity(message);
    }

    @MessageMapping("/sendaktivnastavkadr")
    @SendTo("/topic/aktivnastavkadr")
    public StavkaDnevnogReda stavkaDnevnogReda(StavkaDnevnogReda stavka) throws Exception {
        //4 za aktivnu

        List<StavkaDnevnogReda> stavke = stavkaDrService.getEntityListBySjednicaId(stavka.getSjednicaId());

        for (int i = 0; i < stavke.size(); i++) {
            StavkaDnevnogReda s = stavke.get(i);
            if (s.getStatusStavkeDrId() == 4) {
                s.setStatusStavkeDrId(3);
                stavkaDrService.updateEntity(s);
            }
        }
        stavka.setStatusStavkeDrId(4);
        stavkaDrService.updateEntity(stavka);
        Thread.sleep(1000); // simulated delay
        return stavka;
    }

    @MessageMapping("/promijeniStatusStavkeDr")
    @SendTo("/topic/statusstavkedr")
    public StavkaDnevnogReda promijeniStatus(StavkaDnevnogReda stavka) throws Exception {

        stavkaDrService.updateEntity(stavka);
        Thread.sleep(1000); // simulated delay
        return stavka;
    }

    @MessageMapping("/sendglas")
    @SendTo("/topic/glas")
    public Glas glas(Glas glas) throws Exception {
        Thread.sleep(1000);
        return glasService.addEntity(glas);
        // simulated delay                
        //return glasService.addEntity(glas);                        
    }

    @MessageMapping("/sendomoguciglasanje")
    @SendTo("/topic/omoguciglasanje")
    public boolean omogucavanjeGlasanja(boolean omoguciti) throws Exception {
        Thread.sleep(1000); // simulated delay
        return omoguciti;
        //return glasService.addEntity(glas);                        
    }

}
