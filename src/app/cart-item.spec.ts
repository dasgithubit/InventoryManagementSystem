import { CartItem } from './cart-item';
import { CartService } from './cart.service';
import { Product } from './product';

describe('CartItem', () => {
  it('should create an instance', () => {
    expect(new CartItem(this.product)).toBeTruthy();
  });
});