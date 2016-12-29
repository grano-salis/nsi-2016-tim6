export class ChatPoruka {
    id: number;
    ucesnikId: number;
    poruka: string;
    vrijeme: Date;
    stavkaDnevnogRedaId: number;
    posiljaoc: string; //ovo je pomoćna varijabla - nema je u bazi i sadrži ime i prezime učesnika koji šalje poruku

    /**
     *
     */
    // constructor(id:number, ucesnikId: number, poruka:string, vrijeme: Date, stavkaDnevnogRedaId: number) {
    //     this.id = id;
    //     this.ucesnikId = ucesnikId;
    //     this.poruka = poruka;
    //     this.vrijeme = vrijeme;
    //     this.stavkaDnevnogRedaId = stavkaDnevnogRedaId;
    // }
}