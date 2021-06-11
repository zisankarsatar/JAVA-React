package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController{

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        super();
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @GetMapping("/getallDesc")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategory")
    public DataResult<Product> getByProductNameAndCategory(@RequestParam String productName, @RequestParam int categoryId){
        return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategory")
    public DataResult<List<Product>> getByProductNameOrCategory(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameOrCategory(productName, categoryId);
    }

    @GetMapping("/getByCategoryIn")
    public DataResult<List<Product>> getByCategoryIn(@RequestParam int categoryId){
        return this.productService.getByCategoryIn(Collections.singletonList(categoryId));
    }

    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName){
        return this.productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName, @RequestParam int categoryId){
        return this.productService.getByNameAndCategory(productName, categoryId);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAllByPage(@RequestParam int pageNo, @RequestParam int pageSize){
        return this.productService.getAllByPage(pageNo, pageSize);
    }

    @GetMapping("/getAllSortedPrice")
    public DataResult<List<Product>> getAllSortedPrice(){
        return this.productService.getAllSortedPrice();
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDto();
    }

}
