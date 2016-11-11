import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { StatusStavkeDR } from '../models/statusStavkeDR';

@Injectable()
export class StatusStavkeDRService {    

    constructor(private http: Http, private url: UrlProvider ) { }

    getList() : Observable<StatusStavkeDR[]> {        
        return this.http.get(this.url.statusStavkeDR + "/list")
            .map((response: Response) => response.json());            
    }
}
