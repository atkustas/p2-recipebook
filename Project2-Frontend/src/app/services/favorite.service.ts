import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user';

@Injectable({
    providedIn: 'root'
  })
export class FavoriteService {

    constructor(private http: HttpClient) {}

    //adding a favorite cocktail
    addFavUrl = "http://localhost:8090/addfavorite"

    addFavorite(user_id:any, drinkName:String){
        this.http.post(this.addFavUrl, {user_id, drinkName}, {withCredentials:true})
        
    }


    //viewing user favorite cocktails
    viewFavsUrl = "http://localhost:8090/viewfavorites"

    viewFavorites(user:User){
        this.http.post(this.viewFavsUrl, {user}, {withCredentials:true})

    }








}
