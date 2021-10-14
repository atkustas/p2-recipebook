import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CocktailComponentsComponent } from './cocktail-components/cocktail-components.component';
import { NavbarComponent } from './cocktail-components/navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    CocktailComponentsComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
