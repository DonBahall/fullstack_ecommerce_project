package com.project.ecommerce.repository;

import com.project.ecommerce.entity.cart.CartItem;
import com.project.ecommerce.entity.cart.CartItemUP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository <CartItem, CartItemUP> {
}
