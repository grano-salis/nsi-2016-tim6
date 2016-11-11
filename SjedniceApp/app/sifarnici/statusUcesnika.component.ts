import { Component, OnInit } from '@angular/core';
import { StatusUcesnika } from '../shared/models/statusUcesnika';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { StatusUcesnikaService } from '../shared/services/statusUcesnika.service';

@Component({
    moduleId: module.id,
    selector: 'app-status-ucesnika',
    templateUrl: 'statusUcesnika.component.html'    
})
export class StatusUcesnikaComponent implements OnInit {
    statusUcesnika:StatusUcesnika[];
    constructor(private service:StatusUcesnikaService, private modalService: NgbModal) { } // potrebno za rad modala

    open(content:any) { // potrebno za rad modala
        this.modalService.open(content);
    }

    ngOnInit() { 
        this.service.getList().subscribe(data => this.statusUcesnika = data);   
    }
}