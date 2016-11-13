import { Component, OnInit } from '@angular/core';
import { StatusStavkeDR } from '../shared/models/statusStavkeDR';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { StatusStavkeDRService } from '../shared/services/statusStavkeDR.service';
import { Status } from '../shared/models/status';

@Component({
    moduleId: module.id,
    selector: 'app-status-stavkeDR',
    templateUrl: 'statusStavkeDR.component.html'    
})
export class StatusStavkeDrComponent implements OnInit {
    statusiStavkeDR:StatusStavkeDR[];

    statusStavkeDR: StatusStavkeDR = new StatusStavkeDR(); // u ovaj će se spremati kreirani model

    status: Status;
    constructor(private service:StatusStavkeDRService, private modalService: NgbModal) { } // potrebno za rad modala

    open(content:any) { // potrebno za rad modala
        this.modalService.open(content);
    }

    ngOnInit() { 
        this.service.getList().subscribe(data => this.statusiStavkeDR = data);   
    }

      create(statusStavkeDR: StatusStavkeDR) {
        this.service.addEntity(statusStavkeDR)
            .subscribe(data => this.statusiStavkeDR.push(data));
    }

    deleteEntity(statusStavkeDR: StatusStavkeDR) {
        this.service.deleteEntity(statusStavkeDR.id)
            .subscribe(data => this.status = data);

        var index = this.statusiStavkeDR.indexOf(statusStavkeDR, 0);
        if (index > -1) {
            this.statusiStavkeDR.splice(index, 1);
        }
    }
}