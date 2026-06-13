package com.example.personalize.shopping.cart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		return productService.updateProductPrice(id, product);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
