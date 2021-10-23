import { HttpClient } from '@angular/common/http';
import { variable } from '@angular/compiler/src/output/output_ast';
import { Injectable } from '@angular/core';
import { User } from './models/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {


  constructor(private http: HttpClient) {
   }
    logurl = "http://localhost:8090/login"

   login(username:String, password:String){
     return this.http.post<User>(this.logurl, {username, password})
   }

   regurl = "http://localhost:8090/register"

   register(username:String, email:String, password:String){
     return this.http.post<User>(this.regurl, {username, email, password})
   }
}

