import { UserInfo } from '../../shared/models/userInfo';
import { TipUcesnika } from '../../shared/models/tipUcesnika';
import { StatusUcesnika } from '../../shared/models/statusUcesnika';

export class Ucesnik {
    id: number;
    uposlenik_id: number;
    userInfo: UserInfo;
    sjednica_id: number;
    tip_ucesnika_id: number;
    tipUcesnika: TipUcesnika;
    status_ucesnika_id: number;
    statusUcesnika: StatusUcesnika;

    /**
     *
     */
    constructor(userInfo: UserInfo, sjednicaId : number, tipUcesnika: TipUcesnika, statusUcesnika: StatusUcesnika) {
        this.userInfo = userInfo;
        this.sjednica_id = sjednicaId;
        this.statusUcesnika = statusUcesnika;
        this.tipUcesnika = tipUcesnika;
    }

    getPrezimeIIme() : string {
        return this.userInfo.lastName + " " + this.userInfo.firstName;
    }
   
}