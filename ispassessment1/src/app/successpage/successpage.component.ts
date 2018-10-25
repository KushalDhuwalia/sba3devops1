import { Component, OnInit } from '@angular/core';
import { Order } from '../model/order';
import { OrderService } from '../service/order.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-successpage',
  templateUrl: './successpage.component.html',
  styleUrls: ['./successpage.component.css']
})
export class SuccesspageComponent implements OnInit {

  order: Order;
  orderId: number;
  constructor(private orderService: OrderService
    , private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe(
      (params) => {
        // tslint:disable-next-line:prefer-const
         this.orderId = params['orderId'];
         this.orderService.getOrderById(this.orderId).subscribe(
          (data) => this.order = data
        );
      }
    );
    console.log(this.order);
  }
}