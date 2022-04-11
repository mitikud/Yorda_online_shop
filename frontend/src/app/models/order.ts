//import {OrderStatus} from "../enums/order-status";
import {User} from "./user";
import {OrderItem} from "./order-item";
import { Invoice } from "./invoice";

export class Order {
  id: number | undefined;
  order_date: Date | undefined;
  shipmentDate: Date | undefined;
  comments: string | undefined;
  shippedTo: string | undefined;
  user: User | undefined;
  order_items: OrderItem[] | undefined;
  invoiceId: number | undefined;
}
