import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

import { UrlProvider } from '../app.url';

//import { WebSocketService } from '../shared/services/webSocket.service';
import { SjedniceService } from '../shared/services/sjednice.service';
import { UserInfoService } from '../shared/services/userInfo.service';
import { UcesnikService } from '../shared/services/ucesnik.service';
import { StavkaDnevnogRedaService } from '../shared/services/stavkaDr.service';

import { ChatPoruka } from '../shared/models/chatPoruka';
import { Sjednica } from '../shared/models/sjednica';
import { UserInfo } from '../shared/models/userInfo';
import { Ucesnik } from '../shared/models/ucesnik';
import { StavkaDr } from '../shared/models/stavkaDr';

var SockJS = require('sockjs-client');
var Stomp = require('stompjs');


@Component({
    selector: 'app-trenutna-sjednica',
    templateUrl: 'trenutnaSjednica.component.html'
})
export class TrenutnaSjednicaComponent implements OnInit {
    stompClient: any; 

    sjednica: Sjednica = new Sjednica();

    ucesnici: Ucesnik[] = [];
    stavkeDr: StavkaDr[] = [];

    precjedavajuci: Ucesnik;

    aktivnaStavka: StavkaDr = new StavkaDr();

    //webSocketService: WebSocketService;
    cp: ChatPoruka = new ChatPoruka(1, 1, "alalalala", new Date());

    private messages: ChatPoruka[] = [];

    constructor(
        private url: UrlProvider,
        private route: ActivatedRoute,
        private sjedniceService: SjedniceService,
        private ucesnikService: UcesnikService,
        private stavkaDrService: StavkaDnevnogRedaService
    ) {
        this.connect();
        //this.webSocketService = new WebSocketService(url, this.messages, this.stavkeDr, this.aktivnaStavka);
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
                data => that.aktivnaStavka = JSON.parse(data.body)                    
                  
            );

        });             
    }

    sendMsg() {
        this.stompClient.send('/app/send', {}, JSON.stringify(this.cp));
        //this.webSocketService.sendChatMessage(this.cp);
    }

    ngOnInit() {
        this.route.params
            .switchMap((params: Params) => this.sjedniceService.get(+params['id']))
            .subscribe(sjednica => this.init(sjednica));
    }

    private init(sjednica) {

        this.sjednica = sjednica;

        // this.sjednica.statusSjednice.id = 2; // postavljanje sjednice na "U toku" i pozivanje update servisa

        // this.sjedniceService.update(this.sjednica).subscribe(data => this.sjednica = data);                  

        this.ucesnikService
            .getListBySjednicaId(this.sjednica.id)
            .subscribe(data => { 
                this.ucesnici = data;                                 
                this.precjedavajuci = data.find(s => s.tipUcesnika.id == 2); 
                console.log(JSON.stringify(this.precjedavajuci));
            });      

        this.stavkaDrService.getListBySjednicaId(this.sjednica.id).subscribe(data =>  this.stavkeDr = data);
    }

    postaviZaAktivnuStavku(stavkaDr: StavkaDr) {
        this.stompClient.send('/app/sendaktivnastavkadr', {}, JSON.stringify(stavkaDr));  
        // this.webSocketService.sendAktivnaStavkaDr(stavkaDr);
        // console.log("LALAL" + JSON.stringify(this.aktivnaStavka));
        //this.aktivnaStavka = stavkaDr;
    }
}