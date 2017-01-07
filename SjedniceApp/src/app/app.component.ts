import { Component, OnInit } from '@angular/core';
import { User } from './shared/models/user';
import { UserInfoService } from './shared/services/userInfo.service';
import { SpinnerComponent} from './spinner.component';

@Component({
    selector: 'app-root',
    templateUrl: 'app.component.html'     
})
export class AppComponent {
    isCollapsed1: boolean = true;
    isCollapsed2: boolean = true;

    user: User;

    showSpinner:boolean = false;

    constructor(private userInfoService:UserInfoService) {}
    ngOnInit() {
        //  this.userInfoService.isAuth().subscribe(s => {
        //     if(s == true) {
        //         this.userInfoService.getUser().subscribe(s => this.user = s);
        //     }
             
        // });

        this.user = new User();
        this.user.Email ="fdzafic1@etf.unsa.ba";
        this.user.FirstName = "Faris";
        this.user.LastName = "Džafić";
        this.user.UserId = 1;
        this.user.UserId = 121;

    }

    logout() {
        console.log("Logout");
        this.userInfoService.logout().subscribe(s => console.log(s));
    }
}
