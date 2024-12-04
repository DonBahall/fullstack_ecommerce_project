package com.project.ecommerce;

import com.project.ecommerce.entity.Product;
import com.project.ecommerce.exceptions.ProductNotFoundException;
import com.project.ecommerce.service.GetProductRequest;
import com.project.ecommerce.service.ProductResponse;
import com.project.ecommerce.service.ProductServiceGRPC;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class EcommercebackendApplicationTests {

	private ProductServiceGRPC service;
	private List<Product> products;

	@BeforeEach
	public void setup() {
		products = new ArrayList<>();
		products.add(new com.project.ecommerce.entity.Product(1L, "Laptop", "Gaming laptop", 1200, "Electronics", new Date()));
		products.add(new com.project.ecommerce.entity.Product(2L, "Headphones", "Noise-cancelling headphones", 200, "Accessories", new Date()));
		service = new ProductServiceGRPC();
	}

	@Test
	public void testGetProduct_Success() {

		GetProductRequest request = GetProductRequest.newBuilder().setId(1L).build();


		StreamObserver<ProductResponse> responseObserver = mock(StreamObserver.class);


		service.getProduct(request, responseObserver);


		verify(responseObserver, times(1)).onNext(argThat(response -> {
			assertEquals(1L, response.getProduct().getId());
			assertEquals("Laptop", response.getProduct().getTitle());
			return true;
		}));

		verify(responseObserver, times(1)).onCompleted();
	}
	@Test
	public void testGetProduct_NotFound() {
		GetProductRequest request = GetProductRequest.newBuilder().setId(999L).build();


		StreamObserver<ProductResponse> responseObserver = mock(StreamObserver.class);


		assertThrows(ProductNotFoundException.class, () -> {
			service.getProduct(request, responseObserver);
		});


		verify(responseObserver, never()).onNext(any());
		verify(responseObserver, never()).onCompleted();
	}
}
