// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

public interface EventNetworkOrBuilder extends
    // @@protoc_insertion_point(interface_extends:proto.EventNetwork)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>.proto.Event event = 2;</code>
   * @return Whether the event field is set.
   */
  boolean hasEvent();
  /**
   * <code>.proto.Event event = 2;</code>
   * @return The event.
   */
  proto.Event getEvent();
  /**
   * <code>.proto.Event event = 2;</code>
   */
  proto.EventOrBuilder getEventOrBuilder();

  /**
   * <code>string url = 3;</code>
   * @return The url.
   */
  java.lang.String getUrl();
  /**
   * <code>string url = 3;</code>
   * @return The bytes for url.
   */
  com.google.protobuf.ByteString
      getUrlBytes();

  /**
   * <code>.proto.NetworkType network_type = 4;</code>
   * @return Whether the networkType field is set.
   */
  boolean hasNetworkType();
  /**
   * <code>.proto.NetworkType network_type = 4;</code>
   * @return The networkType.
   */
  proto.NetworkType getNetworkType();
  /**
   * <code>.proto.NetworkType network_type = 4;</code>
   */
  proto.NetworkTypeOrBuilder getNetworkTypeOrBuilder();

  /**
   * <code>.google.protobuf.Timestamp created_at = 5;</code>
   * @return Whether the createdAt field is set.
   */
  boolean hasCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp created_at = 5;</code>
   * @return The createdAt.
   */
  com.google.protobuf.Timestamp getCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp created_at = 5;</code>
   */
  com.google.protobuf.TimestampOrBuilder getCreatedAtOrBuilder();

  /**
   * <code>.google.protobuf.Timestamp updated_at = 6;</code>
   * @return Whether the updatedAt field is set.
   */
  boolean hasUpdatedAt();
  /**
   * <code>.google.protobuf.Timestamp updated_at = 6;</code>
   * @return The updatedAt.
   */
  com.google.protobuf.Timestamp getUpdatedAt();
  /**
   * <code>.google.protobuf.Timestamp updated_at = 6;</code>
   */
  com.google.protobuf.TimestampOrBuilder getUpdatedAtOrBuilder();

  /**
   * <code>string checksum = 7;</code>
   * @return The checksum.
   */
  java.lang.String getChecksum();
  /**
   * <code>string checksum = 7;</code>
   * @return The bytes for checksum.
   */
  com.google.protobuf.ByteString
      getChecksumBytes();
}