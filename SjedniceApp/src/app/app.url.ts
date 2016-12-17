const base = "http://localhost:8080/SjedniceAPI"
//const base = "http://nsi06api.azurewebsites.net"

export class UrlProvider {    
    public sjednice:string = base + "/sjednica";
    public statusSjednice:string = base + "/sifarnici/statussjednice";
    public statusStavkeDR:string = base + "/sifarnici/statusstavkednevnogreda";
    public statusUcesnika:string = base + "/sifarnici/statusucesnika";
    public tipGlasa:string = base + "/sifarnici/tipglasa";
    public tipUcesnika:string = base + "/sifarnici/tipucesnika";
    public userInfo:string = base + "/userinfo";    
    public chatPoruka:string = base + "/chatPoruka";
    public ucesnik:string = base + "/ucesnik";
    public stavkaDr:string = base + "/stavkaDnevnogReda";
    public webSocketUrlChat:string = base + "/chat";
    public prilog:string = base + "/prilog";
}

