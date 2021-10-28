import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CocktailComponent } from './components/cocktail/cocktail.component';
import { CocktailImageComponent } from './components/cocktail-image/cocktail-image.component';
import { IngredientComponent } from './components/ingredient/ingredient.component';
import { IngredientImageComponent } from './components/ingredient-image/ingredient-image.component';
import { UserComponent } from './components/user/user.component';
import { LoginComponent } from './components/login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    CocktailComponent,
    CocktailImageComponent,
    IngredientComponent,
    IngredientImageComponent,
    UserComponent,
    LoginComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
