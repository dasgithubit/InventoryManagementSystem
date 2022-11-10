import { Component, OnInit } from '@angular/core';
import { Order } from '../order';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  // creating object, no need to pass values, we'll get values from the form that i want to populate in order object
  public order: Order= new Order(0,0);

  constructor(private service:Order) { }

  ngOnInit(): void {
  }

}
