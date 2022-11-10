import { Component, OnInit } from '@angular/core';
import { ProductCategory } from '../product-category';
import { ProductService } from '../product.service';


@Component({
  selector: 'app-product-category',
  templateUrl: './product-category.component.html',
  styleUrls: ['./product-category.component.css']
})
export class ProductCategoryComponent implements OnInit {

  productCategories: ProductCategory[] | undefined;
  
  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.listProductCategories();
  }

  listProductCategories() {

    this.productService.getProductCategories().subscribe(
      data => {
        console.log('Product Categories=' + JSON.stringify(data));
        this.productCategories = data;
      }
    );
  }

}
