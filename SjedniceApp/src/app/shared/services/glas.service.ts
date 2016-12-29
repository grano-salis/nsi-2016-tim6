import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { Glas } from '../models/glas';
import { StavkaDr } from '../models/stavkaDr';
import { Status } from '../models/status';

import { iService } from '../services/iService';

@Injectable()
export class GlasService implements iService<Glas>{

    constructor(private http: Http, private url: UrlProvider) { }

    getList(): Observable<Glas[]> {
        return this.http.get(this.url.glas + "/list")
            .map((response: Response) => response.json());
    }

    get(id: number): Observable<Glas> {
        return this.http.get(this.url.glas + "/" + id.toString())
            .map((response: Response) => response.json());
    }

    create(Glas: Glas): Observable<Glas> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        console.log(JSON.stringify(Glas));
        return this.http.post(this.url.glas + "/create", JSON.stringify(Glas), options)
            .map((response: Response) => response.json());
    }

    update(Glas: Glas): Observable<Glas> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        console.log(JSON.stringify(Glas));
        return this.http.put(this.url.glas + "/update", JSON.stringify(Glas), options)
            .map((response: Response) => response.json());
    }


    delete(id: number): Observable<Status> {
        return this.http.delete(this.url.glas + "/delete/" + id.toString())
            .map((response: Response) => response.json());
    }

    getListByStavkaDnevnogRedaId(stavkaDnevnogRedaId:number): Observable<Glas[]> {
        return this.http.get(this.url.glas + "/getListByStavkaDrId/" + stavkaDnevnogRedaId.toString())
            .map((response: Response) => response.json());
    }
}
