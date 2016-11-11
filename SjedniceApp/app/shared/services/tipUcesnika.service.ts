import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { TipUcesnika } from '../models/tipUcesnika';

@Injectable()
export class TipUcesnikaService {    

    constructor(private http: Http, private url: UrlProvider ) { }

    getList() : Observable<TipUcesnika[]> {        
        return this.http.get(this.url.tipUcesnika + "/list")
            .map((response: Response) => response.json());            
    }
}
