import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { StavkaDr } from '../models/stavkaDr';
import { Status } from '../models/status';

import { iService } from '../services/iService';

@Injectable()
export class StavkaDnevnogRedaService implements iService<StavkaDr>{

    constructor(private http: Http, private url: UrlProvider) { }

    getList(): Observable<StavkaDr[]> {
        return this.http.get(this.url.stavkaDr + "/list")
            .map((response: Response) => response.json());
    }

    get(id: number): Observable<StavkaDr> {
        return this.http.get(this.url.stavkaDr + "/" + id.toString())
            .map((response: Response) => response.json());
    }

    
    update(stavkaDr: StavkaDr): Observable<StavkaDr> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.put(this.url.stavkaDr + "/update", JSON.stringify(stavkaDr), options)
            .map((response: Response) => response.json());
    }

    create(ucesnik: StavkaDr): Observable<StavkaDr> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        console.log(JSON.stringify(ucesnik));
        return this.http.post(this.url.stavkaDr + "/create", JSON.stringify(ucesnik), options)
            .map((response: Response) => response.json());
    }

    delete(id: number): Observable<Status> {
        return this.http.delete(this.url.stavkaDr + "/delete/" + id.toString())
            .map((response: Response) => response.json());
    }

    getListBySjednicaId(sjednicaId:number): Observable<StavkaDr[]> {
        return this.http.get(this.url.stavkaDr + "/getListBySjednicaId/" + sjednicaId.toString())
            .map((response: Response) => response.json());
    }


}
