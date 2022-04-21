import { Injectable, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { CartService } from './cart.service';

@Injectable({
  providedIn: 'root'
})
export class SearchService implements OnInit{

  public searchTerm: string = '';
  

  constructor(private cartService : CartService) { }

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  search(event: any){
    this.searchTerm = (event.target as HTMLInputElement).value;
    console.log(this.searchTerm)
    this.cartService.search.next(this.searchTerm);
  }

}
