import { Component, OnInit } from '@angular/core';
import { CocktailService } from 'src/app/services/cocktail.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public cocktail:any;

  public input:any;

  constructor(private ps:CocktailService) { }

  ngOnInit(): void {
    // this.ps.getrandomCocktail().subscribe(
    //   (data:any) =>{
    //     this.cocktail = data;
    //     console.log(this.cocktail)
    //   },
    //   () => {
    //     this.cocktail = null;
    //     console.log("Whoops no drink for you");
    //   }
    // )
  }

  getByName(): void{
    this.ps.getCocktailFromApi(this.input).subscribe(
      (data:any) => {
        this.cocktail= data;
      },
      () => {
        this.cocktail = null;
        console.log("Whoops no drink for you");
      }
    )
  }
}
