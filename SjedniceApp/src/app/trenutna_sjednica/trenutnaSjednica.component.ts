import { Component, OnInit } from '@angular/core';

import { ChatPoruka } from '../shared/models/chatPoruka';

import { UrlProvider } from '../app.url';

import { ChatPorukaService } from '../shared/services/chatPoruka.service';

@Component({
    selector: 'app-trenutna-sjednica',
    templateUrl: 'trenutnaSjednica.component.html'
})
export class TrenutnaSjednicaComponent implements OnInit {
    
    cp: ChatPoruka = new ChatPoruka(1, 1, "alalalala", new Date());

    private messages: ChatPoruka[] = [];
    
    constructor(private chatService:ChatPorukaService) {
        chatService.messages.subscribe(msg => {			
			this.messages.push(msg);
		});
     }

    sendMsg() {
		console.log('new message from client: ', this.cp.poruka);        
		this.chatService.messages.next(this.cp);        
		this.cp.poruka = '';
	}

    ngOnInit() { }
}