import { UrlProvider } from './app.url';
import { SjedniceService } from "./shared/services/sjednice.service";
import { StatusSjedniceService } from "./shared/services/statusSjednice.service";
import { StatusStavkeDRService } from "./shared/services/statusStavkeDR.service";
import { StatusUcesnikaService } from "./shared/services/statusUcesnika.service";
import { TipGlasaService } from "./shared/services/tipGlasa.service";
import { TipUcesnikaService } from "./shared/services/tipUcesnika.service";
import { UserInfoService } from "./shared/services/userInfo.service";
import { ChatPorukaService } from "./shared/services/chatPoruka.service";
import { WebSocketService } from "./shared/services/webSocket.service";

export const Providers = [
    SjedniceService, 
    StatusSjedniceService,
    StatusStavkeDRService,
    StatusUcesnikaService,
    TipGlasaService,
    TipUcesnikaService,
    UserInfoService,
    UrlProvider,
    WebSocketService,
    ChatPorukaService
]