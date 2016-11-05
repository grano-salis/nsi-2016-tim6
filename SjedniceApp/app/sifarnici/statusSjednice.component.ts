import { Component, OnInit } from '@angular/core';
import { StatusSjednice } from '../shared/models/statusSjednice';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala

@Component({
    moduleId: module.id,
    selector: 'app-status-sjednice',
    templateUrl: 'statusSjednice.component.html'    
})
export class StatusSjedniceComponent implements OnInit {
    statusSjednice:StatusSjednice[];
    constructor(private modalService: NgbModal) { } // potrebno za rad modala

    open(content:any) { // potrebno za rad modala
        this.modalService.open(content);
    }

    ngOnInit() { 

    }
}