// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

public interface PlatformFamilyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:proto.PlatformFamily)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string slug = 3;</code>
   * @return The slug.
   */
  java.lang.String getSlug();
  /**
   * <code>string slug = 3;</code>
   * @return The bytes for slug.
   */
  com.google.protobuf.ByteString
      getSlugBytes();

  /**
   * <code>string checksum = 4;</code>
   * @return The checksum.
   */
  java.lang.String getChecksum();
  /**
   * <code>string checksum = 4;</code>
   * @return The bytes for checksum.
   */
  com.google.protobuf.ByteString
      getChecksumBytes();
}