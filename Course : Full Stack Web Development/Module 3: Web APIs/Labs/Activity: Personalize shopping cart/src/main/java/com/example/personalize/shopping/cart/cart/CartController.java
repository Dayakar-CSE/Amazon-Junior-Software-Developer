package com.example.personalize.shopping.cart.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

	private final CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping("/user/{userId}")
	public List<Cart> getCartByUserId(@PathVariable Long userId) {
		return cartService.getCartByUserId(userId);
	}

	@PostMapping
	public ResponseEntity<String> addProductToCart(@RequestBody Cart cart) {
		cartService.addProductToCart(cart);
		return ResponseEntity.ok().body("Product added to cart successfully");
	}

	@DeleteMapping("/user/{userId}/product/{productId}")
	public void removeProductFromCart(@PathVariable Long userId, @PathVariable Long productId) {
		cartService.removeProductFromCart(userId, productId);
	}
}
