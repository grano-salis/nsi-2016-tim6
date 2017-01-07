import { Component } from '@angular/core';
import { SpinnerService } from './shared/services/spinner.service';

@Component({
    selector: 'spinner-component',
    templateUrl: 'spinner.component.html'
})
export class SpinnerComponent {
    public active: boolean;

    public constructor(spinner: SpinnerService) {
        spinner.status.subscribe((status: boolean) => {
            this.active = status;
        });
    }
}