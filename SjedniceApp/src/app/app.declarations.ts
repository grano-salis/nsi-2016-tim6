import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { SjedniceComponent } from './sjednice/sjednice.component';
import { TrenutnaSjednicaComponent } from './trenutna_sjednica/trenutnaSjednica.component';
import { KreiranjeSjedniceComponent } from './sjednice/kreiranjeSjednice.component';
import { DetaljiSjedniceComponent } from './sjednice/detaljiSjednice.component';
import { StatusSjedniceComponent } from './sifarnici/statusSjednice.component';
import { StatusStavkeDrComponent } from './sifarnici/statusStavkeDR.component';
import { StatusUcesnikaComponent } from './sifarnici/statusUcesnika.component';
import { TipUcesnikaComponent } from './sifarnici/tipUcesnika.component';
import { TipGlasaComponent } from './sifarnici/tipGlasa.component';
import { FileUploadComponent } from './fileUpload.component';
import { SpinnerComponent } from './spinner.component';
import { OrderByPipe } from "./shared/pipes/orderBy.pipe";


export const Declarations = [
    AppComponent,
    HomeComponent,
    SjedniceComponent,
    TrenutnaSjednicaComponent,
    KreiranjeSjedniceComponent,
    DetaljiSjedniceComponent,
    StatusSjedniceComponent,
    StatusStavkeDrComponent,
    StatusUcesnikaComponent,
    TipUcesnikaComponent,
    TipGlasaComponent,
    FileUploadComponent,    
    SpinnerComponent,
    OrderByPipe
]