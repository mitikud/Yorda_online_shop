import {User} from "./user";
import {Invoice} from "./invoice";
import { PaymentMethods } from "../enums/payment-methods";

export class Payment {
  id: number | undefined;
  client: User | undefined;
  date: Date | undefined;
  amount: number | undefined;
  payment_method: PaymentMethods | undefined;
  invoice : Invoice | undefined;
  invoiceId: number | undefined;
}
