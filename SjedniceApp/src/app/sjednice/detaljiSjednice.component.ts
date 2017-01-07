import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { ActivatedRoute, Params } from '@angular/router';

import 'rxjs/add/operator/switchMap';

import { SjedniceService } from '../shared/services/sjednice.service';
import { UcesnikService } from '../shared/services/ucesnik.service';
import { StavkaDnevnogRedaService } from '../shared/services/stavkaDr.service';
import { GlasService } from '../shared/services/glas.service';
import { ChatPorukaService } from '../shared/services/chatPoruka.service';

import { Sjednica } from '../shared/models/sjednica';
import { Ucesnik } from '../shared/models/ucesnik';
import { StavkaDr } from '../shared/models/stavkaDr';
import { Glas } from '../shared/models/glas';
import { ChatPoruka } from '../shared/models/chatPoruka';

import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

@Component({
    selector: 'app-detalji-sjednice',
    templateUrl: 'detaljiSjednice.component.html'
})
export class DetaljiSjedniceComponent implements OnInit {
    private sjednica: Sjednica = new Sjednica();
    private ucesnici: Ucesnik[];
    private stavkeDr: StavkaDr[];
    
    constructor(
        private modalService: NgbModal, // potrebno za rad modala
        private route: ActivatedRoute,
        private sjedniceService: SjedniceService,
        private ucesnikService: UcesnikService,
        private stavkaDrService: StavkaDnevnogRedaService,
        private glasService: GlasService,
        private chatService: ChatPorukaService,
    ) { }

    open(content: any) { // potrebno za rad modala
        this.modalService.open(content);
    }


    ngOnInit() {
        this.route.params
            .switchMap((params: Params) => this.sjedniceService.get(+params['id']))
            .subscribe(sjednica => this.init(sjednica));
    }
    date: Date;

    private init(sjednica) {
        
        this.sjednica = sjednica;

        this.ucesnikService.getListBySjednicaId(this.sjednica.id).subscribe(s => this.ucesnici = s);
        this.stavkaDrService.getListBySjednicaId(this.sjednica.id).subscribe(s => {
            
            s.forEach(stavka => {    
                stavka.brojZa =  stavka.glasovi.filter(f => f.tipGlasaId == 1).length;
                stavka.brojProtiv = stavka.glasovi.filter(f => f.tipGlasaId == 2).length;
                stavka.brojSuzdrzanih = stavka.glasovi.filter(f => f.tipGlasaId == 3).length;         
                stavka.poruke.forEach(poruka => poruka.posiljaoc = this.ucesnici.find(p => p.id == poruka.ucesnikId).userInfo.firstName + " " + this.ucesnici.find(p => p.id == poruka.ucesnikId).userInfo.lastName);
            });

            this.stavkeDr = s;            
        });
    }


}