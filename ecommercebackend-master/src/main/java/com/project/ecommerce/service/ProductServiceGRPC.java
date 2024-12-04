package com.project.ecommerce.service;

import com.project.ecommerce.exceptions.ProductNotFoundException;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@GrpcService
public class ProductServiceGRPC extends ProductServiceGRPCGrpc.ProductServiceGRPCImplBase{
    List<com.project.ecommerce.entity.Product> products = new ArrayList<>() {{
        add(new com.project.ecommerce.entity.Product(1L, "Laptop", "Gaming laptop", 1200, "Electronics", new Date()));
        add(new com.project.ecommerce.entity.Product(2L, "Headphones", "Noise-cancelling headphones", 200, "Accessories", new Date()));
    }};

    @Override
    public void getProduct(GetProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        com.project.ecommerce.entity.Product responseProduct = products.stream()
                .filter(product -> product.getId().equals(request.getId()))
                .findFirst()
                .orElseThrow(() ->
                        new ProductNotFoundException("Product by id " + request.getId() + " was not found."));

        Product grpcProduct = Product.newBuilder()
                .setId(responseProduct.getId())
                .setTitle(responseProduct.getTitle())
                .setDescription(responseProduct.getDescription())
                .setPrice(responseProduct.getPrice())
                .setCategory(responseProduct.getCategory())
                .setAddedOn(responseProduct.getAddedOn().toString())
                .build();

        ProductResponse response = ProductResponse.newBuilder()
                .setProduct(grpcProduct)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
