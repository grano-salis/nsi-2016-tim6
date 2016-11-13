import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { TipGlasa } from '../models/tipGlasa';
import { Status } from '../models/status';

@Injectable()
export class TipGlasaService {    

    constructor(private http: Http, private url: UrlProvider ) { }

    getList() : Observable<TipGlasa[]> {        
        return this.http.get(this.url.tipGlasa + "/list")
            .map((response: Response) => response.json());            
    }
    addEntity(tipGlasa: TipGlasa): Observable<TipGlasa> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        console.log(JSON.stringify(tipGlasa));
        return this.http.post(this.url.tipGlasa + "/create", JSON.stringify(tipGlasa), options)
            .map((response: Response) => response.json());            
    }

    deleteEntity(id:number) : Observable<Status> {
        return this.http.delete(this.url.tipGlasa + "/delete/" + id.toString())
        .map((response: Response) => response.json());
    }
}
