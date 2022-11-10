import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerRegistrationService } from '../customer-registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  customer: Customer =  new Customer();
  
  message:any;

  constructor(private service:CustomerRegistrationService ) { }

  ngOnInit(): void {
  }

  public registerNow(){
    let resp=this.service.doRegistration(this.customer)
    resp.subscribe((data: any)=>this.message=data);

  }

}
