// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

public interface PlatformVersionReleaseDateOrBuilder extends
    // @@protoc_insertion_point(interface_extends:proto.PlatformVersionReleaseDate)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>.proto.DateFormatChangeDateCategoryEnum category = 2;</code>
   * @return The enum numeric value on the wire for category.
   */
  int getCategoryValue();
  /**
   * <code>.proto.DateFormatChangeDateCategoryEnum category = 2;</code>
   * @return The category.
   */
  proto.DateFormatChangeDateCategoryEnum getCategory();

  /**
   * <code>.google.protobuf.Timestamp created_at = 3;</code>
   * @return Whether the createdAt field is set.
   */
  boolean hasCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp created_at = 3;</code>
   * @return The createdAt.
   */
  com.google.protobuf.Timestamp getCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp created_at = 3;</code>
   */
  com.google.protobuf.TimestampOrBuilder getCreatedAtOrBuilder();

  /**
   * <code>.google.protobuf.Timestamp date = 4;</code>
   * @return Whether the date field is set.
   */
  boolean hasDate();
  /**
   * <code>.google.protobuf.Timestamp date = 4;</code>
   * @return The date.
   */
  com.google.protobuf.Timestamp getDate();
  /**
   * <code>.google.protobuf.Timestamp date = 4;</code>
   */
  com.google.protobuf.TimestampOrBuilder getDateOrBuilder();

  /**
   * <code>string human = 5;</code>
   * @return The human.
   */
  java.lang.String getHuman();
  /**
   * <code>string human = 5;</code>
   * @return The bytes for human.
   */
  com.google.protobuf.ByteString
      getHumanBytes();

  /**
   * <code>int32 m = 6;</code>
   * @return The m.
   */
  int getM();

  /**
   * <code>.proto.PlatformVersion platform_version = 7;</code>
   * @return Whether the platformVersion field is set.
   */
  boolean hasPlatformVersion();
  /**
   * <code>.proto.PlatformVersion platform_version = 7;</code>
   * @return The platformVersion.
   */
  proto.PlatformVersion getPlatformVersion();
  /**
   * <code>.proto.PlatformVersion platform_version = 7;</code>
   */
  proto.PlatformVersionOrBuilder getPlatformVersionOrBuilder();

  /**
   * <code>.proto.RegionRegionEnum region = 8;</code>
   * @return The enum numeric value on the wire for region.
   */
  int getRegionValue();
  /**
   * <code>.proto.RegionRegionEnum region = 8;</code>
   * @return The region.
   */
  proto.RegionRegionEnum getRegion();

  /**
   * <code>.google.protobuf.Timestamp updated_at = 9;</code>
   * @return Whether the updatedAt field is set.
   */
  boolean hasUpdatedAt();
  /**
   * <code>.google.protobuf.Timestamp updated_at = 9;</code>
   * @return The updatedAt.
   */
  com.google.protobuf.Timestamp getUpdatedAt();
  /**
   * <code>.google.protobuf.Timestamp updated_at = 9;</code>
   */
  com.google.protobuf.TimestampOrBuilder getUpdatedAtOrBuilder();

  /**
   * <code>int32 y = 10;</code>
   * @return The y.
   */
  int getY();

  /**
   * <code>string checksum = 11;</code>
   * @return The checksum.
   */
  java.lang.String getChecksum();
  /**
   * <code>string checksum = 11;</code>
   * @return The bytes for checksum.
   */
  com.google.protobuf.ByteString
      getChecksumBytes();
}
