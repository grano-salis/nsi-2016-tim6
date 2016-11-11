import { Component, OnInit } from '@angular/core';
import { TipUcesnika } from '../shared/models/tipUcesnika';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { TipUcesnikaService } from '../shared/services/tipUcesnika.service';

@Component({
    moduleId: module.id,
    selector: 'app-tip-ucesnika',
    templateUrl: 'tipUcesnika.component.html'    
})
export class TipUcesnikaComponent implements OnInit {
    tipUcesnika:TipUcesnika[];
    constructor(private service:TipUcesnikaService, private modalService: NgbModal) { } // potrebno za rad modala

    open(content:any) { // potrebno za rad modala
        this.modalService.open(content);
    }

    ngOnInit() { 
        this.service.getList().subscribe(data => this.tipUcesnika = data);   
    }
}