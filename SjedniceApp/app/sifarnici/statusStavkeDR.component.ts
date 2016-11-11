import { Component, OnInit } from '@angular/core';
import { StatusStavkeDR } from '../shared/models/statusStavkeDR';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { StatusStavkeDRService } from '../shared/services/statusStavkeDR.service';

@Component({
    moduleId: module.id,
    selector: 'app-status-stavkeDR',
    templateUrl: 'statusStavkeDR.component.html'    
})
export class StatusStavkeDrComponent implements OnInit {
    statusStavkeDr:StatusStavkeDR[];
    constructor(private service:StatusStavkeDRService, private modalService: NgbModal) { } // potrebno za rad modala

    open(content:any) { // potrebno za rad modala
        this.modalService.open(content);
    }

    ngOnInit() { 
        this.service.getList().subscribe(data => this.statusStavkeDr = data);   
    }
}