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

    console.log("https:thecocktaildb.com/api/json/v1/1/search.php?s=" + cocktail);
    console.log(this.http.get("https:thecocktaildb.com/api/json/v1/1/search.php?s=" + cocktail) as Observable<Cocktail>);
    console.log(this.http)
    console.log(this.http.get)

    return this.http.get("https:thecocktaildb.com/api/json/v1/1/search.php?s=" + cocktail) as Observable<Cocktail>
  }

  getrandomCocktail():Observable<Cocktail>{

    console.log("https:thecocktaildb.com/api/json/v1/1/random.php" as unknown as Observable<Cocktail>);
    console.log(this.http.get("https:thecocktaildb.com/api/json/v1/1/random.php") as Observable<Cocktail>);
    console.log(this.http)
    console.log(this.http.get)

    return this.http.get("https:thecocktaildb.com/api/json/v1/1/random.php") as Observable<Cocktail>
  }

  getCocktailByIngredient(ingredient:String):Observable<Cocktail>{

    return this.http.get("https:thecocktaildb.com/api/json/v1/1/filter.php?i=" + ingredient) as Observable<Cocktail>
  }
}
