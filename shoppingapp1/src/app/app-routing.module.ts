import { NgModule, ɵɵqueryRefresh } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './component/cart/cart.component';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';
import { ProductsComponent } from './component/products/products.component';
import { SuccessComponent } from './component/success/success.component';
import { UserComponent } from './component/user/user.component';
import { AuthGuard } from './service/auth.guard';

const routes: Routes = [
  {path:'',redirectTo:'home',pathMatch:'full'},
  {path:'home',component:HomeComponent,pathMatch:'full'},
  {path:'products',component:ProductsComponent,pathMatch:'full',canActivate:[AuthGuard]},
  {path:'cart',component:CartComponent,pathMatch:'full',canActivate:[AuthGuard]},
  {path:'login',component:LoginComponent,pathMatch:'full'},
  {path:'user',component:UserComponent,pathMatch:'full',canActivate:[AuthGuard]},
  {path:'order_placed',component:SuccessComponent,pathMatch:'full',canActivate:[AuthGuard]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


