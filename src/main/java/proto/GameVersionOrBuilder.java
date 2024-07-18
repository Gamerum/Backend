// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

public interface GameVersionOrBuilder extends
    // @@protoc_insertion_point(interface_extends:proto.GameVersion)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>.google.protobuf.Timestamp created_at = 2;</code>
   * @return Whether the createdAt field is set.
   */
  boolean hasCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp created_at = 2;</code>
   * @return The createdAt.
   */
  com.google.protobuf.Timestamp getCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp created_at = 2;</code>
   */
  com.google.protobuf.TimestampOrBuilder getCreatedAtOrBuilder();

  /**
   * <code>repeated .proto.GameVersionFeature features = 3;</code>
   */
  java.util.List<proto.GameVersionFeature> 
      getFeaturesList();
  /**
   * <code>repeated .proto.GameVersionFeature features = 3;</code>
   */
  proto.GameVersionFeature getFeatures(int index);
  /**
   * <code>repeated .proto.GameVersionFeature features = 3;</code>
   */
  int getFeaturesCount();
  /**
   * <code>repeated .proto.GameVersionFeature features = 3;</code>
   */
  java.util.List<? extends proto.GameVersionFeatureOrBuilder> 
      getFeaturesOrBuilderList();
  /**
   * <code>repeated .proto.GameVersionFeature features = 3;</code>
   */
  proto.GameVersionFeatureOrBuilder getFeaturesOrBuilder(
      int index);

  /**
   * <code>.proto.Game game = 4;</code>
   * @return Whether the game field is set.
   */
  boolean hasGame();
  /**
   * <code>.proto.Game game = 4;</code>
   * @return The game.
   */
  proto.Game getGame();
  /**
   * <code>.proto.Game game = 4;</code>
   */
  proto.GameOrBuilder getGameOrBuilder();

  /**
   * <code>repeated .proto.Game games = 5;</code>
   */
  java.util.List<proto.Game> 
      getGamesList();
  /**
   * <code>repeated .proto.Game games = 5;</code>
   */
  proto.Game getGames(int index);
  /**
   * <code>repeated .proto.Game games = 5;</code>
   */
  int getGamesCount();
  /**
   * <code>repeated .proto.Game games = 5;</code>
   */
  java.util.List<? extends proto.GameOrBuilder> 
      getGamesOrBuilderList();
  /**
   * <code>repeated .proto.Game games = 5;</code>
   */
  proto.GameOrBuilder getGamesOrBuilder(
      int index);

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
   * <code>string url = 7;</code>
   * @return The url.
   */
  java.lang.String getUrl();
  /**
   * <code>string url = 7;</code>
   * @return The bytes for url.
   */
  com.google.protobuf.ByteString
      getUrlBytes();

  /**
   * <code>string checksum = 8;</code>
   * @return The checksum.
   */
  java.lang.String getChecksum();
  /**
   * <code>string checksum = 8;</code>
   * @return The bytes for checksum.
   */
  com.google.protobuf.ByteString
      getChecksumBytes();
}
