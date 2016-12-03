import { StatusSjednice } from '../../shared/models/statusSjednice';

export class Sjednica {
    id: number;
    naziv: string;
    datumOdrzavanjaOd: Date;
    datumOdrzavanjaDo: Date;
    sala: string;
    statusSjedniceId: number;
    statusSjednice: StatusSjednice;
    dnevniRedId: number;
    zapisnikId: number;
}