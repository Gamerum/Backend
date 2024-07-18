// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

public interface GameVersionFeatureOrBuilder extends
    // @@protoc_insertion_point(interface_extends:proto.GameVersionFeature)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>.proto.GameVersionFeatureCategoryEnum category = 2;</code>
   * @return The enum numeric value on the wire for category.
   */
  int getCategoryValue();
  /**
   * <code>.proto.GameVersionFeatureCategoryEnum category = 2;</code>
   * @return The category.
   */
  proto.GameVersionFeatureCategoryEnum getCategory();

  /**
   * <code>string description = 3;</code>
   * @return The description.
   */
  java.lang.String getDescription();
  /**
   * <code>string description = 3;</code>
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <code>int32 position = 4;</code>
   * @return The position.
   */
  int getPosition();

  /**
   * <code>string title = 5;</code>
   * @return The title.
   */
  java.lang.String getTitle();
  /**
   * <code>string title = 5;</code>
   * @return The bytes for title.
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <code>repeated .proto.GameVersionFeatureValue values = 6;</code>
   */
  java.util.List<proto.GameVersionFeatureValue> 
      getValuesList();
  /**
   * <code>repeated .proto.GameVersionFeatureValue values = 6;</code>
   */
  proto.GameVersionFeatureValue getValues(int index);
  /**
   * <code>repeated .proto.GameVersionFeatureValue values = 6;</code>
   */
  int getValuesCount();
  /**
   * <code>repeated .proto.GameVersionFeatureValue values = 6;</code>
   */
  java.util.List<? extends proto.GameVersionFeatureValueOrBuilder> 
      getValuesOrBuilderList();
  /**
   * <code>repeated .proto.GameVersionFeatureValue values = 6;</code>
   */
  proto.GameVersionFeatureValueOrBuilder getValuesOrBuilder(
      int index);

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
