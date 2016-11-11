import { Component, OnInit } from '@angular/core';
import { StatusSjednice } from '../shared/models/statusSjednice';
import { Status } from '../shared/models/status';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { StatusSjedniceService } from '../shared/services/statusSjednice.service';


@Component({
    moduleId: module.id,
    selector: 'app-status-sjednice',
    templateUrl: 'statusSjednice.component.html'
})
export class StatusSjedniceComponent implements OnInit {
    statusiSjednice: StatusSjednice[];

    statusSjednice: StatusSjednice = new StatusSjednice(); // u ovaj će se spremati kreirani model

    status: Status;

    constructor(private service: StatusSjedniceService, private modalService: NgbModal) { } // potrebno za rad modala

    open(content: any) { // potrebno za rad modala
        this.modalService.open(content);
    }

    ngOnInit() {
        this.service.getList().subscribe(data => this.statusiSjednice = data);
    }

    create(statusSjednice: StatusSjednice) {
        this.service.addEntity(statusSjednice)
            .subscribe(data => this.statusiSjednice.push(data));
    }

    deleteEntity(statusSjednice: StatusSjednice) {
        this.service.deleteEntity(statusSjednice.id)
            .subscribe(data => this.status = data);

        var index = this.statusiSjednice.indexOf(statusSjednice, 0);
        if (index > -1) {
            this.statusiSjednice.splice(index, 1);
        }
    }
}