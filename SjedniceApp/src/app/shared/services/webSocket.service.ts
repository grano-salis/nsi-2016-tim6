import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { ChatPoruka } from '../models/chatPoruka';
import { StavkaDr } from '../models/stavkaDr';

var SockJS = require('sockjs-client');
var Stomp = require('stompjs');

@Injectable()
export class WebSocketService {
    stompClient: any;    

    messages : ChatPoruka[];
    stavkeDr: StavkaDr[];

    aktivnaStavkaDr: StavkaDr;

    constructor(private url: UrlProvider, messages : ChatPoruka[], stavkeDr : StavkaDr[], aktivnaStavkaDr: StavkaDr) {
        this.messages = messages;
        this.stavkeDr = stavkeDr;
        this.aktivnaStavkaDr = aktivnaStavkaDr;
        this.connect();
    }

    sendChatMessage(chatPoruka: ChatPoruka) {
        this.stompClient.send('/app/send', {}, JSON.stringify(chatPoruka));
    }

    sendAktivnaStavkaDr(stavkaDr: StavkaDr) {
        this.stompClient.send('/app/sendaktivnastavkadr', {}, JSON.stringify(stavkaDr));        
    }

    connect() {        
        var that = this;
        var socket = new SockJS(this.url.webSocketUrlChat);        
        this.stompClient = Stomp.over(socket); 
        this.stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            that.stompClient.subscribe('/topic/messages', data => that.messages.push(JSON.parse(data.body)));
            that.stompClient.subscribe('/topic/aktivnastavkadr', 
                data => that.aktivnaStavkaDr = JSON.parse(data.body)                    
                  
            );

        });             
    }
    

}