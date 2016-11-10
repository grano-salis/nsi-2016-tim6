const base = "http://localhost:8080/SjedniceAPI"

export class UrlProvider {    
    public sjednice:string = base + "/sjednica";
    public statusSjednice:string = base + "/sifarnici/statussjednice";
}

