import { Component, OnInit } from '@angular/core';
import { Cocktail } from 'src/app/models/cocktail';
import { User } from 'src/app/models/user';
import { CocktailService } from 'src/app/services/cocktail.service';
import { FavoriteService } from 'src/app/services/favorite.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public cocktail:any;
  public cocktails: any[] = [0];
  public input:any;
  public user_id:any;
  public drink:any;

  constructor(private cs:CocktailService, private fs:FavoriteService) { }

  ngOnInit(): void {
   
  }


  fillRanDrink(): void{
    this.cocktails[0] = this.getRanDrink();
    this.cocktails[1] = this.getRanDrink();
    this.cocktails[2] = this.getRanDrink();
    console.log(this.cocktail.drinks[0])
    console.log(this.cocktail.drinks[2])
  }

  getRanDrink(): void {
    this.cs.getrandomCocktail().subscribe(
       (data:any) =>{


         this.cocktail = data;
         //this.getRanDrink();

        // console.log(this.cocktail)
         //console.log(this.cocktail.drinks)
        //  console.log(this.cocktail.drinks[0].strDrinkThumb)



        },
       () => {
         this.cocktail = null;
         console.log("Whoops no drink for you");
       }
     )
   }

  getByName(input:String): void{
    console.log(input);
    this.cs.getCocktailFromApi(input).subscribe(
      (data:any) => {
        this.cocktail = data;
        console.log(this.cocktail);
      },
      () => {
        this.cocktail = null;
        console.log("Whoops no drink for you");
      }
    )
  }

  getByIngredient(input:String): void{
    this.cs.getCocktailByIngredient(input).subscribe(
      (data:any) => {
        this.cocktail = data;
      },
      () => {
        this.cocktail = null;
        console.log("Whoops no drink for you")
      }
    )
  }

  addFavoriteDrink(drink:any): void{

    this.user_id = 
    drink = this.drink;

    this.fs.addFavorite(this.user_id, drink)
  }


}
