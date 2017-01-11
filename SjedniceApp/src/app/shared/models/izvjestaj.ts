export class Izvjestaj {
    Naslov: string;
    Datum: string;
    Vrijeme: string;
    Sala: string;
    _Table_Ucesnici: TableUcesnici;
    _Table_StavkeDnevnogReda: TableStavkeDr;
}

export class TableUcesnici {
    columns: string[] = ["Naziv", "Tip"];
    data: TableDataUcesnici[];
}

export class TableDataUcesnici {
    constructor(naziv: string, tip: string) {
        this.Naziv = naziv;
        this.Tip = tip;
    }
    Naziv: string;
    Tip: string;
}

export class TableStavkeDr {
    columns: string[] = ["Broj", "Naziv", "Za", "Protiv", "Suzdrzan"];
    data: TableDataStavkaDr[];
}

export class TableDataStavkaDr {
    constructor(broj: string, naziv: string, za: string, protiv: string, suzdrzan: string) {
        this.Broj = broj;
        this.Naziv = naziv;
        this.Suzdrzan = suzdrzan;
        this.Za = za;
        this.Protiv = protiv;
    }
    Broj: string;
    Naziv: string;
    Za: string;
    Protiv: string;
    Suzdrzan: string;
}