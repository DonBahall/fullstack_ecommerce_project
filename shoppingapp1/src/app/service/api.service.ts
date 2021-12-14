import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  constructor(private http: HttpClient) {}
  getProduct() {
    return this.http
      .get<any>("http://localhost:8080/api/getAll/products") //http://localhost:8080/api/getAll/products   // https://fakestoreapi.com/products///Get all product Url
      .pipe(
        map((res: any) => {
          return res;
        }))
      
  }
}
