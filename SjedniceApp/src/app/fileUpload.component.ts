import { Component, ElementRef, Input } from '@angular/core';

@Component({
    selector: 'file-upload',
    template: '<input type="file">'
})
export class FileUploadComponent {
    constructor(private el: ElementRef) { }
    @Input()
    file: FileList;

    getFile() {
        return this.file;
    }

    upload() : FileList {
        let inputEl = this.el.nativeElement.firstElementChild;
        if (inputEl.files.length > 0) { // a file was selected
            this.file = inputEl.files[0];            
        }
        return this.file;
    }
}