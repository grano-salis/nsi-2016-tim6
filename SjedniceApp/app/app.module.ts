import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { SjedniceRoutingModule } from './app.routing';
import { HttpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { Providers } from './app.providers';
import { Declarations } from './app.declarations';

import { AppComponent } from './app.component';


@NgModule({
  imports: [BrowserModule, HttpModule, SjedniceRoutingModule, NgbModule.forRoot()],
  declarations: Declarations,
  bootstrap: [AppComponent],
  providers: Providers
})

export class AppModule { }