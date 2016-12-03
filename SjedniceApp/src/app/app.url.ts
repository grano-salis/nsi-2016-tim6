const base = "http://localhost:8080/SjedniceAPI"

const basews = "ws://localhost:8080/SjedniceAPI";

export class UrlProvider {    
    public sjednice:string = base + "/sjednica";
    public statusSjednice:string = base + "/sifarnici/statussjednice";
    public statusStavkeDR:string = base + "/sifarnici/statusstavkednevnogreda";
    public statusUcesnika:string = base + "/sifarnici/statusucesnika";
    public tipGlasa:string = base + "/sifarnici/tipglasa";
    public tipUcesnika:string = base + "/sifarnici/tipucesnika";
    public userInfo:string = base + "/userinfo";    
    public chatPoruka:string = base + "/chatPoruka";
    public webSocketUrlChat:string = basews + "/chat";
}

