import {User} from "./user";
import {Payment} from "./payment";
import { Order } from "./order";

export class Invoice {
  id: number | undefined;
  number: string | undefined;
  invoice_total: number | undefined;
  invoice_date: Date | undefined;
  due_date: Date | undefined;
  payment_date: Date | undefined;
  client: User | undefined;
  payment: Payment | undefined;
  order: Order| undefined;
}