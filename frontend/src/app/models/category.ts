import {Product} from "./product";
import {CategoryType} from "../enums/category-type";

export class Category {
  id: number | undefined;
  name: string | undefined;
  description: string | undefined;
  products: Product[] | undefined;
  type: CategoryType | undefined;
}
