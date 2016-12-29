import { ChatPoruka } from '../../shared/models/chatPoruka';
import { Glas } from '../../shared/models/glas';

export class StavkaDr {
    id: number;
    sjednicaId: number;
    redniBroj: number;
    naslov: string;
    opis: string;
    statusStavkeDrId: number;

    brojZa:number;
    brojProtiv: number;
    brojSuzdrzanih: number;
    poruke:ChatPoruka[];
    glasovi:Glas[];
}