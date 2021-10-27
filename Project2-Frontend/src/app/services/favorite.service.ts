import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user';
import { Observable } from 'rxjs';
import { Favorite } from '../models/favorite';

@Injectable({
    providedIn: 'root'
  })
export class FavoriteService {

    constructor(private http: HttpClient) {}

    //adding a favorite cocktail
    addFavUrl = "http://localhost:8090/addfavorite"

    async addFavorite(user_id:any, drink:String){

       var fav = {
           user_id: user_id,
           drink: drink
       }

       let response = await fetch(this.addFavUrl, {

        method: "POST",
        mode: 'cors',
        body: JSON.stringify(fav),
        credentials: "include"
    });

    if(response.status === 201){

        console.log("Favorite drink added.");
    }
        
    }


    //viewing user favorite cocktails
    viewFavsUrl = "http://localhost:8090/viewfavorites"

    async viewFavorites(user_id:any){
        console.log("Inside viewFavorites async")
        let favsArray;

        var id = {
            user_id: user_id
        }

        let response = await fetch(this.viewFavsUrl, {
 
         method: "POST",
         mode: 'cors',
         body: JSON.stringify(id),
         credentials: "include"
     });

     let data = await response.json();
 
     if(response.status === 200){
 
        console.log(data);
        favsArray = data;
        console.log("Favorites viewed");
     }
     console.log(favsArray);
     localStorage.setItem('favs', favsArray);
     
     localStorage.setItem('fav1', favsArray[0].drink_id.drink);
     localStorage.setItem('fav2', favsArray[1].drink_id.drink);
     localStorage.setItem('fav3', favsArray[2].drink_id.drink);

     
     console.log(favsArray);
     return favsArray;

    }

    getFavs(id:number):Observable<Favorite>{

        return this.http.post(this.viewFavsUrl, id) as Observable<Favorite>
    }

}
