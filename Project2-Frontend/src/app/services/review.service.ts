import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user';
import { Observable } from 'rxjs';
import { Review } from '../models/review';

@Injectable({
    providedIn: 'root'
  })
export class ReviewService {

    constructor(private http: HttpClient) {}

    //adding a review for cocktail
    addRevUrl = "http://localhost:8090/addreview"

    addReview(user_id:any, drink:String, review:String){
        return this.http.post(this.addRevUrl, {user_id, drink, review}, {withCredentials:true})
        
    }


    //viewing user reviews for cocktails
    viewRevUrl = "http://localhost:8090/viewreview"

    viewReviews(user:User): Observable<Review> {
        return this.http.post(this.viewRevUrl, {user}, {withCredentials:true}) as Observable<Review>

    }








}