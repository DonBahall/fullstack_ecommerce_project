package com.project.ecommerce;

import com.project.ecommerce.service.GetProductRequest;
import com.project.ecommerce.service.ProductResponse;
import com.project.ecommerce.service.ProductServiceGRPC;
import com.project.ecommerce.service.ProductServiceGRPCGrpc;
import org.springframework.boot.test.context.SpringBootTest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class IntegrationTests {
    private Server server;
    private ManagedChannel channel;

    @BeforeEach
    public void setup() throws IOException {
        List<com.project.ecommerce.entity.Product> products = new ArrayList<>();
        products.add(new com.project.ecommerce.entity.Product(1L, "Laptop", "Gaming laptop", 1200, "Electronics", new Date()));
        products.add(new com.project.ecommerce.entity.Product(2L, "Headphones", "Noise-cancelling headphones", 200, "Accessories", new Date()));

        server = ServerBuilder.forPort(8080)
                .addService(new ProductServiceGRPC())
                .build()
                .start();

        channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
    }

    @AfterEach
    public void teardown() {
        channel.shutdown();
        server.shutdown();
    }

    @Test
    public void testGetProduct_Success() {
        ProductServiceGRPCGrpc.ProductServiceGRPCBlockingStub client = ProductServiceGRPCGrpc.newBlockingStub(channel);

        GetProductRequest request = GetProductRequest.newBuilder().setId(1L).build();
        ProductResponse response = client.getProduct(request);

        assertEquals(1L, response.getProduct().getId());
        assertEquals("Laptop", response.getProduct().getTitle());
    }
}


