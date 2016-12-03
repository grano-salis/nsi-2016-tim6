import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { TipUcesnika } from '../models/tipUcesnika';
import { Status } from '../models/status';

@Injectable()
export class TipUcesnikaService {    

    constructor(private http: Http, private url: UrlProvider ) { }

    getList() : Observable<TipUcesnika[]> {        
        return this.http.get(this.url.tipUcesnika + "/list")
            .map((response: Response) => response.json());            
    }

    addEntity(tipUcesnika: TipUcesnika): Observable<TipUcesnika> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        console.log(JSON.stringify(tipUcesnika));
        return this.http.post(this.url.tipUcesnika + "/create", JSON.stringify(tipUcesnika), options)
            .map((response: Response) => response.json());            
    }

    deleteEntity(id:number) : Observable<Status> {
        return this.http.delete(this.url.tipUcesnika + "/delete/" + id.toString())
        .map((response: Response) => response.json());
    }
}
