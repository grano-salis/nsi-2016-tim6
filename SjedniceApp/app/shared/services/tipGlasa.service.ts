import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { TipGlasa } from '../models/tipGlasa';

@Injectable()
export class TipGlasaService {    

    constructor(private http: Http, private url: UrlProvider ) { }

    getList() : Observable<TipGlasa[]> {        
        return this.http.get(this.url.tipGlasa + "/list")
            .map((response: Response) => response.json());            
    }
}
