import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { Ucesnik } from '../models/ucesnik';
import { Status } from '../models/status';

import { iService } from '../services/iService';

@Injectable()
export class UcesnikService implements iService<Ucesnik>{

    constructor(private http: Http, private url: UrlProvider) { }

    getList(): Observable<Ucesnik[]> {
        return this.http.get(this.url.ucesnik + "/list")
            .map((response: Response) => response.json());
    }

    get(id: number): Observable<Ucesnik> {
        return this.http.get(this.url.ucesnik + "/" + id.toString())
            .map((response: Response) => response.json());
    }

    create(ucesnik: Ucesnik): Observable<Ucesnik> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        console.log(JSON.stringify(ucesnik));
        return this.http.post(this.url.ucesnik + "/create", JSON.stringify(ucesnik), options)
            .map((response: Response) => response.json());
    }

    delete(id: number): Observable<Status> {
        return this.http.delete(this.url.ucesnik + "/delete/" + id.toString())
            .map((response: Response) => response.json());
    }

    getListBySjednicaId(sjednicaId:number): Observable<Ucesnik[]> {
        return this.http.get(this.url.ucesnik + "/getListBySjednicaId/" + sjednicaId.toString())
            .map((response: Response) => response.json());
    }


}
