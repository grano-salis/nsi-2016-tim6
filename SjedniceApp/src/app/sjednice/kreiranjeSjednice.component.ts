import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // potrebno za rad modala
import { ActivatedRoute, Params } from '@angular/router';

import 'rxjs/add/operator/switchMap';

import { SjedniceService } from '../shared/services/sjednice.service';
import { UserInfoService } from '../shared/services/userInfo.service';

import { Sjednica } from '../shared/models/sjednica';
import { UserInfo } from '../shared/models/userInfo';

import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

@Component({
    selector: 'app-kreiranje-sjednice',
    templateUrl: 'kreiranjeSjednice.component.html'
})
export class KreiranjeSjedniceComponent implements OnInit {
    private sjednica: Sjednica = new Sjednica();
    private users: UserInfo[];
    private selcetedUser: UserInfo = new UserInfo();

    private datumOd: NgbDateStruct;

    constructor(
        private modalService: NgbModal, // potrebno za rad modala
        private route: ActivatedRoute,
        private sjedniceService: SjedniceService,
        private userInfoService: UserInfoService
    ) { }

    open(content: any) { // potrebno za rad modala
        this.modalService.open(content);
    }


    ngOnInit() {
        this.route.params
            .switchMap((params: Params) => this.sjedniceService.get(+params['id']))
            .subscribe(sjednica => this.init(sjednica));
    }
    date: Date;
    private init(sjednica) {

        this.sjednica = sjednica;
        this.date = new Date(this.sjednica.datumOdrzavanjaOd);
        this.datumOd = { year: this.date.getUTCFullYear(), month: this.date.getUTCMonth() + 1, day: this.date.getUTCDay() };

        this.userInfoService.getList().subscribe(data => this.users = data);
    }


}