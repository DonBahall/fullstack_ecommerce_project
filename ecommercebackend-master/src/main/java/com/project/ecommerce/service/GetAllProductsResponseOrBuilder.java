// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ProductServiceGRPC.proto

package com.project.ecommerce.service;

public interface GetAllProductsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:net.devh.boot.grpc.example.GetAllProductsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .net.devh.boot.grpc.example.Product products = 1;</code>
   */
  java.util.List<Product>
      getProductsList();
  /**
   * <code>repeated .net.devh.boot.grpc.example.Product products = 1;</code>
   */
  Product getProducts(int index);
  /**
   * <code>repeated .net.devh.boot.grpc.example.Product products = 1;</code>
   */
  int getProductsCount();
  /**
   * <code>repeated .net.devh.boot.grpc.example.Product products = 1;</code>
   */
  java.util.List<? extends ProductOrBuilder>
      getProductsOrBuilderList();
  /**
   * <code>repeated .net.devh.boot.grpc.example.Product products = 1;</code>
   */
  ProductOrBuilder getProductsOrBuilder(
      int index);
}
