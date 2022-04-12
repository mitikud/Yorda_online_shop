import {User} from "./user";

export class Profile {
  id: number | undefined;
  user: User | undefined;
  firstname: string | undefined;
  lastname: string | undefined;
  email: string | undefined;
  address!: string;
  city: string | undefined;
  country: string | undefined;
  phone: string | undefined;
  cartId!: number;

}
