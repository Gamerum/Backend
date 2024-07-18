// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

public interface TestDummyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:proto.TestDummy)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>bool bool_value = 2;</code>
   * @return The boolValue.
   */
  boolean getBoolValue();

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
   * <code>.proto.TestDummyEnumTestEnum enum_test = 4;</code>
   * @return The enum numeric value on the wire for enumTest.
   */
  int getEnumTestValue();
  /**
   * <code>.proto.TestDummyEnumTestEnum enum_test = 4;</code>
   * @return The enumTest.
   */
  proto.TestDummyEnumTestEnum getEnumTest();

  /**
   * <code>double float_value = 5;</code>
   * @return The floatValue.
   */
  double getFloatValue();

  /**
   * <code>.proto.Game game = 6;</code>
   * @return Whether the game field is set.
   */
  boolean hasGame();
  /**
   * <code>.proto.Game game = 6;</code>
   * @return The game.
   */
  proto.Game getGame();
  /**
   * <code>.proto.Game game = 6;</code>
   */
  proto.GameOrBuilder getGameOrBuilder();

  /**
   * <code>repeated int32 integer_array = 7;</code>
   * @return A list containing the integerArray.
   */
  java.util.List<java.lang.Integer> getIntegerArrayList();
  /**
   * <code>repeated int32 integer_array = 7;</code>
   * @return The count of integerArray.
   */
  int getIntegerArrayCount();
  /**
   * <code>repeated int32 integer_array = 7;</code>
   * @param index The index of the element to return.
   * @return The integerArray at the given index.
   */
  int getIntegerArray(int index);

  /**
   * <code>int32 integer_value = 8;</code>
   * @return The integerValue.
   */
  int getIntegerValue();

  /**
   * <code>string name = 9;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 9;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>int32 new_integer_value = 10;</code>
   * @return The newIntegerValue.
   */
  int getNewIntegerValue();

  /**
   * <code>bool private = 11;</code>
   * @return The private.
   */
  boolean getPrivate();

  /**
   * <code>string slug = 12;</code>
   * @return The slug.
   */
  java.lang.String getSlug();
  /**
   * <code>string slug = 12;</code>
   * @return The bytes for slug.
   */
  com.google.protobuf.ByteString
      getSlugBytes();

  /**
   * <code>repeated string string_array = 13;</code>
   * @return A list containing the stringArray.
   */
  java.util.List<java.lang.String>
      getStringArrayList();
  /**
   * <code>repeated string string_array = 13;</code>
   * @return The count of stringArray.
   */
  int getStringArrayCount();
  /**
   * <code>repeated string string_array = 13;</code>
   * @param index The index of the element to return.
   * @return The stringArray at the given index.
   */
  java.lang.String getStringArray(int index);
  /**
   * <code>repeated string string_array = 13;</code>
   * @param index The index of the value to return.
   * @return The bytes of the stringArray at the given index.
   */
  com.google.protobuf.ByteString
      getStringArrayBytes(int index);

  /**
   * <code>repeated .proto.TestDummy test_dummies = 14;</code>
   */
  java.util.List<proto.TestDummy> 
      getTestDummiesList();
  /**
   * <code>repeated .proto.TestDummy test_dummies = 14;</code>
   */
  proto.TestDummy getTestDummies(int index);
  /**
   * <code>repeated .proto.TestDummy test_dummies = 14;</code>
   */
  int getTestDummiesCount();
  /**
   * <code>repeated .proto.TestDummy test_dummies = 14;</code>
   */
  java.util.List<? extends proto.TestDummyOrBuilder> 
      getTestDummiesOrBuilderList();
  /**
   * <code>repeated .proto.TestDummy test_dummies = 14;</code>
   */
  proto.TestDummyOrBuilder getTestDummiesOrBuilder(
      int index);

  /**
   * <code>.proto.TestDummy test_dummy = 15;</code>
   * @return Whether the testDummy field is set.
   */
  boolean hasTestDummy();
  /**
   * <code>.proto.TestDummy test_dummy = 15;</code>
   * @return The testDummy.
   */
  proto.TestDummy getTestDummy();
  /**
   * <code>.proto.TestDummy test_dummy = 15;</code>
   */
  proto.TestDummyOrBuilder getTestDummyOrBuilder();

  /**
   * <code>.google.protobuf.Timestamp updated_at = 16;</code>
   * @return Whether the updatedAt field is set.
   */
  boolean hasUpdatedAt();
  /**
   * <code>.google.protobuf.Timestamp updated_at = 16;</code>
   * @return The updatedAt.
   */
  com.google.protobuf.Timestamp getUpdatedAt();
  /**
   * <code>.google.protobuf.Timestamp updated_at = 16;</code>
   */
  com.google.protobuf.TimestampOrBuilder getUpdatedAtOrBuilder();

  /**
   * <code>string url = 17;</code>
   * @return The url.
   */
  java.lang.String getUrl();
  /**
   * <code>string url = 17;</code>
   * @return The bytes for url.
   */
  com.google.protobuf.ByteString
      getUrlBytes();

  /**
   * <code>string checksum = 18;</code>
   * @return The checksum.
   */
  java.lang.String getChecksum();
  /**
   * <code>string checksum = 18;</code>
   * @return The bytes for checksum.
   */
  com.google.protobuf.ByteString
      getChecksumBytes();
}