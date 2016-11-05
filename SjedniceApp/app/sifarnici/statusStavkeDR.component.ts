import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { StatusStavkeDR } from '../shared/models/statusStavkeDR';

@Component({
    moduleId: module.id,
    selector: 'app-status-stavke-dr',
    templateUrl: 'statusStavkeDR.component.html'    
})
export class StatusStavkeDRComponent implements OnInit {
    statusStavkeDR: StatusStavkeDR[];
    
    constructor(private modalService: NgbModal) { } // potrebno za rad modala

    open(content:any) { // potrebno za rad modala
        this.modalService.open(content);
    }

    ngOnInit() { 

    }
}