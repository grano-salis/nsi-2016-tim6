import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { Prilog } from '../models/prilog';
import { Status } from '../models/status';

import { iService } from '../services/iService';

@Injectable()
export class PrilogService implements iService<Prilog>{

    constructor(private http: Http, private url: UrlProvider) { }

    //ovo je funkcija koja pomoću http-a dobavlja listu priloga sa našeg servisa
    //observable služi za asinhrono povezivanje sa servisom, ne morate sad aman znati kako to radi
    //bitno je da stavite ovdje observable i u komponenti subscribe i radiće
    getList(): Observable<Prilog[]> {
        return this.http.get(this.url.prilog + "/list")
            .map((response: Response) => response.json());
    }

    get(id: number): Observable<Prilog> {
        return this.http.get(this.url.prilog + "/" + id.toString())
            .map((response: Response) => response.json());
    }

    create(prilog: Prilog): Observable<Prilog> {
        let headers = new Headers({ 'Content-Type': 'multipart/form-data' });
        let options = new RequestOptions({ headers: headers });
        console.log(JSON.stringify(prilog));
        return this.http.post(this.url.prilog + "/create", prilog, options)
            .map((response: Response) => response.json());
    }

    update(prilog: Prilog): Observable<Prilog> {
        let headers = new Headers({ 'Content-Type': 'multipart/form-data' });
        let options = new RequestOptions({ headers: headers });
        console.log(JSON.stringify(prilog));
        return this.http.put(this.url.prilog + "/update", JSON.stringify(prilog), options)
            .map((response: Response) => response.json());
    }


    delete(id: number): Observable<Status> {
        return this.http.delete(this.url.prilog + "/delete/" + id.toString())
            .map((response: Response) => response.json());
    }
}
