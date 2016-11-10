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
    constructor(private service : SjedniceService) { }    
    ngOnInit() { 

        //subscribe služi da se pretplatimo na observable objekat koji se vraća iz servisa
        this.service.getList().subscribe(data => this.sjednice = data);        
    }
}