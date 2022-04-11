import {Product} from "./product";
import {Order} from "./order";

export class OrderItem {
  id: number | undefined;
  unit_price: number | undefined;
  quantity: number | undefined;
  totalPrice: number | undefined;
  product : Product | undefined;
  order : Order | undefined;
  orderId: number | undefined;
  productId: number | undefined;
}
