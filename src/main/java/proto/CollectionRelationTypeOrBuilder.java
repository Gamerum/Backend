// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

public interface CollectionRelationTypeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:proto.CollectionRelationType)
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
   * <code>.proto.CollectionType allowed_child_type = 4;</code>
   * @return Whether the allowedChildType field is set.
   */
  boolean hasAllowedChildType();
  /**
   * <code>.proto.CollectionType allowed_child_type = 4;</code>
   * @return The allowedChildType.
   */
  proto.CollectionType getAllowedChildType();
  /**
   * <code>.proto.CollectionType allowed_child_type = 4;</code>
   */
  proto.CollectionTypeOrBuilder getAllowedChildTypeOrBuilder();

  /**
   * <code>.proto.CollectionType allowed_parent_type = 5;</code>
   * @return Whether the allowedParentType field is set.
   */
  boolean hasAllowedParentType();
  /**
   * <code>.proto.CollectionType allowed_parent_type = 5;</code>
   * @return The allowedParentType.
   */
  proto.CollectionType getAllowedParentType();
  /**
   * <code>.proto.CollectionType allowed_parent_type = 5;</code>
   */
  proto.CollectionTypeOrBuilder getAllowedParentTypeOrBuilder();

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
   * <code>.google.protobuf.Timestamp created_at = 7;</code>
   * @return Whether the createdAt field is set.
   */
  boolean hasCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp created_at = 7;</code>
   * @return The createdAt.
   */
  com.google.protobuf.Timestamp getCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp created_at = 7;</code>
   */
  com.google.protobuf.TimestampOrBuilder getCreatedAtOrBuilder();

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
