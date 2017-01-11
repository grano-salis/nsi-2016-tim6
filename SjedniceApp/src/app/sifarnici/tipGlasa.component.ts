import { Component, OnInit } from '@angular/core';
import { TipGlasa } from '../shared/models/tipGlasa';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { TipGlasaService } from '../shared/services/tipGlasa.service';
import { Status } from '../shared/models/status';
import { SpinnerService } from '../shared/services/spinner.service';

@Component({    
    selector: 'app-tip-glasa',
    templateUrl: 'tipGlasa.component.html'    
})
export class TipGlasaComponent implements OnInit {
    tipoviGlasa:TipGlasa[];

    tipGlasa: TipGlasa = new TipGlasa(0, ""); // u ovaj će se spremati kreirani model

    status: Status;

    constructor(private service:TipGlasaService, private modalService: NgbModal) { } // potrebno za rad modala

    open(content:any) { // potrebno za rad modala
        this.modalService.open(content);
    }

    ngOnInit() { 
        this.service.getList().subscribe(data => this.tipoviGlasa = data);   
    }
    
    create(tipGlasa: TipGlasa) {
        this.service.addEntity(tipGlasa)
            .subscribe(data => this.tipoviGlasa.push(data));
    }

    deleteEntity(tipGlasa: TipGlasa) {
        this.service.deleteEntity(tipGlasa.id)
            .subscribe(data => this.status = data);

        var index = this.tipoviGlasa.indexOf(tipGlasa, 0);
        if (index > -1) {
            this.tipoviGlasa.splice(index, 1);
        }
    }
}