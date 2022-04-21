import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private _adminUrl = "http://localhost:3000/api/special"

  constructor(private http: HttpClient) { }

  getProducts(){
    return this.http.get<any>(this._adminUrl)
  }
}
