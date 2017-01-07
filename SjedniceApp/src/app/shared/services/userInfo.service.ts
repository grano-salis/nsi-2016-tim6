import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { UserInfo } from '../models/userInfo';
import { User } from '../models/user';

@Injectable()
export class UserInfoService {

    constructor(private http: Http, private url: UrlProvider) { }

    getList(): Observable<UserInfo[]> {
        return this.http.get(this.url.userInfo + "/list")
            .map((response: Response) => response.json());
    }


    getUser(): Observable<User> {        
        return Observable.create(observer => {

            let xhr: XMLHttpRequest = new XMLHttpRequest();


            xhr.onreadystatechange = () => {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        observer.next(JSON.parse(xhr.response));
                        observer.complete();
                    } else {
                        observer.error(xhr.response);
                    }
                }
            };
            xhr.withCredentials = true;
            xhr.open('GET', this.url.CheckAuth, true);
            xhr.send(null);
        });
    }

    isAuth(): Observable<boolean> {        
        return Observable.create(observer => {

            let xhr: XMLHttpRequest = new XMLHttpRequest();


            xhr.onreadystatechange = () => {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        observer.next(true);
                        observer.complete();
                    } else {
                        observer.next(false);
                    }
                }
            };
            xhr.withCredentials = true;
            xhr.open('GET', this.url.CheckAuth, true);
            xhr.send(null);
        });

    }

    logout(): Observable<any> {

        return Observable.create(observer => {
            let xhr: XMLHttpRequest = new XMLHttpRequest();
            xhr.onreadystatechange = () => {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        observer.next(JSON.parse(xhr.response));
                        observer.complete();
                    } else {
                        observer.error(xhr.response);
                    }
                }
            };
            xhr.withCredentials = true;
            xhr.open('POST', this.url.LogOut, true);
            xhr.setRequestHeader("content-type", "application/json");
            xhr.send(null);
        });

    }

}
