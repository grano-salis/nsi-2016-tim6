const base = "http://localhost:8080/SjedniceAPI"

export class UrlProvider {    
    public sjednice:string = base + "/sjednica";
    public statusSjednice:string = base + "/sifarnici/statussjednice";
    public statusStavkeDR:string = base + "/sifarnici/statusStavkeDR";
    public statusUcesnika:string = base + "/sifarnici/statusUcesnika";
    public tipGlasa:string = base + "/sifarnici/tipGlasa";
    public tipUcesnika:string = base + "/sifarnici/tipUcesnika";

}

