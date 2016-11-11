import { Component, OnInit } from '@angular/core';
import { TipGlasa } from '../shared/models/tipGlasa';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { TipGlasaService } from '../shared/services/tipGlasa.service';

@Component({
    moduleId: module.id,
    selector: 'app-tip-glasa',
    templateUrl: 'tipGlasa.component.html'    
})
export class TipGlasaComponent implements OnInit {
    tipGlasa:TipGlasa[];
    constructor(private service:TipGlasaService, private modalService: NgbModal) { } // potrebno za rad modala

    open(content:any) { // potrebno za rad modala
        this.modalService.open(content);
    }

    ngOnInit() { 
        this.service.getList().subscribe(data => this.tipGlasa = data);   
    }
}