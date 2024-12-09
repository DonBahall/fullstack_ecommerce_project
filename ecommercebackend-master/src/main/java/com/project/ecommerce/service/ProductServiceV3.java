// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ProductServiceGRPC.proto

package com.project.ecommerce.service;

public final class ProductServiceV3 {
  private ProductServiceV3() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_net_devh_boot_grpc_example_Product_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_net_devh_boot_grpc_example_Product_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_net_devh_boot_grpc_example_GetProductRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_net_devh_boot_grpc_example_GetProductRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_net_devh_boot_grpc_example_ProductResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_net_devh_boot_grpc_example_ProductResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_net_devh_boot_grpc_example_AddProductRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_net_devh_boot_grpc_example_AddProductRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_net_devh_boot_grpc_example_UpdateProductRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_net_devh_boot_grpc_example_UpdateProductRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_net_devh_boot_grpc_example_GetAllProductsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_net_devh_boot_grpc_example_GetAllProductsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_net_devh_boot_grpc_example_GetAllProductsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_net_devh_boot_grpc_example_GetAllProductsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_net_devh_boot_grpc_example_DeleteProductRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_net_devh_boot_grpc_example_DeleteProductRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_net_devh_boot_grpc_example_BooleanResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_net_devh_boot_grpc_example_BooleanResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\030ProductServiceGRPC.proto\022\032net.devh.boo" +
      "t.grpc.example\"k\n\007Product\022\n\n\002id\030\001 \001(\003\022\r\n" +
      "\005title\030\002 \001(\t\022\023\n\013description\030\003 \001(\t\022\r\n\005pri" +
      "ce\030\004 \001(\001\022\020\n\010category\030\005 \001(\t\022\017\n\007addedOn\030\006 " +
      "\001(\t\"\037\n\021GetProductRequest\022\n\n\002id\030\001 \001(\003\"G\n\017" +
      "ProductResponse\0224\n\007product\030\001 \001(\0132#.net.d" +
      "evh.boot.grpc.example.Product\"I\n\021AddProd" +
      "uctRequest\0224\n\007product\030\001 \001(\0132#.net.devh.b" +
      "oot.grpc.example.Product\"X\n\024UpdateProduc" +
      "tRequest\022\n\n\002id\030\001 \001(\003\0224\n\007product\030\002 \001(\0132#." +
      "net.devh.boot.grpc.example.Product\"\027\n\025Ge" +
      "tAllProductsRequest\"O\n\026GetAllProductsRes" +
      "ponse\0225\n\010products\030\001 \003(\0132#.net.devh.boot." +
      "grpc.example.Product\"\"\n\024DeleteProductReq" +
      "uest\022\n\n\002id\030\001 \001(\003\"\037\n\017BooleanResponse\022\014\n\004r" +
      "esp\030\001 \001(\0102\275\004\n\016ProductService\022h\n\nGetProdu" +
      "ct\022-.net.devh.boot.grpc.example.GetProdu" +
      "ctRequest\032+.net.devh.boot.grpc.example.P" +
      "roductResponse\022h\n\nAddProduct\022-.net.devh." +
      "boot.grpc.example.AddProductRequest\032+.ne" +
      "t.devh.boot.grpc.example.ProductResponse" +
      "\022n\n\rUpdateProduct\0220.net.devh.boot.grpc.e" +
      "xample.UpdateProductRequest\032+.net.devh.b" +
      "oot.grpc.example.ProductResponse\022n\n\rDele" +
      "teProduct\0220.net.devh.boot.grpc.example.D" +
      "eleteProductRequest\032+.net.devh.boot.grpc" +
      ".example.BooleanResponse\022w\n\016GetAllProduc" +
      "ts\0221.net.devh.boot.grpc.example.GetAllPr" +
      "oductsRequest\0322.net.devh.boot.grpc.examp" +
      "le.GetAllProductsResponseB3\n\035com.project" +
      ".ecommerce.serviceB\020ProductServiceV3P\001b\006" +
      "proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_net_devh_boot_grpc_example_Product_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_net_devh_boot_grpc_example_Product_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_net_devh_boot_grpc_example_Product_descriptor,
        new String[] { "Id", "Title", "Description", "Price", "Category", "AddedOn", });
    internal_static_net_devh_boot_grpc_example_GetProductRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_net_devh_boot_grpc_example_GetProductRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_net_devh_boot_grpc_example_GetProductRequest_descriptor,
        new String[] { "Id", });
    internal_static_net_devh_boot_grpc_example_ProductResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_net_devh_boot_grpc_example_ProductResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_net_devh_boot_grpc_example_ProductResponse_descriptor,
        new String[] { "Product", });
    internal_static_net_devh_boot_grpc_example_AddProductRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_net_devh_boot_grpc_example_AddProductRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_net_devh_boot_grpc_example_AddProductRequest_descriptor,
        new String[] { "Product", });
    internal_static_net_devh_boot_grpc_example_UpdateProductRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_net_devh_boot_grpc_example_UpdateProductRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_net_devh_boot_grpc_example_UpdateProductRequest_descriptor,
        new String[] { "Id", "Product", });
    internal_static_net_devh_boot_grpc_example_GetAllProductsRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_net_devh_boot_grpc_example_GetAllProductsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_net_devh_boot_grpc_example_GetAllProductsRequest_descriptor,
        new String[] { });
    internal_static_net_devh_boot_grpc_example_GetAllProductsResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_net_devh_boot_grpc_example_GetAllProductsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_net_devh_boot_grpc_example_GetAllProductsResponse_descriptor,
        new String[] { "Products", });
    internal_static_net_devh_boot_grpc_example_DeleteProductRequest_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_net_devh_boot_grpc_example_DeleteProductRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_net_devh_boot_grpc_example_DeleteProductRequest_descriptor,
        new String[] { "Id", });
    internal_static_net_devh_boot_grpc_example_BooleanResponse_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_net_devh_boot_grpc_example_BooleanResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_net_devh_boot_grpc_example_BooleanResponse_descriptor,
        new String[] { "Resp", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
