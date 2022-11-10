import { Injectable } from '@angular/core';
import { CartItem } from './cart-item';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  remove(theCartItem: CartItem) {
    throw new Error('Method not implemented.');
  }
  decrementQuantity(theCartItem: CartItem) {
    throw new Error('Method not implemented.');
  }
  computeCartTotals() {
    throw new Error('Method not implemented.');
  }
  cartItems: CartItem[] | undefined;
  totalPrice: any;
  totalQuantity: any;
  addToCart(theCartItem: CartItem) {
    throw new Error('Method not implemented.');
  }

  constructor() { }
}
