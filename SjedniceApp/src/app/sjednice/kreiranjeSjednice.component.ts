import { Component, OnInit, Input, ElementRef } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { ActivatedRoute, Params } from '@angular/router';
import { Status } from '../shared/models/status';

import 'rxjs/add/operator/switchMap';

import { SjedniceService } from '../shared/services/sjednice.service';
import { UserInfoService } from '../shared/services/userInfo.service';
import { UcesnikService } from '../shared/services/ucesnik.service';
import { StavkaDnevnogRedaService } from '../shared/services/stavkaDr.service';
import { TipUcesnikaService } from '../shared/services/tipUcesnika.service';
import { PrilogService } from '../shared/services/prilog.service';
import { StatusStavkeDnevnogRedaService } from '../shared/services/statusStavkeDr.service';
import { SpinnerService } from '../shared/services/spinner.service';

import { Sjednica } from '../shared/models/sjednica';
import { UserInfo } from '../shared/models/userInfo';
import { Ucesnik } from '../shared/models/ucesnik';
import { StavkaDr } from '../shared/models/stavkaDr';
import { TipUcesnika } from '../shared/models/tipUcesnika';
import { StatusUcesnika } from '../shared/models/statusUcesnika';
import { StatusSjednice } from '../shared/models/statusSjednice';
import { Prilog } from '../shared/models/prilog';
import { StatusStavkeDR } from '../shared/models/statusStavkeDr';

import { FileUploadComponent } from '../fileUpload.component';

@Component({
    selector: 'app-kreiranje-sjednice',
    templateUrl: 'kreiranjeSjednice.component.html'
})
export class KreiranjeSjedniceComponent implements OnInit {
    private sjednica: Sjednica = new Sjednica(); // sjednica koja se uređuje

    private users: UserInfo[]; //useri u dropdown listi kod dodavanja učesnika
    private ucesnici: Ucesnik[]; //učesnici koji su već pozvani na sjednicu
    private selcetedUser: UserInfo = new UserInfo(); //u ovo se sprema selektovani user kod ododavanja učesnika    
    private tipoviUcesnika: TipUcesnika[];
    private selectedTipUcesnika: TipUcesnika = new TipUcesnika(1, "Učesnik");

    private status: Status;

    private stavkaDr: StavkaDr = new StavkaDr(); //stavka koja se dodaje
    private stavkeDr: StavkaDr[]; //dodane stavke    

    private fileUpload: File
    private prilog: Prilog = new Prilog();
    private prilozi: Prilog[] = [];

    private statusiStavkeDr: StatusStavkeDR[] = [];

    constructor(
        private modalService: NgbModal, // potrebno za rad modala
        private route: ActivatedRoute,
        private sjedniceService: SjedniceService,
        private userInfoService: UserInfoService,
        private ucesnikService: UcesnikService,
        private stavkaDrService: StavkaDnevnogRedaService,
        private tipUcesnikaService: TipUcesnikaService,
        private prilogService: PrilogService,
        //private statusStavkeDrService: StatusStavkeDnevnogRedaService,
        private el: ElementRef,
        private spinner: SpinnerService
    ) { }

    open(content: any) { // potrebno za rad modala
        this.modalService.open(content);
    }


    ngOnInit() {
        this.spinner.start();
        this.route.params
            .switchMap((params: Params) => this.sjedniceService.get(+params['id']))
            .subscribe(sjednica => this.init(sjednica));
    }

    date: Date;
    private init(sjednica) {

        this.sjednica = sjednica;

        this.date = new Date(this.sjednica.datumOdrzavanjaOd);

        this.userInfoService.getList().subscribe(data => this.users = data);

        this.ucesnikService.getListBySjednicaId(this.sjednica.id).subscribe(data => this.ucesnici = data);

        this.tipUcesnikaService.getList().subscribe(data => this.tipoviUcesnika = data);

        this.stavkaDrService.getListBySjednicaId(this.sjednica.id).subscribe(data => this.stavkeDr = data);

        this.prilogService.getListBySjednicaId(this.sjednica.id).subscribe(data => this.prilozi = data);

        // this.statusStavkeDrService.getList().subscribe(data => this.statusiStavkeDr = data);
        this.spinner.stop();
    }

    pokreniSjednicu() {
        this.sjednica.statusSjednice = new StatusSjednice(2, "U toku"); // postavljanje sjednice na "U toku" i pozivanje update servisa
        this.sjedniceService.update(this.sjednica).subscribe(data => this.sjednica = data);
    }

    zavrsiKreiranje() {
        this.sjednica.statusSjednice = new StatusSjednice(1, "Kreirana"); // postavljanje sjednice na "U toku" i pozivanje update servisa
        this.sjedniceService.update(this.sjednica).subscribe(data => this.sjednica = data);
    }

    updateDetalja() {
        this.sjedniceService.update(this.sjednica).subscribe(data => this.sjednica = data);
    }

    dodajUcesnika(selectedUser: UserInfo, selectedTipUcesnika: TipUcesnika) {
        this.spinner.start();
        var ucesnik = new Ucesnik(selectedUser, this.sjednica.id, selectedTipUcesnika, new StatusUcesnika(4, "xxx"));
        this.ucesnikService.create(ucesnik).subscribe(data => { this.ucesnici.push(data); this.spinner.stop(); });
    }

    deleteUcesnik(ucesnik: Ucesnik) {
        this.ucesnikService.delete(ucesnik.id)
            .subscribe(data => this.status = data);

        var index = this.ucesnici.indexOf(ucesnik, 0);
        if (index > -1) {
            this.ucesnici.splice(index, 1);
        }
    }

    deletePrilog(prilog: Prilog) {
        this.prilogService.delete(prilog.id)
            .subscribe(data => this.status = data);

        var index = this.prilozi.indexOf(prilog, 0);
        if (index > -1) {
            this.prilozi.splice(index, 1);
        }
    }

    dodajStavkuDnevnogReda(stavka: StavkaDr) {
        this.spinner.start();
        this.stavkaDr.sjednicaId = this.sjednica.id;
        this.stavkaDr.statusStavkeDrId = 3; //nije obrađena       
        this.stavkaDrService.create(stavka).subscribe(data => {
            this.stavkeDr.push(data);
            this.prikaziPoruku = true;
            this.spinner.stop();
        });
    }

    deleteStavkaDr(stavkaDr: StavkaDr) {
        this.stavkaDrService.delete(stavkaDr.id)
            .subscribe(data => this.status = data);

        var index = this.stavkeDr.indexOf(stavkaDr, 0);
        if (index > -1) {
            this.stavkeDr.splice(index, 1);
        }
    }

    upload() {
        let inputEl = this.el.nativeElement.firstElementChild;
        if (inputEl.files.length > 0) { // a file was selected
            this.fileUpload = inputEl.files[0];
        }
    }


    dodajPrilog() {
        this.spinner.start();
        let fromData = new FormData();
        fromData.append("sadrzaj", this.prilog.sadrzaj, this.prilog.sadrzaj.name);
        fromData.append("naziv", this.prilog.naziv);
        fromData.append("sjednicaid", this.sjednica.id);
        this.prilogService.createFormData(fromData).subscribe(s => {
            this.prilozi.push(this.prilog);
            this.spinner.stop();
        });

    }

    openModalForEditStavkaDr(content: any, id: number) { // potrebno za rad modala        
        this.stavkaDr = this.stavkeDr.find(s => s.id == id);
        this.modalService.open(content);
    }

    prikaziPoruku: boolean;
    updateStavkaDr(stavkaDr: StavkaDr) {
        this.spinner.start();
        this.stavkaDrService.update(stavkaDr).subscribe(s => {
            this.prikaziPoruku = true;
            this.spinner.stop();
        });
    }

}