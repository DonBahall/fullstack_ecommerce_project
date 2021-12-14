import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/service/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  public products:any=[];
  public grandTotal:number=0;
  constructor(private cartServive : CartService) { }//cart service

  ngOnInit(): void {
    this.cartServive.getProducts()
    .subscribe(res=>{
      this.products=res;
      this.grandTotal=this.cartServive.getTotalPrice();
    })
  }
  removeItem(item:any){
    this.cartServive.removeCartItem(item);
  }
  emptycart(){
    this.cartServive.removeAllCart();
  }

}
