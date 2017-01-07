import { Component, OnInit } from '@angular/core';
import { Sjednica } from '../shared/models/sjednica';
import { StatusSjednice } from '../shared/models/statusSjednice';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { SjedniceService } from '../shared/services/sjednice.service';
import { StatusSjedniceService } from '../shared/services/statusSjednice.service';
import { SpinnerService } from '../shared/services/spinner.service';

@Component({
    selector: 'app-sjednice',
    templateUrl: 'sjednice.component.html'
})
export class SjedniceComponent implements OnInit {
    sjednice: Sjednica[] = [];    

    sjednica: Sjednica = new Sjednica(); // u ovaj će se spremati kreirani model        
    prikaziPoruku:boolean = false;
    
    constructor(
        private service: SjedniceService,
        private statusSjedniceService: StatusSjedniceService,
        private modalService: NgbModal,
        private spinner: SpinnerService
    ) { }


    ngOnInit() {
        this.spinner.start();
        //subscribe služi da se pretplatimo na observable objekat koji se vraća iz servisa
        this.service.getList().subscribe(data => { this.sjednice = data; this.spinner.stop(); });        
    }

    open(content: any) { // potrebno za rad modala
        this.modalService.open(content);
    }

    create(sjednica: Sjednica) {
        this.spinner.start();
        sjednica.statusSjednice = new StatusSjednice(7, "U pripremi");
        this.service.create(sjednica)
            .subscribe(data => { this.sjednice.push(data); this.spinner.stop(); this.prikaziPoruku = true; });
    }

}