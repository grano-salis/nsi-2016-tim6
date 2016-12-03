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
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatHandleController {
    @MessageMapping("/sendChat")
    @SendTo("/topic/messages")
    public ChatPoruka greeting(ChatPoruka message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return message;
    }
}
