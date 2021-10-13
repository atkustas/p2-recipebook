import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import {Cocktail} from '../models/cocktail'


@Injectable({
  providedIn: 'root'
})
export class CocktailServiceService {

  constructor(private http:HttpClient) { }

  getCocktailFromApi(id:number):Observable<Cocktail>{
    return this.http.get("https://the-cocktail-db.p.rapidapi.com/" + id + "/") as Observable<Cocktail>
  }
}
