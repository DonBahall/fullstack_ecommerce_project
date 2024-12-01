package com.project.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.ecommerce.entity.cart.CartItem;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 35)
    private String username;

    @Column(nullable = false, length = 128)
    private String password;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 128)
    private String address;

    @Column(nullable = false, length = 15)
    private String phone;

    @JsonManagedReference
    @OneToMany(mappedBy = "pk.user", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", cartItems=" + cartItems +
                '}';
    }

    public User(String username, String phone, String name, String password, String email, String address) {
        this.username = username;
        this.phone = phone;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
    }
}
