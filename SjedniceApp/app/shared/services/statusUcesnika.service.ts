import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { StatusUcesnika } from '../models/StatusUcesnika';

@Injectable()
export class StatusUcesnikaService {    

    constructor(private http: Http, private url: UrlProvider ) { }

    getList() : Observable<StatusUcesnika[]> {        
        return this.http.get(this.url.statusUcesnika + "/list")
            .map((response: Response) => response.json());            
    }
}
