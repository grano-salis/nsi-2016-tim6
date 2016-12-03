import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { SjedniceRoutingModule } from './app.routing';
import { HttpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms'; // potrebno za binding na formama
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';

import { Providers } from './app.providers';
import { Declarations } from './app.declarations';

import { AppComponent } from './app.component';


@NgModule({
  imports: [BrowserModule,
   HttpModule, 
   SjedniceRoutingModule, 
   NgbModule.forRoot(), 
   FormsModule,
   ConfirmationPopoverModule.forRoot({
      confirmButtonType: 'danger' // set defaults here
    })],
  declarations: Declarations,
  bootstrap: [AppComponent],
  providers: Providers
})

export class AppModule { }