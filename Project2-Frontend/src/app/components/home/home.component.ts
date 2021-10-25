import { Component, OnInit } from '@angular/core';
import { CocktailService } from 'src/app/services/cocktail.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public cocktail:any;

  public cocktails: any[] = [0];

  public input:any = "";

  constructor(private ps:CocktailService) { }

  ngOnInit(): void {
   // this.ps.getrandomCocktail().subscribe(
    //   (data
    //     this.cocktail = data;
    //     console.log(this.cocktail)
    //   },
    //   () => {
    //     this.cocktail = null;
    //     console.log("Whoops no drink for you");
    //   }
    // )
    //this.getRanDrink();

    //this.fillRanDrink();

   // console.log(this.getByName("A1"))
    //console.log(this.cocktail.drinks[0])
    //console.log(this.cocktail.drinks[2])
  }


  fillRanDrink(): void{
    this.cocktails[0] = this.getRanDrink();
    this.cocktails[1] = this.getRanDrink();
    this.cocktails[2] = this.getRanDrink();
    console.log(this.cocktail.drinks[0])
    console.log(this.cocktail.drinks[2])
  }

  getRanDrink(): void {
    this.ps.getrandomCocktail().subscribe(
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
    this.ps.getCocktailFromApi(input).subscribe(
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
}
