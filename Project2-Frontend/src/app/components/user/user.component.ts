import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { FavoriteService } from 'src/app/services/favorite.service';
import { ReviewService } from 'src/app/services/review.service';
import { CocktailService } from 'src/app/services/cocktail.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private ls:LoginService, private fs: FavoriteService, private rs: ReviewService,
    private cs:CocktailService) { }

  public username:any;
  public password:any;
  public user:any;
  public favorite:any;
  public reviews:any;
  public review:any;
  public user_id:any;
  public drink:String = '';
  public fav1:any;
  public fav2:any;
  public fav3:any;
  public cocktail1:any;
  public cocktail2:any;
  public cocktail3:any;
  public fName:any;
  public lName:any;
  public dob:any;
  public email:any;
  public package:any;
  public favsArray:any;
  

  ngOnInit(): void {

    this.user_id = localStorage.getItem('id');
    console.log("This is the user ID: " +this.user_id);
    // this.fav1 = localStorage.getItem('fav1');
    // this.fav2 = localStorage.getItem('fav2');
    // this.fav3 = localStorage.getItem('fav3');
    this.favsArray = localStorage.getItem('favs');
    this.fName = localStorage.getItem('fName');
    this.lName = localStorage.getItem('lName');
    this.dob = localStorage.getItem('dob');
    this.email = localStorage.getItem('email');
    this.username = localStorage.getItem('un');
    this.password = localStorage.getItem('pw');

    console.log(this.fName);
    console.log(this.lName);
    console.log(this.dob);
    console.log(this.email);
    console.log(this.fName);

    this.fs.viewFavorites(this.user_id);

  }

  populateUserInfo():void{
    console.log("inside populateUserInfo");
    this.ls.getUser(this.username, this.password);
        
  }

  getFavorites(): void{
    console.log("Inside getFavorites");
    console.log(this.fav1);

    this.fs.viewFavorites(this.user_id);

    this.fav1 = localStorage.getItem('fav1');
    this.fav2 = localStorage.getItem('fav2');
    this.fav3 = localStorage.getItem('fav3');


    if(this.fav1 != null){
      this.cs.getCocktailFromApi(this.fav1).subscribe(
        (data:any) => {
          this.cocktail1 = data;
          console.log(this.cocktail1);
        }
      )
    }
    
    if(this.fav2 != null){
      this.cs.getCocktailFromApi(this.fav2).subscribe(
        (data:any) => {
          this.cocktail2 = data;
          console.log(this.cocktail2);
        }
      )
    }
    
    if(this.fav3 != null){
      this.cs.getCocktailFromApi(this.fav3).subscribe(
        (data:any) => {
          this.cocktail3 = data;
          console.log(this.cocktail3);
        }
      )
    }
    
  }

  getFavsObs():void{
    this.fs.getFavs(this.user_id).subscribe(
      (data:any) => {
        this.favorite = data;
        this.drink = data.drink_id.drink;
      }


    )
  }

  getReviews(): void{
    this.rs.viewReviews(this.user_id).subscribe(
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
