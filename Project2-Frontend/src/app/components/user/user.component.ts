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

  public userName:String = '';
  public passWord:String = '';
  public user:any;
  public favorite:any;
  public reviews:any;
  public review:any;
  public user_id:any;
  public drink:String = '';
  public favsArray = localStorage.getItem('favs');
  public fav1:any;
  public fav2:any;
  public fav3:any;
  public cocktail1:any;
  public cocktail2:any;
  public cocktail3:any;

  ngOnInit(): void {

    this.user_id = localStorage.getItem('id');
    console.log("This is the user ID: " +this.user_id);
    this.fav1 = localStorage.getItem('fav1');
    this.fav2 = localStorage.getItem('fav2');
    this.fav3 = localStorage.getItem('fav3');
    console.log(this.fav1);
    console.log(this.fav2);
    console.log(this.fav3);

  }

  getFavorites(): void{
    console.log("Inside getFavorites");
    console.log(this.fav1);

    this.fs.viewFavorites(this.user_id);

    this.cs.getCocktailFromApi(this.fav1).subscribe(
      (data:any) => {
        this.cocktail1 = data;
        console.log(this.cocktail1);
      }
    )
    this.cs.getCocktailFromApi(this.fav2).subscribe(
      (data:any) => {
        this.cocktail2 = data;
        console.log(this.cocktail2);
      }
    )
    this.cs.getCocktailFromApi(this.fav3).subscribe(
      (data:any) => {
        this.cocktail3 = data;
        console.log(this.cocktail3);
      }
    )
    
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
