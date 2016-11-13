import { Component, OnInit } from '@angular/core';
import { TipUcesnika } from '../shared/models/tipUcesnika';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { TipUcesnikaService } from '../shared/services/tipUcesnika.service';
import { Status } from '../shared/models/status';

@Component({
    moduleId: module.id,
    selector: 'app-tip-ucesnika',
    templateUrl: 'tipUcesnika.component.html'    
})
export class TipUcesnikaComponent implements OnInit {
    tipoviUcesnika:TipUcesnika[];
    tipUcesnika: TipUcesnika = new TipUcesnika(); // u ovaj će se spremati kreirani model

    status: Status;
    constructor(private service:TipUcesnikaService, private modalService: NgbModal) { } // potrebno za rad modala

    open(content:any) { // potrebno za rad modala
        this.modalService.open(content);
    }

    ngOnInit() { 
        this.service.getList().subscribe(data => this.tipoviUcesnika = data);   
    }
    
    create(tipUcesnika: TipUcesnika) {
        this.service.addEntity(tipUcesnika)
            .subscribe(data => this.tipoviUcesnika.push(data));
    }

    deleteEntity(tipUcesnika: TipUcesnika) {
        this.service.deleteEntity(tipUcesnika.id)
            .subscribe(data => this.status = data);

        var index = this.tipoviUcesnika.indexOf(tipUcesnika, 0);
        if (index > -1) {
            this.tipoviUcesnika.splice(index, 1);
        }
    }
}