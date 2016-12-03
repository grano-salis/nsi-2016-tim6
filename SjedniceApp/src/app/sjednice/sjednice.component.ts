import { Component, OnInit } from '@angular/core';
import { Sjednica } from '../shared/models/sjednica';
import { StatusSjednice } from '../shared/models/statusSjednice';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { SjedniceService } from '../shared/services/sjednice.service';
import { StatusSjedniceService } from '../shared/services/statusSjednice.service';

import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';


@Component({
    selector: 'app-sjednice',
    templateUrl: 'sjednice.component.html'
})
export class SjedniceComponent implements OnInit {
    sjednice: Sjednica[] = [];
    statusiSjednice: StatusSjednice[];

    sjednica: Sjednica = new Sjednica(); // u ovaj će se spremati kreirani model    

    datumOd: NgbDateStruct;

    constructor(
        private service: SjedniceService,
        private statusSjedniceService: StatusSjedniceService,
        private modalService: NgbModal
    ) { }

    ngOnInit() {
        //subscribe služi da se pretplatimo na observable objekat koji se vraća iz servisa
        this.service.getList().subscribe(data => this.sjednice = data);
        this.statusSjedniceService.getList().subscribe(data => this.statusiSjednice = data);
    }

    open(content: any) { // potrebno za rad modala
        this.modalService.open(content);
    }

    create(sjednica: Sjednica) {
        sjednica.statusSjednice = new StatusSjednice(7, "xxx"); //OVO JE ID STATUSA "U PRIPREMI", xxx - svejedno sta ce pisati ko naziv       

        sjednica.datumOdrzavanjaOd = new Date(this.datumOd.year, this.datumOd.month, this.datumOd.day);        

        this.service.create(sjednica)
            .subscribe(data => this.sjednice.push(data));
    }

}