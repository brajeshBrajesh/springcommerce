package com.springcommerce.cart_service.service;

import com.springcommerce.cart_service.dto.AddToCartRequest;
import com.springcommerce.cart_service.entity.Cart;
import com.springcommerce.cart_service.entity.CartItem;
import com.springcommerce.cart_service.repository.CartItemRepository;
import com.springcommerce.cart_service.repository.CartRepository;
import com.springcommerce.cart_service.secutity.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
//@NoArgsConstructor(force = true)
public class CartServiceImpl implements CartService{


    private final CartRepository cartRepository;
    private  final CartItemRepository cartItemRepository;
    @Override
    public void addToCart(Long userId,AddToCartRequest request){

        Cart cart= cartRepository.findByUserId(userId).orElseGet(()->{
            Cart newCart=new Cart();
            newCart.setUserId(userId);
            return cartRepository.save(newCart);
        });
        CartItem item = new CartItem();
        item.setProductId(request.getProductId());
        item.setQuantity(request.getQuantity());
        item.setPrice(request.getPrice());
        item.setCart(cart);

        cart.getItems().add(item);

        cartRepository.save(cart);

    }
}
