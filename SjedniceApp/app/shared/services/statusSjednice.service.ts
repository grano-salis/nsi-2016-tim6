import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { StatusSjednice } from '../models/statusSjednice';

@Injectable()
export class StatusSjedniceService {    

    constructor(private http: Http, private url: UrlProvider ) { }

    getList() : Observable<StatusSjednice[]> {        
        return this.http.get(this.url.statusSjednice + "/list")
            .map((response: Response) => response.json());            
    }
}
