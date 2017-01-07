import { Component, OnInit, OnDestroy  } from '@angular/core';

import { UserInfoService } from '../shared/services/userInfo.service';
import { SpinnerService } from '../shared/services/spinner.service';
import { UserInfo } from '../shared/models/userInfo';
import { User } from '../shared/models/user';

@Component({
    selector: 'app-home',
    templateUrl: 'home.component.html'
})


export class HomeComponent implements OnInit  {

    private loginMessage : string = "Dobrodošli na eSjednice";

    constructor(
        private userInfoService:UserInfoService        
    ) { }

    ngOnInit() {
        // this.userInfoService.isAuth().subscribe(s => {
        //     if(s == false)
        //      this.loginMessage = 'Niste prijavljeni na sistem. Prijavu izvršite na ovom <a href="http://do.mac.ba:88/sso/dist/">linku</a>';
        // });
    }
}
