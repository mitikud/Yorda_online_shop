import {Product} from "./product";
import {Cart} from "./cart";

export class CartItem {
  id: number | undefined;
  total_products: number | undefined;
  products: Product[] | undefined;
  cart: Cart | undefined;
}
