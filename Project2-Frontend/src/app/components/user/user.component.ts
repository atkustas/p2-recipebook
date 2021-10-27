import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { User } from 'src/app/models/user';
import { Package } from 'src/app/models/package';
import { FavoriteService } from 'src/app/services/favorite.service';
import { ReviewService } from 'src/app/services/review.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private ls:LoginService, private fs: FavoriteService, private rs: ReviewService) { }

  public userName:String = '';
  public passWord:String = '';
  public user:any;
  public favorite:any;
  public reviews:any;
  public review:any;
  public user_id:any;
  public drink:String = '';
  

  ngOnInit(): void {

    this.user_id = localStorage.getItem('id');
    console.log("This is the user ID: " +this.user_id)

  }

  getFavorites(): void{
    console.log("Inside getFavorites");

    this.fs.viewFavorites(this.user_id);
    
  }

  getReviews(): void{
    this.rs.viewReviews(this.user).subscribe(
      (data:any) => {
        this.reviews = data; 
        console.log(this.reviews);
      },
      () => {
        this.reviews = null;
        console.log("Cannot view reviews")
      }
    )
    
  }

  newReview(): void{
    this.rs.addReview(this.user_id, this.drink, this.review).subscribe(
      (data:any) => {
        this.review = data;
        console.log(this.review);
      },
      () => {
        this.review = null;
        console.log("Cannot add review")
      }
    )
  }


}
