export class ChatPoruka {
    id: number;
    ucesnikId: number;
    poruka: string;
    vrijeme: Date;

    /**
     *
     */
    constructor(id:number, ucesnikId: number, poruka:string, vrijeme: Date) {
        this.id = id;
        this.ucesnikId = ucesnikId;
        this.poruka = poruka;
        this.vrijeme = vrijeme;
    }
}