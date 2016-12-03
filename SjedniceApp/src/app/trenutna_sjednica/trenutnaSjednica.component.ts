import { $WebSocket, WebSocketSendMode } from 'angular2-websocket/angular2-websocket';
import { Component, OnInit } from '@angular/core';

import { ChatPoruka } from '../shared/models/chatPoruka';

import { UrlProvider } from '../app.url';

@Component({
    selector: 'app-trenutna-sjednica',
    templateUrl: 'trenutnaSjednica.component.html'
})
export class TrenutnaSjednicaComponent implements OnInit {
    ws: $WebSocket;
    cp:ChatPoruka = new ChatPoruka(1,1,"lalalala", new Date());
    
    constructor(private url: UrlProvider) {
        this.ws = new $WebSocket(this.url.webSocketUrlChat);

        this.ws.onMessage(
            (msg: MessageEvent) => {
                console.log("onMessage ", msg.data);
            },
            { autoApply: false }
        );

        this.ws.getDataStream().subscribe(
            (msg) => {
                console.log("next", msg.data);
                this.ws.close(false);
            },
            (msg) => {
                console.log("error", msg);
            },
            () => {
                console.log("complete");
            }
        );

    }

    sendMsg(cp:ChatPoruka) {
            
        this.ws.send(JSON.stringify(cp)).subscribe(
        (msg)=> {
            console.log("next", msg.data);
        },
        (msg)=> {
            console.log("error", msg);
        },
        ()=> {
            console.log("complete");
        }
    );

    }



    ngOnInit() { }
}