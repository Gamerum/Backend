// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

public interface InvolvedCompanyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:proto.InvolvedCompany)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>.proto.Company company = 2;</code>
   * @return Whether the company field is set.
   */
  boolean hasCompany();
  /**
   * <code>.proto.Company company = 2;</code>
   * @return The company.
   */
  proto.Company getCompany();
  /**
   * <code>.proto.Company company = 2;</code>
   */
  proto.CompanyOrBuilder getCompanyOrBuilder();

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
   * <code>bool developer = 4;</code>
   * @return The developer.
   */
  boolean getDeveloper();

  /**
   * <code>.proto.Game game = 5;</code>
   * @return Whether the game field is set.
   */
  boolean hasGame();
  /**
   * <code>.proto.Game game = 5;</code>
   * @return The game.
   */
  proto.Game getGame();
  /**
   * <code>.proto.Game game = 5;</code>
   */
  proto.GameOrBuilder getGameOrBuilder();

  /**
   * <code>bool porting = 6;</code>
   * @return The porting.
   */
  boolean getPorting();

  /**
   * <code>bool publisher = 7;</code>
   * @return The publisher.
   */
  boolean getPublisher();

  /**
   * <code>bool supporting = 8;</code>
   * @return The supporting.
   */
  boolean getSupporting();

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
   * <code>string checksum = 10;</code>
   * @return The checksum.
   */
  java.lang.String getChecksum();
  /**
   * <code>string checksum = 10;</code>
   * @return The bytes for checksum.
   */
  com.google.protobuf.ByteString
      getChecksumBytes();
}
