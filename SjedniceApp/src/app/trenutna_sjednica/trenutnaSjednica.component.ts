import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';

import { UrlProvider } from '../app.url';

import { SjedniceService } from '../shared/services/sjednice.service';
import { UserInfoService } from '../shared/services/userInfo.service';
import { UcesnikService } from '../shared/services/ucesnik.service';
import { StavkaDnevnogRedaService } from '../shared/services/stavkaDr.service';
import { GlasService } from '../shared/services/glas.service';
import { ChatPorukaService } from '../shared/services/chatPoruka.service';
import { StatusStavkeDnevnogRedaService } from '../shared/services/statusStavkeDr.service';
import { PrilogService } from '../shared/services/prilog.service';

import { User } from '../shared/models/user';
import { ChatPoruka } from '../shared/models/chatPoruka';
import { Sjednica } from '../shared/models/sjednica';
import { UserInfo } from '../shared/models/userInfo';
import { Ucesnik } from '../shared/models/ucesnik';
import { StavkaDr } from '../shared/models/stavkaDr';
import { Glas } from '../shared/models/glas';
import { StatusStavkeDR } from '../shared/models/statusStavkeDr';
import { StatusSjednice } from '../shared/models/statusSJednice';
import { Prilog } from '../shared/models/prilog';

var SockJS = require('sockjs-client');
var Stomp = require('stompjs');


@Component({
    selector: 'app-trenutna-sjednica',
    templateUrl: 'trenutnaSjednica.component.html',
    providers: [NgbDropdownConfig]
})
export class TrenutnaSjednicaComponent implements OnInit {
    private stompClient: any;

    private sjednica: Sjednica = new Sjednica();

    private precjedavajuci: Ucesnik;
    private ucesnik: Ucesnik;
    private ucesnici: Ucesnik[] = [];
    private prilozi: Prilog[] = [];

    private statusiStavkeDr: StatusStavkeDR[] = [];
    private aktivnaStavka: StavkaDr = new StavkaDr();
    private stavkeDr: StavkaDr[] = [];

    private chatPoruka: ChatPoruka = new ChatPoruka();
    private messages: ChatPoruka[] = [];

    private omogucenoGlasanje: boolean = false;
    private glasovi: Glas[] = [];
    private brojZaAktivnu: number = 0;
    private brojProtivAktivnu: number = 0;
    private brojSuzdrzanAktivnu: number = 0;

    private user: User;

    constructor(
        //private statusStavkeDnevnogRedaService: StatusStavkeDnevnogRedaService,        
        private url: UrlProvider,
        private route: ActivatedRoute,
        private sjedniceService: SjedniceService,
        private ucesnikService: UcesnikService,
        private stavkaDrService: StavkaDnevnogRedaService,
        private chatService: ChatPorukaService,
        private glasService: GlasService,
        private prilogService: PrilogService,
        private userInfoService: UserInfoService
    ) {
        this.connect();
    }


    connect() {
        var that = this;
        var socket = new SockJS(this.url.webSocketUrlChat);
        this.stompClient = Stomp.over(socket);
        this.stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            that.stompClient.subscribe('/topic/messages', data => {
                let message = JSON.parse(data.body) as ChatPoruka;
                let ucesnik = that.ucesnici.find(s => s.id == message.ucesnikId).userInfo;
                message.posiljaoc = ucesnik.firstName + " " + ucesnik.lastName;
                that.messages.push(message);
            });
            that.stompClient.subscribe('/topic/aktivnastavkadr', data => {
                that.aktivnaStavka = JSON.parse(data.body);
                that.glasService.getListByStavkaDnevnogRedaId(that.aktivnaStavka.id).subscribe(s => that.initGlasovi(s));

            });
            that.stompClient.subscribe('/topic/omoguciglasanje', data => that.omogucenoGlasanje = JSON.parse(data.body));
            that.stompClient.subscribe('/topic/glas', data => {
                that.glasovi.push(JSON.parse(data.body))
                that.brojZaAktivnu = that.glasovi.filter(s => s.tipGlasaId == 1 && s.stavkaDnevnogRedaId == that.aktivnaStavka.id).length;
                that.brojProtivAktivnu = that.glasovi.filter(s => s.tipGlasaId == 2 && s.stavkaDnevnogRedaId == that.aktivnaStavka.id).length;
                that.brojSuzdrzanAktivnu = that.glasovi.filter(s => s.tipGlasaId == 3 && s.stavkaDnevnogRedaId == that.aktivnaStavka.id).length;
            });

        });
    }

    ngOnInit() {
        this.route.params
            .switchMap((params: Params) => this.sjedniceService.get(+params['id']))
            .subscribe(sjednica => this.init(sjednica));
    }

    private init(sjednica) {

        this.sjednica = sjednica;

        this.ucesnikService
            .getListBySjednicaId(this.sjednica.id)
            .subscribe(data => {
                this.ucesnici = data;
                this.precjedavajuci = data.find(s => s.tipUcesnika.id == 2);
                this.userInfoService.getUser().subscribe(user => {
                    this.ucesnik = data.find(s => s.userInfo.id == user.UserId);
                    this.user = user;
                });
            });

        this.prilogService.getListBySjednicaId(this.sjednica.id)
            .subscribe(data => this.prilozi = data);

        this.stavkaDrService.getListBySjednicaId(this.sjednica.id).subscribe(data => {
            this.stavkeDr = data;
            this.aktivnaStavka = this.stavkeDr.find(s => s.statusStavkeDrId == 4);
            if (this.aktivnaStavka == null) this.aktivnaStavka = new StavkaDr();
            else {//init glasova za aktivnu
                this.glasService.getListByStavkaDnevnogRedaId(this.aktivnaStavka.id).subscribe(s => this.initGlasovi(s));
                this.chatService.getListByStavkaDnevnogRedaId(this.aktivnaStavka.id).subscribe(s => {
                    s.forEach(s => s.posiljaoc = this.ucesnici.find(u => u.id == s.ucesnikId).userInfo.firstName + " " + this.ucesnici.find(u => u.id == s.ucesnikId).userInfo.lastName);
                    this.messages = s;
                });
            }
        });



    }


    initGlasovi(glasovi: Glas[]) {
        this.glasovi = glasovi;
        this.brojZaAktivnu = this.glasovi.filter(s => s.tipGlasaId == 1).length;
        this.brojProtivAktivnu = this.glasovi.filter(s => s.tipGlasaId == 2).length;
        this.brojSuzdrzanAktivnu = this.glasovi.filter(s => s.tipGlasaId == 3).length;
        this.chatService.getListByStavkaDnevnogRedaId(this.aktivnaStavka.id).subscribe(s => {
            s.forEach(s => s.posiljaoc = this.ucesnici.find(u => u.id == s.ucesnikId).userInfo.firstName + " " + this.ucesnici.find(u => u.id == s.ucesnikId).userInfo.lastName);
            this.messages = s;
        });
    }

    postaviZaAktivnuStavku(stavkaDr: StavkaDr) {
        this.stompClient.send('/app/sendaktivnastavkadr', {}, JSON.stringify(stavkaDr));

        this.brojZaAktivnu = this.glasovi.filter(s => s.tipGlasaId == 1 && s.stavkaDnevnogRedaId == stavkaDr.id).length;
        this.brojProtivAktivnu = this.glasovi.filter(s => s.tipGlasaId == 2 && s.stavkaDnevnogRedaId == stavkaDr.id).length;
        this.brojSuzdrzanAktivnu = this.glasovi.filter(s => s.tipGlasaId == 3 && s.stavkaDnevnogRedaId == stavkaDr.id).length;

    }

    omogucavanjeGlasanja(omoguciti: boolean) {
        console.log(omoguciti);
        this.stompClient.send('/app/sendomoguciglasanje', {}, JSON.stringify(omoguciti));
    }

    sendMsg() {
        this.chatPoruka.stavkaDnevnogRedaId = this.aktivnaStavka.id;
        this.chatPoruka.ucesnikId = this.ucesnik.id;
        this.chatPoruka.vrijeme = new Date();
        this.stompClient.send('/app/send', {}, JSON.stringify(this.chatPoruka));
    }

    glasaj(tipGlasa: number) {
        let glas = new Glas();
        glas.stavkaDnevnogRedaId = this.aktivnaStavka.id;
        glas.tipGlasaId = tipGlasa;
        glas.ucesnikId = this.ucesnik.id; //! kasnije treba promijeniti na pravog učesnika        
        this.stompClient.send('/app/sendglas', {}, JSON.stringify(glas));
    }
    svrsiSjednicu() {
        this.sjednica.statusSjednice = new StatusSjednice(3, "Završena"); // postavljanje sjednice na "U toku" i pozivanje update servisa
        this.sjednica.datumOdrzavanjaDo = new Date();
        this.sjedniceService.update(this.sjednica).subscribe(data => this.sjednica = data);
    }

    downloadPrilog(prilog: Prilog) {
        //
    }
}