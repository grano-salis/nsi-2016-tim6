import { Component, OnInit } from '@angular/core';
import { StatusSjednice } from '../shared/models/statusSjednice';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { StatusSjedniceService } from '../shared/services/statusSjednice.service';

@Component({
    moduleId: module.id,
    selector: 'app-status-sjednice',
    templateUrl: 'statusSjednice.component.html'    
})
export class StatusSjedniceComponent implements OnInit {
    statusSjednice:StatusSjednice[];
    constructor(private service:StatusSjedniceService, private modalService: NgbModal) { } // potrebno za rad modala

    open(content:any) { // potrebno za rad modala
        this.modalService.open(content);
    }

    ngOnInit() { 
        this.service.getList().subscribe(data => this.statusSjednice = data);   
    }
}