import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala

@Component({
    moduleId: module.id,
    selector: 'app-kreiranje-sjednice',
    templateUrl: 'kreiranjeSjednice.component.html'
})
export class KreiranjeSjedniceComponent implements OnInit {
    constructor(private modalService: NgbModal) { } // potrebno za rad modala

    open(content:any) { // potrebno za rad modala
        this.modalService.open(content);
    }

    ngOnInit() { }
}