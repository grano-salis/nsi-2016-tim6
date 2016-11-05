import { Component, OnInit } from '@angular/core';
import { Sjednica } from '../shared/models/sjednica';
import { SjedniceService } from '../shared/services/sjednice.service';

@Component({
    moduleId: module.id,
    selector: 'app-sjednice',
    templateUrl: './sjednice.component.html'
})
export class SjedniceComponent implements OnInit {
    sjednice: Sjednica[] = [];
    constructor(private sjednicaService : SjedniceService) { }    
    ngOnInit() { 
        this.sjednicaService.getSjednice().subscribe(data => this.sjednice = data);        
    }
}