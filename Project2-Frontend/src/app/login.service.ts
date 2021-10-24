import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './models/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {


  constructor(private http: HttpClient) {
   }
    logurl = "http://localhost:8090/login"

   login(username:String, password:String){
     return this.http.post(this.logurl, {username, password}) as Observable<User>
   }

   regurl = "http://localhost:8090/register"

   register(username:String, email:String, password:String){
     return this.http.post(this.regurl, {username, email, password}) as Observable<User>
   }
}

