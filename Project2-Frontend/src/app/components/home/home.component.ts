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
  public info:any;

  constructor(private cs:CocktailService, private fs:FavoriteService) { }

  ngOnInit(): void {

    this.user_id = localStorage.getItem('id');
    console.log("This is the user ID: " +this.user_id);
   
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
          localStorage.setItem('cocktailZero', this.cocktail.drinks[0].strDrink);
         
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

        localStorage.setItem('cocktailZero', this.cocktail.drinks[0].strDrink);
        localStorage.setItem('cocktailOne', this.cocktail.drinks[1].strDrink);
        localStorage.setItem('cocktailTwo', this.cocktail.drinks[2].strDrink);

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

        localStorage.setItem('cocktailZero', this.cocktail.drinks[0].strDrink);
        localStorage.setItem('cocktailOne', this.cocktail.drinks[1].strDrink);
        localStorage.setItem('cocktailTwo', this.cocktail.drinks[2].strDrink);

      },
      () => {
        this.cocktail = null;
        console.log("Whoops no drink for you")
      }
    )
  }

  addFavoriteDrinkZero(drink:any): void{

    this.user_id = localStorage.getItem('id');
    drink = localStorage.getItem('cocktailZero');    

    this.fs.addFavorite(this.user_id, drink);

    console.log("Favorite Drink added.");
    console.log(drink);
    console.log("This is the user ID: " +this.user_id)
    
  }

  addFavoriteDrinkOne(drink:any): void{

    this.user_id = localStorage.getItem('id');
    drink = localStorage.getItem('cocktailOne');    

    this.fs.addFavorite(this.user_id, drink);

    console.log("Favorite Drink added.");
    console.log(drink);
    console.log("This is the user ID: " +this.user_id)
    
  }

  addFavoriteDrinkTwo(drink:any): void{

    this.user_id = localStorage.getItem('id');
    drink = localStorage.getItem('cocktailTwo');    

    this.fs.addFavorite(this.user_id, drink);

    console.log("Favorite Drink added.");
    console.log(drink);
    console.log("This is the user ID: " +this.user_id)
    
  }


}
