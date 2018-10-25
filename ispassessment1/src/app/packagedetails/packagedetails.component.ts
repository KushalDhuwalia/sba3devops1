import { Component, OnInit } from '@angular/core';
import { Plan } from '../model/plan';
import { OrderService } from '../service/order.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-packagedetails',
  templateUrl: './packagedetails.component.html',
  styleUrls: ['./packagedetails.component.css']
})
export class PackagedetailsComponent implements OnInit {

  plans: Plan[];
  constructor(private orderService: OrderService
    , private activatedRoute: ActivatedRoute) { }

  ngOnInit() {

    this.activatedRoute.queryParams.subscribe(
      (params) => {
        // tslint:disable-next-line:prefer-const
        let field = params['field'];
        // tslint:disable-next-line:prefer-const
        let srchValue = params['srchValue'];

        if (field && srchValue) {
          this.orderService.searchPlans(field, srchValue).subscribe(
            (data) => this.plans = data,
            (err) => this.plans = undefined
          );
        } else {
          this.orderService.getAllplans().subscribe(
            (data) => this.plans = data,
            (err) => this.plans = undefined
          );
        }
      }
    );
    console.log(this.plans);
  }


}
