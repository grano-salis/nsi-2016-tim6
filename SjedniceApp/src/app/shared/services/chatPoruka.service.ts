import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { ChatPoruka } from '../models/chatPoruka';
import { StavkaDr } from '../models/stavkaDr';
import { Status } from '../models/status';

import { iService } from '../services/iService';

@Injectable()
export class ChatPorukaService implements iService<ChatPoruka>{

    constructor(private http: Http, private url: UrlProvider) { }

    getList(): Observable<ChatPoruka[]> {
        return this.http.get(this.url.chatPoruka + "/list")
            .map((response: Response) => response.json());
    }

    get(id: number): Observable<ChatPoruka> {
        return this.http.get(this.url.chatPoruka + "/" + id.toString())
            .map((response: Response) => response.json());
    }

    create(chatPoruka: ChatPoruka): Observable<ChatPoruka> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        console.log(JSON.stringify(chatPoruka));
        return this.http.post(this.url.chatPoruka + "/create", JSON.stringify(chatPoruka), options)
            .map((response: Response) => response.json());
    }

    update(chatPoruka: ChatPoruka): Observable<ChatPoruka> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        console.log(JSON.stringify(ChatPoruka));
        return this.http.put(this.url.chatPoruka + "/update", JSON.stringify(chatPoruka), options)
            .map((response: Response) => response.json());
    }


    delete(id: number): Observable<Status> {
        return this.http.delete(this.url.chatPoruka + "/delete/" + id.toString())
            .map((response: Response) => response.json());
    }

    getListByStavkaDnevnogRedaId(stavkaDnevnogRedaId:number): Observable<ChatPoruka[]> {
        return this.http.get(this.url.chatPoruka + "/getListByStavkaDrId/" + stavkaDnevnogRedaId.toString())
            .map((response: Response) => response.json());
    }
}
