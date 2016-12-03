import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { StatusStavkeDR } from '../models/statusStavkeDR';
import { Status } from '../models/status';
@Injectable()
export class StatusStavkeDRService {    

    constructor(private http: Http, private url: UrlProvider ) { }

    getList() : Observable<StatusStavkeDR[]> {        
        return this.http.get(this.url.statusStavkeDR + "/list")
            .map((response: Response) => response.json());            
    }
     addEntity(statusStavkeDR: StatusStavkeDR): Observable<StatusStavkeDR> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        console.log(JSON.stringify(statusStavkeDR));
        return this.http.post(this.url.statusSjednice + "/create", JSON.stringify(statusStavkeDR), options)
            .map((response: Response) => response.json());            
    }

    deleteEntity(id:number) : Observable<Status> {
        return this.http.delete(this.url.statusStavkeDR + "/delete/" + id.toString())
        .map((response: Response) => response.json());
    }
}
