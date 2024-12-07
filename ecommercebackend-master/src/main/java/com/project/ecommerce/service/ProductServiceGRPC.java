package com.project.ecommerce.service;

import com.project.ecommerce.exceptions.ProductNotFoundException;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@GrpcService
@Slf4j
public class ProductServiceGRPC extends ProductServiceGrpc.ProductServiceImplBase{
    List<com.project.ecommerce.entity.Product> products = new ArrayList<>() {{
        add(new com.project.ecommerce.entity.Product(1L, "Laptop", "Gaming laptop", 1200, "Electronics", new Date()));
        add(new com.project.ecommerce.entity.Product(2L, "Headphones", "Noise-cancelling headphones", 200, "Accessories", new Date()));
    }};

    @Override
    public void getProduct(GetProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        log.info("Get Product GRPC method called" );
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
    private com.project.ecommerce.entity.Product productToEntity(Product product){
        return new com.project.ecommerce.entity.Product(product.getId(), product.getTitle(), product.getDescription(),
                (int) product.getPrice(), product.getCategory(),  Date.from(Instant.now()));
    }

    @Override
    public void addProduct(AddProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        log.info("Add Product GRPC method called ");
        products.add(productToEntity(request.getProduct()));

        ProductResponse response = ProductResponse.newBuilder()
                .setProduct(request.getProduct())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void updateProduct(UpdateProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        log.info("Update Product GRPC method called ");
        com.project.ecommerce.entity.Product responseProduct = products.stream()
                .filter(product -> product.getId().equals(request.getId()))
                .findFirst()
                .orElseThrow(() ->
                        new ProductNotFoundException("Product by id " + request.getId() + " was not found."));

       responseProduct.setTitle(request.getProduct().getTitle());
       responseProduct.setDescription(request.getProduct().getDescription());
       responseProduct.setPrice((int)request.getProduct().getPrice());
       responseProduct.setCategory(request.getProduct().getCategory());

       ProductResponse response = ProductResponse.newBuilder()
                .setProduct(request.getProduct())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteProduct(DeleteProductRequest request, StreamObserver<BooleanResponse> responseObserver) {
        log.info("Delete Product GRPC method called ");
        products.removeIf(product -> product.getId().equals(request.getId()));

        responseObserver.onNext(BooleanResponse.newBuilder().build());
        responseObserver.onCompleted();
    }
}
