import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerRegistrationService {

  constructor(private http:HttpClient) { }


  public doRegistration(customer:Customer){
    return this.http.post("http://localhost:8080/register",customer,{responseType:'text' as 'json'});
  }

  public getCustomers(){
    return this.http.get("http://localhost:8080/getAllCustomers");
  }

  public getCustomerByEmail(emailId:string){
    return this.http.get("http://localhost:8080/findCustomer/"+emailId);
  }

  public deleteCustomer(id:any){
    return this.http.delete("http://localhost:8080/cancel/"+id);
  }

  public getCustomerByName(firstName:string){
    return this.http.get("http://localhost:8080/byCustomerName/"+firstName);
  }
}
