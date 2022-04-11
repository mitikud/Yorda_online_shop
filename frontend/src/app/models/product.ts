import {CartItem} from "./cart-item";
import {Category} from "./category";
import {OrderItem} from "./order-item";

export class Product {
  id: number | undefined;
  name: string | undefined;
  description: string | undefined;
  price: number | undefined;
  publishedIn: Date | undefined;
  quantity: number | undefined;
  image: string | undefined;
  category: Category | undefined;
  cartItem: CartItem | undefined;
  order_items: OrderItem[] | undefined;
}
