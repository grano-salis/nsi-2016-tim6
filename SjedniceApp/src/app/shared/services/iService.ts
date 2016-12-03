import { Observable } from 'rxjs/Observable';
import { Status } from '../models/status';


//interface za svaki od servisa
export interface iService<T> {
  get(id:number): Observable<T>;
  getList(): Observable<T[]>;
  create(T): Observable<T>;
  delete(id:number): Observable<Status>;
}