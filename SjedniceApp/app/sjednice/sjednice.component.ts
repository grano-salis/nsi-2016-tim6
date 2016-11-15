import { Component, OnInit } from '@angular/core';
import { Sjednica } from '../shared/models/sjednica';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { SjedniceService } from '../shared/services/sjednice.service';

@Component({
    moduleId: module.id,
    selector: 'app-sjednice',
    templateUrl: './sjednice.component.html'
})
export class SjedniceComponent implements OnInit {
    sjednice: Sjednica[] = [];

    sjednica: Sjednica = new Sjednica(); // u ovaj će se spremati kreirani model    

    constructor(private service: SjedniceService, private modalService: NgbModal) { }
    ngOnInit() {
        //subscribe služi da se pretplatimo na observable objekat koji se vraća iz servisa
        this.service.getList().subscribe(data => this.sjednice = data);
    }

    open(content: any) { // potrebno za rad modala
        this.modalService.open(content);
    }

    create(sjednica: Sjednica) {
        sjednica.statusSjedniceId = 7; //OVO JE ID STATUSA "U PRIPREMI"
        this.service.addEntity(sjednica)
            .subscribe(data => this.sjednice.push(data));
    }

}