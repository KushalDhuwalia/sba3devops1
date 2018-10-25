import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string;
  logoUrl: string;
  field: string = "maxSpeed";
  srchValue: string = "";
  constructor(
    private router: Router
  ) {
    this.title = "Tarangini ISP";
    this.logoUrl = "/assets/Images/adbLogo.png";
  }

  doSearch() {
    this.router.navigate(["/listplans"], { queryParams: { field: this.field, srchValue: this.srchValue } });
  }

  doChangeField(field, ele) {
    this.field = field;
    this.srchValue = "";
    switch (field) {
      case 'maxSpeed': ele.placeholder = "Speed"; ele.type = "text"; break;
      case 'maxUsage': ele.placeholder = "Usage"; ele.type = "text"; break;
      case 'maxCost': ele.placeholder = "Cost"; ele.type = "text"; break;
    }
  }
}
