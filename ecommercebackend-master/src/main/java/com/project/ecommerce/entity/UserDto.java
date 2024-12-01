package com.project.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.ecommerce.entity.cart.CartItem;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String address;
    private String phone;

    @JsonManagedReference
    @OneToMany(mappedBy = "pk.user")
    private List<CartItem> cartItems = new ArrayList<>();
}
