import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { StatusSjednice } from '../models/statusSjednice';
import { Status } from '../models/status';

@Injectable()
export class StatusSjedniceService {

    constructor(private http: Http, private url: UrlProvider) { }

    getList(): Observable<StatusSjednice[]> {
        return this.http.get(this.url.statusSjednice + "/list")
            .map((response: Response) => response.json());
    }

    get(id: number): Observable<StatusSjednice> {
        return this.http.get(this.url.statusSjednice + "/" + id.toString())
            .map((response: Response) => response.json());
    }

    addEntity(statusSjednice: StatusSjednice): Observable<StatusSjednice> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        console.log(JSON.stringify(statusSjednice));
        return this.http.post(this.url.statusSjednice + "/create", JSON.stringify(statusSjednice), options)
            .map((response: Response) => response.json());            
    }

    deleteEntity(id:number) : Observable<Status> {
        return this.http.delete(this.url.statusSjednice + "/delete/" + id.toString())
        .map((response: Response) => response.json());
    }
}
