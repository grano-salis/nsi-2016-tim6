import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { StatusUcesnika } from '../models/StatusUcesnika';
import { Status } from '../models/status';

@Injectable()
export class StatusUcesnikaService {    

    constructor(private http: Http, private url: UrlProvider ) { }

    getList() : Observable<StatusUcesnika[]> {        
        return this.http.get(this.url.statusUcesnika + "/list")
            .map((response: Response) => response.json());            
    }

    addEntity(statusUcesnika: StatusUcesnika): Observable<StatusUcesnika> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        console.log(JSON.stringify(statusUcesnika));
        return this.http.post(this.url.statusUcesnika + "/create", JSON.stringify(statusUcesnika), options)
            .map((response: Response) => response.json());            
    }

    deleteEntity(id:number) : Observable<Status> {
        return this.http.delete(this.url.statusUcesnika + "/delete/" + id.toString())
        .map((response: Response) => response.json());
    }
}
