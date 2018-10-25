import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Plan } from '../model/plan';
import { Order } from '../model/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  baseUrl1: string;
  baseUrl2: string;
  constructor(private http: Http) {
    this.baseUrl1 = "http://localhost:5050/order";
    this.baseUrl2 = "http://localhost:5050/package";
  }

  getSearchUrl(field: string, value: string): string {
    return this.baseUrl2 + "/" + field + "/" + value;
  }
  getBaseUrlById(id: number): string {
    return this.baseUrl1 + "/" + id;
  }

  getJsonContentTypeHeader(): RequestOptions {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return new RequestOptions({ headers: headers });
  }

  getAllplans(): Observable<Plan[]> {
    return this.http.get(this.baseUrl2).pipe(
      map(data => data.json())
    );
  }

  searchPlans(field: string, value: string): Observable<Plan[]> {
    return this.http.get(this.getSearchUrl(field,value)).pipe(
      map(data => data.json())
    );
  }
  addOrder(order: Order): Observable<Order> {
    return this.http.post(this.baseUrl1, JSON.stringify(order), this.getJsonContentTypeHeader()).pipe(
      map(data => data.json())
    );
  }
  getOrderById(id: number): Observable<Order> {
    return this.http.get(this.getBaseUrlById(id)).pipe(
      map(data => data.json())
    );
  }

}
