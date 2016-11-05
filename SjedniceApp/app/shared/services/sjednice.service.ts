import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { Sjednica } from '../models/sjednica';

@Injectable()
export class SjedniceService {    

    constructor(private http: Http, private url: UrlProvider ) { }

    getSjednice() : Observable<Sjednica[]> {        
        return this.http.get(this.url.sjednice + "/list")
            .map((response: Response) => response.json());            
    }
}
