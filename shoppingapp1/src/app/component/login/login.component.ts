import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials={
    username:'',
    password:''
  }
  
  constructor(private loginService:LoginService) { }

  ngOnInit(): void {
  }
  login(){
    console.log(this.credentials);
    this.loginService.generateToken(this.credentials).subscribe(
      (response:any)=>{
        console.log(response.token);
        this.loginService.loginUser(response.token)
        window.location.href="/products"
        
      },
      error=>{
        console.log(error);
        

      }
      
    )
  }
}
