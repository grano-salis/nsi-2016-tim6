import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import { Subject } from 'rxjs/Rx';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { iService } from '../services/iService';
import { ChatPoruka } from '../models/chatPoruka';

import { WebSocketService } from '../services/webSocket.service';


@Injectable()
export class ChatPorukaService {

    public messages: Subject<ChatPoruka>;    

    constructor(private wsService: WebSocketService, private url: UrlProvider) {        
        this.messages = <Subject<ChatPoruka>>wsService
            .connect(this.url.webSocketUrlChat)        
            .map((response: MessageEvent): ChatPoruka => {
                let data = JSON.parse(response.data);
                return {
                    poruka: data.poruka,
                    id: data.id,
                    ucesnikId: data.ucensnikId,
                    vrijeme: data.vrijeme
                }
            });                	

    }

}