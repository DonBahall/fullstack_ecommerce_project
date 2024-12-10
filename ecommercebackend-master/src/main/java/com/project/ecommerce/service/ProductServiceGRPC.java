package com.project.ecommerce.service;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.Date;

@GrpcService
@Slf4j
public class ProductServiceGRPC extends ProductServiceGrpc.ProductServiceImplBase{
    @Autowired
    private ProductService productService;

    @Override
    public void getProduct(GetProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        log.info("Get Product GRPC method called" );
        com.project.ecommerce.entity.Product responseProduct = productService.getProduct(request.getId());

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
        productService.addProduct(productToEntity(request.getProduct()));

        ProductResponse response = ProductResponse.newBuilder()
                .setProduct(request.getProduct())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void updateProduct(UpdateProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        log.info("Update Product GRPC method called ");
        productService.updateProduct(request.getId(), productToEntity(request.getProduct()));

       ProductResponse response = ProductResponse.newBuilder()
                .setProduct(request.getProduct())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteProduct(DeleteProductRequest request, StreamObserver<BooleanResponse> responseObserver) {
        log.info("Delete Product GRPC method called ");
        productService.deleteProduct(request.getId());

        responseObserver.onNext(BooleanResponse.newBuilder().build());
        responseObserver.onCompleted();
    }
}
