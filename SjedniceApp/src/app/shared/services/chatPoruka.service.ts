import { $WebSocket, WebSocketSendMode } from 'angular2-websocket/angular2-websocket';

import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { Sjednica } from '../models/sjednica';
import { Status } from '../models/status';

import { iService } from '../services/iService';
import { ChatPoruka } from '../models/chatPoruka';

@Injectable()
export class ChatPorukaService {



}