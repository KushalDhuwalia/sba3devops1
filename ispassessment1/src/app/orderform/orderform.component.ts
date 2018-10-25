import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderService } from '../service/order.service';
import { Order } from '../model/order';

@Component({
  selector: 'app-orderform',
  templateUrl: './orderform.component.html',
  styleUrls: ['./orderform.component.css']
})
export class OrderformComponent implements OnInit {
  order: Order;
  title: string;

  constructor(private activatedRoute: ActivatedRoute,
    private orderService: OrderService,
    private router: Router) { }

  ngOnInit() {
    this.order = new Order();
    this.activatedRoute.params.subscribe(
      (params) => {
        this.title = params['title'];
      }
    );
    this.order.title = this.title;
  }
  save() {
    console.log(this.order);
    this.orderService.addOrder(this.order).subscribe(
      (data) => {
        this.router.navigateByUrl('successOrder/' + data.orderId);
      },
      (error) => { alert('Your Request is  already placed'); }
    );

  }
}
