import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions, ResponseContentType } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { Sjednica } from '../models/sjednica';
import { Status } from '../models/status';
import { Izvjestaj } from '../models/izvjestaj';

import { iService } from '../services/iService';

@Injectable()
export class SjedniceService implements iService<Sjednica>{

    constructor(private http: Http, private url: UrlProvider) { }

    //ovo je funkcija koja pomoću http-a dobavlja listu sjednica sa našeg servisa
    //observable služi za asinhrono povezivanje sa servisom, ne morate sad aman znati kako to radi
    //bitno je da stavite ovdje observable i u komponenti subscribe i radiće
    getList(): Observable<Sjednica[]> {
        return this.http.get(this.url.sjednice + "/list")
            .map((response: Response) => response.json());
    }

    get(id: number): Observable<Sjednica> {
        return this.http.get(this.url.sjednice + "/" + id.toString())
            .map((response: Response) => response.json());
    }

    create(sjednica: Sjednica): Observable<Sjednica> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        console.log(JSON.stringify(sjednica));
        return this.http.post(this.url.sjednice + "/create", JSON.stringify(sjednica), options)
            .map((response: Response) => response.json());
    }

    update(sjednica: Sjednica): Observable<Sjednica> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        console.log(JSON.stringify(sjednica));
        return this.http.put(this.url.sjednice + "/update", JSON.stringify(sjednica), options)
            .map((response: Response) => response.json());
    }


    delete(id: number): Observable<Status> {
        return this.http.delete(this.url.sjednice + "/delete/" + id.toString())
            .map((response: Response) => response.json());
    }

    getIzvjestaj(izvjestaj: Izvjestaj) : Observable<any> {        
        let headers = new Headers({ 'Content-Type': "application/json" });                                  
        let options = new RequestOptions({ headers: headers, responseType : ResponseContentType.Blob });
        console.log(JSON.stringify(izvjestaj));
        return this.http.post(this.url.izvjestaj, '{ "placeholders":' + JSON.stringify(izvjestaj) + ' }', options);
            //.map((response: Response) => response.blob());
    }
}
