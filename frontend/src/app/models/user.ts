import { Profile } from "./profile";
import {Order} from "./order";
import {Invoice} from "./invoice";
import {Payment} from "./payment";

export class User {
  id: number | undefined;
  username: string | undefined;
  password: string | undefined;
  profileId: number| undefined;
  isAdmin: boolean | undefined;
  profile: Profile | undefined;
  orders: Order[] | undefined;
  invoices: Invoice[] | undefined;
  payments: Payment[] | undefined;
}