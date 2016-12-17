import { Component, OnInit } from '@angular/core';
import { StatusUcesnika } from '../shared/models/statusUcesnika';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { StatusUcesnikaService } from '../shared/services/statusUcesnika.service';
import { Status } from '../shared/models/status';

@Component({    
    selector: 'app-status-ucesnika',
    templateUrl: 'statusUcesnika.component.html'    
})
export class StatusUcesnikaComponent implements OnInit {
    statusiUcesnika:StatusUcesnika[];

    statusUcesnika: StatusUcesnika = new StatusUcesnika(0, ""); // u ovaj će se spremati kreirani model

    status: Status;
    constructor(private service:StatusUcesnikaService, private modalService: NgbModal) { } // potrebno za rad modala

    open(content:any) { // potrebno za rad modala
        this.modalService.open(content);
    }

    ngOnInit() { 
        this.service.getList().subscribe(data => this.statusiUcesnika = data);   
    }

    create(statusUcesnika: StatusUcesnika) {
        this.service.addEntity(statusUcesnika)
            .subscribe(data => this.statusiUcesnika.push(data));
    }

    deleteEntity(statusUcesnika: StatusUcesnika) {
        this.service.deleteEntity(statusUcesnika.id)
            .subscribe(data => this.status = data);

        var index = this.statusiUcesnika.indexOf(statusUcesnika, 0);
        if (index > -1) {
            this.statusiUcesnika.splice(index, 1);
        }
    }
    
}