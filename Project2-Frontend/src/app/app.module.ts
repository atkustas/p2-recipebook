import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CocktailComponentsComponent } from './cocktail-components/cocktail-components.component';

@NgModule({
  declarations: [
    AppComponent,
    CocktailComponent,
    CocktailComponentsComponent,
    NewCocktailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
