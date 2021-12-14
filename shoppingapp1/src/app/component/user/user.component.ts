import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user:any

  constructor(private userService:UserService) { }

  ngOnInit(): void {
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
