import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { SjedniceComponent } from './sjednice/sjednice.component';
import { TrenutnaSjednicaComponent } from './trenutna_sjednica/trenutnaSjednica.component';
import { StatusSjedniceComponent } from './sifarnici/statusSjednice.component';
import { KreiranjeSjedniceComponent } from './sjednice/kreiranjeSjednice.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'sjednice', component: SjedniceComponent },
  { path: 'trenutna', component: TrenutnaSjednicaComponent },
  { path: 'sifarnici/statusSjednice', component: StatusSjedniceComponent },
  { path: 'sjednice/kreiranjeSjednice', component: KreiranjeSjedniceComponent },
  
  { path: '**', component: HomeComponent } //ova mora biti zadnja

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class SjedniceRoutingModule { }

export const routedComponents = [SjedniceComponent];
