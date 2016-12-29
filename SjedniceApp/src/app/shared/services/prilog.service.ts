import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { UrlProvider } from '../../app.url';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { Prilog } from '../models/prilog';
import { Status } from '../models/status';

import { iService } from '../services/iService';

@Injectable()
export class PrilogService implements iService<Prilog>{

    constructor(private http: Http, private url: UrlProvider) {

    }



     makeFileRequest(formData: FormData): Observable<Prilog> {
        return Observable.create(observer => {

            let xhr: XMLHttpRequest = new XMLHttpRequest();

                        
            xhr.onreadystatechange = () => {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        observer.next(JSON.parse(xhr.response));
                        observer.complete();
                    } else {
                        observer.error(xhr.response);
                    }
                }
            };
            
            xhr.open('POST', this.url.prilog2, true);
            //xhr.setRequestHeader("content-type", "multipart/form-data");
            xhr.send(formData);
        });
    }

    getList(): Observable<Prilog[]> {
        return this.http.get(this.url.prilog + "/list")
            .map((response: Response) => response.json());
    }

    get(id: number): Observable<Prilog> {
        return this.http.get(this.url.prilog + "/" + id.toString())
            .map((response: Response) => response.json());
    }

    create(prilog: Prilog): Observable<Prilog> {
        // let headers = new Headers( [
        //     { 'Content-Type': undefined }
        // ]);                
        // let options = new RequestOptions({ headers: headers });        
        return this.http.post(this.url.prilog + "/create", prilog)
            .map((response: Response) => response.json());
    }

    createFile(file: File): Observable<Prilog> {
        let headers = new Headers([
            { 'Content-Type': undefined }
        ]);
        let options = new RequestOptions({ headers: headers });
        console.log(file);
        return this.http.post(this.url.prilog + "/create", file, options)
            .map((response: Response) => response.json());
    }

    createFormData(prilog: FormData) {
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    //resolve(JSON.parse(xhr.response));                        
                } else {
                    // reject(xhr.response);
                }
            }
        };


        xhr.open("POST", this.url.prilog2, true);
        xhr.send(prilog);
    }

    update(prilog: Prilog): Observable<Prilog> {
        let headers = new Headers({ 'Content-Type': 'multipart/form-data' });
        let options = new RequestOptions({ headers: headers });
        console.log(JSON.stringify(prilog));
        return this.http.put(this.url.prilog + "/update", JSON.stringify(prilog), options)
            .map((response: Response) => response.json());
    }


    delete(id: number): Observable<Status> {
        return this.http.delete(this.url.prilog + "/delete/" + id.toString())
            .map((response: Response) => response.json());
    }
    getListBySjednicaId(sjednicaId:number): Observable<Prilog[]> {
        return this.http.get(this.url.prilog + "/getListBySjednicaId/" + sjednicaId.toString())
            .map((response: Response) => response.json());
    }
}
