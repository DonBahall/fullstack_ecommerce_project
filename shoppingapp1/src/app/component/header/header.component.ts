import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/service/cart.service';
import { LoginService } from 'src/app/service/login.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  user:any


  public totalItem:number=0;
  public searchTerm !:string;

  public loggedIn=false;

  constructor(private cartService:CartService ,private loginService:LoginService , private userService:UserService) { }

  ngOnInit(): void {

    {

      //function for dissapear
      this.loggedIn=this.loginService.isLoggedIn()
    }

    this.cartService.getProducts()
    .subscribe(res=>{
      this.totalItem=res.length;
    })
  }
  search(event:any){
    this.searchTerm=(event.target as HTMLInputElement).value;
    console.log(this.searchTerm);
    this.cartService.search.next(this.searchTerm);
  }

  logoutUser(){
    this.loginService.logOut
    location.reload()
  }

  getUser()
  {
    this.userService.getUser().subscribe(
      user=>{
        console.log(user);
        this.user=user;
      
      },
      error=>{
        console.log(error);
        
      }
    )
  }
}
