// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

public interface EventOrBuilder extends
    // @@protoc_insertion_point(interface_extends:proto.Event)
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
   * <code>string slug = 4;</code>
   * @return The slug.
   */
  java.lang.String getSlug();
  /**
   * <code>string slug = 4;</code>
   * @return The bytes for slug.
   */
  com.google.protobuf.ByteString
      getSlugBytes();

  /**
   * <code>.proto.EventLogo event_logo = 5;</code>
   * @return Whether the eventLogo field is set.
   */
  boolean hasEventLogo();
  /**
   * <code>.proto.EventLogo event_logo = 5;</code>
   * @return The eventLogo.
   */
  proto.EventLogo getEventLogo();
  /**
   * <code>.proto.EventLogo event_logo = 5;</code>
   */
  proto.EventLogoOrBuilder getEventLogoOrBuilder();

  /**
   * <code>.google.protobuf.Timestamp start_time = 6;</code>
   * @return Whether the startTime field is set.
   */
  boolean hasStartTime();
  /**
   * <code>.google.protobuf.Timestamp start_time = 6;</code>
   * @return The startTime.
   */
  com.google.protobuf.Timestamp getStartTime();
  /**
   * <code>.google.protobuf.Timestamp start_time = 6;</code>
   */
  com.google.protobuf.TimestampOrBuilder getStartTimeOrBuilder();

  /**
   * <code>string time_zone = 7;</code>
   * @return The timeZone.
   */
  java.lang.String getTimeZone();
  /**
   * <code>string time_zone = 7;</code>
   * @return The bytes for timeZone.
   */
  com.google.protobuf.ByteString
      getTimeZoneBytes();

  /**
   * <code>.google.protobuf.Timestamp end_time = 8;</code>
   * @return Whether the endTime field is set.
   */
  boolean hasEndTime();
  /**
   * <code>.google.protobuf.Timestamp end_time = 8;</code>
   * @return The endTime.
   */
  com.google.protobuf.Timestamp getEndTime();
  /**
   * <code>.google.protobuf.Timestamp end_time = 8;</code>
   */
  com.google.protobuf.TimestampOrBuilder getEndTimeOrBuilder();

  /**
   * <code>string live_stream_url = 9;</code>
   * @return The liveStreamUrl.
   */
  java.lang.String getLiveStreamUrl();
  /**
   * <code>string live_stream_url = 9;</code>
   * @return The bytes for liveStreamUrl.
   */
  com.google.protobuf.ByteString
      getLiveStreamUrlBytes();

  /**
   * <code>repeated .proto.Game games = 10;</code>
   */
  java.util.List<proto.Game> 
      getGamesList();
  /**
   * <code>repeated .proto.Game games = 10;</code>
   */
  proto.Game getGames(int index);
  /**
   * <code>repeated .proto.Game games = 10;</code>
   */
  int getGamesCount();
  /**
   * <code>repeated .proto.Game games = 10;</code>
   */
  java.util.List<? extends proto.GameOrBuilder> 
      getGamesOrBuilderList();
  /**
   * <code>repeated .proto.Game games = 10;</code>
   */
  proto.GameOrBuilder getGamesOrBuilder(
      int index);

  /**
   * <code>repeated .proto.GameVideo videos = 11;</code>
   */
  java.util.List<proto.GameVideo> 
      getVideosList();
  /**
   * <code>repeated .proto.GameVideo videos = 11;</code>
   */
  proto.GameVideo getVideos(int index);
  /**
   * <code>repeated .proto.GameVideo videos = 11;</code>
   */
  int getVideosCount();
  /**
   * <code>repeated .proto.GameVideo videos = 11;</code>
   */
  java.util.List<? extends proto.GameVideoOrBuilder> 
      getVideosOrBuilderList();
  /**
   * <code>repeated .proto.GameVideo videos = 11;</code>
   */
  proto.GameVideoOrBuilder getVideosOrBuilder(
      int index);

  /**
   * <code>repeated .proto.EventNetwork event_networks = 12;</code>
   */
  java.util.List<proto.EventNetwork> 
      getEventNetworksList();
  /**
   * <code>repeated .proto.EventNetwork event_networks = 12;</code>
   */
  proto.EventNetwork getEventNetworks(int index);
  /**
   * <code>repeated .proto.EventNetwork event_networks = 12;</code>
   */
  int getEventNetworksCount();
  /**
   * <code>repeated .proto.EventNetwork event_networks = 12;</code>
   */
  java.util.List<? extends proto.EventNetworkOrBuilder> 
      getEventNetworksOrBuilderList();
  /**
   * <code>repeated .proto.EventNetwork event_networks = 12;</code>
   */
  proto.EventNetworkOrBuilder getEventNetworksOrBuilder(
      int index);

  /**
   * <code>.google.protobuf.Timestamp created_at = 13;</code>
   * @return Whether the createdAt field is set.
   */
  boolean hasCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp created_at = 13;</code>
   * @return The createdAt.
   */
  com.google.protobuf.Timestamp getCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp created_at = 13;</code>
   */
  com.google.protobuf.TimestampOrBuilder getCreatedAtOrBuilder();

  /**
   * <code>.google.protobuf.Timestamp updated_at = 14;</code>
   * @return Whether the updatedAt field is set.
   */
  boolean hasUpdatedAt();
  /**
   * <code>.google.protobuf.Timestamp updated_at = 14;</code>
   * @return The updatedAt.
   */
  com.google.protobuf.Timestamp getUpdatedAt();
  /**
   * <code>.google.protobuf.Timestamp updated_at = 14;</code>
   */
  com.google.protobuf.TimestampOrBuilder getUpdatedAtOrBuilder();

  /**
   * <code>string checksum = 15;</code>
   * @return The checksum.
   */
  java.lang.String getChecksum();
  /**
   * <code>string checksum = 15;</code>
   * @return The bytes for checksum.
   */
  com.google.protobuf.ByteString
      getChecksumBytes();
}