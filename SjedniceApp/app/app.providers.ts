import { UrlProvider } from './app.url';
import { SjedniceService } from "./shared/services/sjednice.service";
import { StatusSjedniceService } from "./shared/services/statusSjednice.service";

export const Providers = [
    SjedniceService, 
    StatusSjedniceService,
    UrlProvider
]