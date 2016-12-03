import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { UserInfo } from '../models/userInfo';

@Injectable()
export class UserInfoService {    

    constructor(private http: Http, private url: UrlProvider ) { }

    getList() : Observable<UserInfo[]> {        
        return this.http.get(this.url.userInfo + "/list")
            .map((response: Response) => response.json());            
    }
    
}
