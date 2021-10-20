import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cocktail } from '../models/cocktail';

@Injectable({
  providedIn: 'root'
})

export class CocktailService {

  constructor(private http:HttpClient) { }

  getCocktailFromApi(cocktail:String):Observable<Cocktail>{
    return this.http.get("www.thecocktaildb.com/api/json/v1/1/search.php?s=" + cocktail) as Observable<Cocktail>
  }
}