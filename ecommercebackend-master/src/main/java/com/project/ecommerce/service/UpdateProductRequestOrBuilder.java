// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ProductServiceGRPC.proto

package com.project.ecommerce.service;

public interface UpdateProductRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:net.devh.boot.grpc.example.UpdateProductRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 id = 1;</code>
   */
  long getId();

  /**
   * <code>.net.devh.boot.grpc.example.Product product = 2;</code>
   */
  boolean hasProduct();
  /**
   * <code>.net.devh.boot.grpc.example.Product product = 2;</code>
   */
  Product getProduct();
  /**
   * <code>.net.devh.boot.grpc.example.Product product = 2;</code>
   */
  ProductOrBuilder getProductOrBuilder();
}
