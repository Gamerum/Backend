// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

/**
 * Protobuf type {@code proto.CollectionMembershipResult}
 */
public final class CollectionMembershipResult extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:proto.CollectionMembershipResult)
    CollectionMembershipResultOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      CollectionMembershipResult.class.getName());
  }
  // Use CollectionMembershipResult.newBuilder() to construct.
  private CollectionMembershipResult(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private CollectionMembershipResult() {
    collectionmemberships_ = java.util.Collections.emptyList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return proto.Igdbapi.internal_static_proto_CollectionMembershipResult_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return proto.Igdbapi.internal_static_proto_CollectionMembershipResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            proto.CollectionMembershipResult.class, proto.CollectionMembershipResult.Builder.class);
  }

  public static final int COLLECTIONMEMBERSHIPS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<proto.CollectionMembership> collectionmemberships_;
  /**
   * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
   */
  @java.lang.Override
  public java.util.List<proto.CollectionMembership> getCollectionmembershipsList() {
    return collectionmemberships_;
  }
  /**
   * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends proto.CollectionMembershipOrBuilder> 
      getCollectionmembershipsOrBuilderList() {
    return collectionmemberships_;
  }
  /**
   * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
   */
  @java.lang.Override
  public int getCollectionmembershipsCount() {
    return collectionmemberships_.size();
  }
  /**
   * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
   */
  @java.lang.Override
  public proto.CollectionMembership getCollectionmemberships(int index) {
    return collectionmemberships_.get(index);
  }
  /**
   * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
   */
  @java.lang.Override
  public proto.CollectionMembershipOrBuilder getCollectionmembershipsOrBuilder(
      int index) {
    return collectionmemberships_.get(index);
  }

  public static proto.CollectionMembershipResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.CollectionMembershipResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.CollectionMembershipResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.CollectionMembershipResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.CollectionMembershipResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.CollectionMembershipResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.CollectionMembershipResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.CollectionMembershipResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static proto.CollectionMembershipResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static proto.CollectionMembershipResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static proto.CollectionMembershipResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.CollectionMembershipResult parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(proto.CollectionMembershipResult prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code proto.CollectionMembershipResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.CollectionMembershipResult)
      proto.CollectionMembershipResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proto.Igdbapi.internal_static_proto_CollectionMembershipResult_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proto.Igdbapi.internal_static_proto_CollectionMembershipResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proto.CollectionMembershipResult.class, proto.CollectionMembershipResult.Builder.class);
    }

    // Construct using proto.CollectionMembershipResult.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      if (collectionmembershipsBuilder_ == null) {
        collectionmemberships_ = java.util.Collections.emptyList();
      } else {
        collectionmemberships_ = null;
        collectionmembershipsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return proto.Igdbapi.internal_static_proto_CollectionMembershipResult_descriptor;
    }

    @java.lang.Override
    public proto.CollectionMembershipResult getDefaultInstanceForType() {
      return proto.CollectionMembershipResult.getDefaultInstance();
    }

    @java.lang.Override
    public proto.CollectionMembershipResult build() {
      proto.CollectionMembershipResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public proto.CollectionMembershipResult buildPartial() {
      proto.CollectionMembershipResult result = new proto.CollectionMembershipResult(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(proto.CollectionMembershipResult result) {
      if (collectionmembershipsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          collectionmemberships_ = java.util.Collections.unmodifiableList(collectionmemberships_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.collectionmemberships_ = collectionmemberships_;
      } else {
        result.collectionmemberships_ = collectionmembershipsBuilder_.build();
      }
    }

    private void buildPartial0(proto.CollectionMembershipResult result) {
      int from_bitField0_ = bitField0_;
    }

    private int bitField0_;

    private java.util.List<proto.CollectionMembership> collectionmemberships_ =
      java.util.Collections.emptyList();
    private void ensureCollectionmembershipsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        collectionmemberships_ = new java.util.ArrayList<proto.CollectionMembership>(collectionmemberships_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        proto.CollectionMembership, proto.CollectionMembership.Builder, proto.CollectionMembershipOrBuilder> collectionmembershipsBuilder_;

    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public java.util.List<proto.CollectionMembership> getCollectionmembershipsList() {
      if (collectionmembershipsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(collectionmemberships_);
      } else {
        return collectionmembershipsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public int getCollectionmembershipsCount() {
      if (collectionmembershipsBuilder_ == null) {
        return collectionmemberships_.size();
      } else {
        return collectionmembershipsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public proto.CollectionMembership getCollectionmemberships(int index) {
      if (collectionmembershipsBuilder_ == null) {
        return collectionmemberships_.get(index);
      } else {
        return collectionmembershipsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public Builder setCollectionmemberships(
        int index, proto.CollectionMembership value) {
      if (collectionmembershipsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCollectionmembershipsIsMutable();
        collectionmemberships_.set(index, value);
        onChanged();
      } else {
        collectionmembershipsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public Builder setCollectionmemberships(
        int index, proto.CollectionMembership.Builder builderForValue) {
      if (collectionmembershipsBuilder_ == null) {
        ensureCollectionmembershipsIsMutable();
        collectionmemberships_.set(index, builderForValue.build());
        onChanged();
      } else {
        collectionmembershipsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public Builder addCollectionmemberships(proto.CollectionMembership value) {
      if (collectionmembershipsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCollectionmembershipsIsMutable();
        collectionmemberships_.add(value);
        onChanged();
      } else {
        collectionmembershipsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public Builder addCollectionmemberships(
        int index, proto.CollectionMembership value) {
      if (collectionmembershipsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCollectionmembershipsIsMutable();
        collectionmemberships_.add(index, value);
        onChanged();
      } else {
        collectionmembershipsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public Builder addCollectionmemberships(
        proto.CollectionMembership.Builder builderForValue) {
      if (collectionmembershipsBuilder_ == null) {
        ensureCollectionmembershipsIsMutable();
        collectionmemberships_.add(builderForValue.build());
        onChanged();
      } else {
        collectionmembershipsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public Builder addCollectionmemberships(
        int index, proto.CollectionMembership.Builder builderForValue) {
      if (collectionmembershipsBuilder_ == null) {
        ensureCollectionmembershipsIsMutable();
        collectionmemberships_.add(index, builderForValue.build());
        onChanged();
      } else {
        collectionmembershipsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public Builder addAllCollectionmemberships(
        java.lang.Iterable<? extends proto.CollectionMembership> values) {
      if (collectionmembershipsBuilder_ == null) {
        ensureCollectionmembershipsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, collectionmemberships_);
        onChanged();
      } else {
        collectionmembershipsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public Builder clearCollectionmemberships() {
      if (collectionmembershipsBuilder_ == null) {
        collectionmemberships_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        collectionmembershipsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public Builder removeCollectionmemberships(int index) {
      if (collectionmembershipsBuilder_ == null) {
        ensureCollectionmembershipsIsMutable();
        collectionmemberships_.remove(index);
        onChanged();
      } else {
        collectionmembershipsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public proto.CollectionMembership.Builder getCollectionmembershipsBuilder(
        int index) {
      return getCollectionmembershipsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public proto.CollectionMembershipOrBuilder getCollectionmembershipsOrBuilder(
        int index) {
      if (collectionmembershipsBuilder_ == null) {
        return collectionmemberships_.get(index);  } else {
        return collectionmembershipsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public java.util.List<? extends proto.CollectionMembershipOrBuilder> 
         getCollectionmembershipsOrBuilderList() {
      if (collectionmembershipsBuilder_ != null) {
        return collectionmembershipsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(collectionmemberships_);
      }
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public proto.CollectionMembership.Builder addCollectionmembershipsBuilder() {
      return getCollectionmembershipsFieldBuilder().addBuilder(
          proto.CollectionMembership.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public proto.CollectionMembership.Builder addCollectionmembershipsBuilder(
        int index) {
      return getCollectionmembershipsFieldBuilder().addBuilder(
          index, proto.CollectionMembership.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.CollectionMembership collectionmemberships = 1;</code>
     */
    public java.util.List<proto.CollectionMembership.Builder> 
         getCollectionmembershipsBuilderList() {
      return getCollectionmembershipsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        proto.CollectionMembership, proto.CollectionMembership.Builder, proto.CollectionMembershipOrBuilder> 
        getCollectionmembershipsFieldBuilder() {
      if (collectionmembershipsBuilder_ == null) {
        collectionmembershipsBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            proto.CollectionMembership, proto.CollectionMembership.Builder, proto.CollectionMembershipOrBuilder>(
                collectionmemberships_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        collectionmemberships_ = null;
      }
      return collectionmembershipsBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:proto.CollectionMembershipResult)
  }

  // @@protoc_insertion_point(class_scope:proto.CollectionMembershipResult)
  private static final proto.CollectionMembershipResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new proto.CollectionMembershipResult();
  }

  public static proto.CollectionMembershipResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CollectionMembershipResult>
      PARSER = new com.google.protobuf.AbstractParser<CollectionMembershipResult>() {
    @java.lang.Override
    public CollectionMembershipResult parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<CollectionMembershipResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CollectionMembershipResult> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public proto.CollectionMembershipResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
