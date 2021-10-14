import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CocktailComponent } from './components/cocktail/cocktail.component';
import { IngredientComponent } from './components/ingredient/ingredient.component';
import { LoginComponent } from './components/login/login.component';
import { UserComponent } from './components/user/user.component';

const routes: Routes = [

  {
    path: "user",
    component: UserComponent
  },

  {
    path: "ingredients",
    component: IngredientComponent
  },

  {
    path: "cocktails",
    component: CocktailComponent
  },

  {
    path: "login",
    component: LoginComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
