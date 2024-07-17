// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

/**
 * Protobuf type {@code proto.GameVersionFeatureValueResult}
 */
public final class GameVersionFeatureValueResult extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:proto.GameVersionFeatureValueResult)
    GameVersionFeatureValueResultOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      GameVersionFeatureValueResult.class.getName());
  }
  // Use GameVersionFeatureValueResult.newBuilder() to construct.
  private GameVersionFeatureValueResult(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private GameVersionFeatureValueResult() {
    gameversionfeaturevalues_ = java.util.Collections.emptyList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return proto.Igdbapi.internal_static_proto_GameVersionFeatureValueResult_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return proto.Igdbapi.internal_static_proto_GameVersionFeatureValueResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            proto.GameVersionFeatureValueResult.class, proto.GameVersionFeatureValueResult.Builder.class);
  }

  public static final int GAMEVERSIONFEATUREVALUES_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<proto.GameVersionFeatureValue> gameversionfeaturevalues_;
  /**
   * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
   */
  @java.lang.Override
  public java.util.List<proto.GameVersionFeatureValue> getGameversionfeaturevaluesList() {
    return gameversionfeaturevalues_;
  }
  /**
   * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends proto.GameVersionFeatureValueOrBuilder> 
      getGameversionfeaturevaluesOrBuilderList() {
    return gameversionfeaturevalues_;
  }
  /**
   * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
   */
  @java.lang.Override
  public int getGameversionfeaturevaluesCount() {
    return gameversionfeaturevalues_.size();
  }
  /**
   * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
   */
  @java.lang.Override
  public proto.GameVersionFeatureValue getGameversionfeaturevalues(int index) {
    return gameversionfeaturevalues_.get(index);
  }
  /**
   * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
   */
  @java.lang.Override
  public proto.GameVersionFeatureValueOrBuilder getGameversionfeaturevaluesOrBuilder(
      int index) {
    return gameversionfeaturevalues_.get(index);
  }

  public static proto.GameVersionFeatureValueResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.GameVersionFeatureValueResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.GameVersionFeatureValueResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.GameVersionFeatureValueResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.GameVersionFeatureValueResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.GameVersionFeatureValueResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.GameVersionFeatureValueResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.GameVersionFeatureValueResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static proto.GameVersionFeatureValueResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static proto.GameVersionFeatureValueResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static proto.GameVersionFeatureValueResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.GameVersionFeatureValueResult parseFrom(
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
  public static Builder newBuilder(proto.GameVersionFeatureValueResult prototype) {
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
   * Protobuf type {@code proto.GameVersionFeatureValueResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.GameVersionFeatureValueResult)
      proto.GameVersionFeatureValueResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proto.Igdbapi.internal_static_proto_GameVersionFeatureValueResult_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proto.Igdbapi.internal_static_proto_GameVersionFeatureValueResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proto.GameVersionFeatureValueResult.class, proto.GameVersionFeatureValueResult.Builder.class);
    }

    // Construct using proto.GameVersionFeatureValueResult.newBuilder()
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
      if (gameversionfeaturevaluesBuilder_ == null) {
        gameversionfeaturevalues_ = java.util.Collections.emptyList();
      } else {
        gameversionfeaturevalues_ = null;
        gameversionfeaturevaluesBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return proto.Igdbapi.internal_static_proto_GameVersionFeatureValueResult_descriptor;
    }

    @java.lang.Override
    public proto.GameVersionFeatureValueResult getDefaultInstanceForType() {
      return proto.GameVersionFeatureValueResult.getDefaultInstance();
    }

    @java.lang.Override
    public proto.GameVersionFeatureValueResult build() {
      proto.GameVersionFeatureValueResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public proto.GameVersionFeatureValueResult buildPartial() {
      proto.GameVersionFeatureValueResult result = new proto.GameVersionFeatureValueResult(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(proto.GameVersionFeatureValueResult result) {
      if (gameversionfeaturevaluesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          gameversionfeaturevalues_ = java.util.Collections.unmodifiableList(gameversionfeaturevalues_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.gameversionfeaturevalues_ = gameversionfeaturevalues_;
      } else {
        result.gameversionfeaturevalues_ = gameversionfeaturevaluesBuilder_.build();
      }
    }

    private void buildPartial0(proto.GameVersionFeatureValueResult result) {
      int from_bitField0_ = bitField0_;
    }

    private int bitField0_;

    private java.util.List<proto.GameVersionFeatureValue> gameversionfeaturevalues_ =
      java.util.Collections.emptyList();
    private void ensureGameversionfeaturevaluesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        gameversionfeaturevalues_ = new java.util.ArrayList<proto.GameVersionFeatureValue>(gameversionfeaturevalues_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        proto.GameVersionFeatureValue, proto.GameVersionFeatureValue.Builder, proto.GameVersionFeatureValueOrBuilder> gameversionfeaturevaluesBuilder_;

    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public java.util.List<proto.GameVersionFeatureValue> getGameversionfeaturevaluesList() {
      if (gameversionfeaturevaluesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(gameversionfeaturevalues_);
      } else {
        return gameversionfeaturevaluesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public int getGameversionfeaturevaluesCount() {
      if (gameversionfeaturevaluesBuilder_ == null) {
        return gameversionfeaturevalues_.size();
      } else {
        return gameversionfeaturevaluesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public proto.GameVersionFeatureValue getGameversionfeaturevalues(int index) {
      if (gameversionfeaturevaluesBuilder_ == null) {
        return gameversionfeaturevalues_.get(index);
      } else {
        return gameversionfeaturevaluesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public Builder setGameversionfeaturevalues(
        int index, proto.GameVersionFeatureValue value) {
      if (gameversionfeaturevaluesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGameversionfeaturevaluesIsMutable();
        gameversionfeaturevalues_.set(index, value);
        onChanged();
      } else {
        gameversionfeaturevaluesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public Builder setGameversionfeaturevalues(
        int index, proto.GameVersionFeatureValue.Builder builderForValue) {
      if (gameversionfeaturevaluesBuilder_ == null) {
        ensureGameversionfeaturevaluesIsMutable();
        gameversionfeaturevalues_.set(index, builderForValue.build());
        onChanged();
      } else {
        gameversionfeaturevaluesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public Builder addGameversionfeaturevalues(proto.GameVersionFeatureValue value) {
      if (gameversionfeaturevaluesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGameversionfeaturevaluesIsMutable();
        gameversionfeaturevalues_.add(value);
        onChanged();
      } else {
        gameversionfeaturevaluesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public Builder addGameversionfeaturevalues(
        int index, proto.GameVersionFeatureValue value) {
      if (gameversionfeaturevaluesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGameversionfeaturevaluesIsMutable();
        gameversionfeaturevalues_.add(index, value);
        onChanged();
      } else {
        gameversionfeaturevaluesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public Builder addGameversionfeaturevalues(
        proto.GameVersionFeatureValue.Builder builderForValue) {
      if (gameversionfeaturevaluesBuilder_ == null) {
        ensureGameversionfeaturevaluesIsMutable();
        gameversionfeaturevalues_.add(builderForValue.build());
        onChanged();
      } else {
        gameversionfeaturevaluesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public Builder addGameversionfeaturevalues(
        int index, proto.GameVersionFeatureValue.Builder builderForValue) {
      if (gameversionfeaturevaluesBuilder_ == null) {
        ensureGameversionfeaturevaluesIsMutable();
        gameversionfeaturevalues_.add(index, builderForValue.build());
        onChanged();
      } else {
        gameversionfeaturevaluesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public Builder addAllGameversionfeaturevalues(
        java.lang.Iterable<? extends proto.GameVersionFeatureValue> values) {
      if (gameversionfeaturevaluesBuilder_ == null) {
        ensureGameversionfeaturevaluesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, gameversionfeaturevalues_);
        onChanged();
      } else {
        gameversionfeaturevaluesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public Builder clearGameversionfeaturevalues() {
      if (gameversionfeaturevaluesBuilder_ == null) {
        gameversionfeaturevalues_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        gameversionfeaturevaluesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public Builder removeGameversionfeaturevalues(int index) {
      if (gameversionfeaturevaluesBuilder_ == null) {
        ensureGameversionfeaturevaluesIsMutable();
        gameversionfeaturevalues_.remove(index);
        onChanged();
      } else {
        gameversionfeaturevaluesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public proto.GameVersionFeatureValue.Builder getGameversionfeaturevaluesBuilder(
        int index) {
      return getGameversionfeaturevaluesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public proto.GameVersionFeatureValueOrBuilder getGameversionfeaturevaluesOrBuilder(
        int index) {
      if (gameversionfeaturevaluesBuilder_ == null) {
        return gameversionfeaturevalues_.get(index);  } else {
        return gameversionfeaturevaluesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public java.util.List<? extends proto.GameVersionFeatureValueOrBuilder> 
         getGameversionfeaturevaluesOrBuilderList() {
      if (gameversionfeaturevaluesBuilder_ != null) {
        return gameversionfeaturevaluesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(gameversionfeaturevalues_);
      }
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public proto.GameVersionFeatureValue.Builder addGameversionfeaturevaluesBuilder() {
      return getGameversionfeaturevaluesFieldBuilder().addBuilder(
          proto.GameVersionFeatureValue.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public proto.GameVersionFeatureValue.Builder addGameversionfeaturevaluesBuilder(
        int index) {
      return getGameversionfeaturevaluesFieldBuilder().addBuilder(
          index, proto.GameVersionFeatureValue.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.GameVersionFeatureValue gameversionfeaturevalues = 1;</code>
     */
    public java.util.List<proto.GameVersionFeatureValue.Builder> 
         getGameversionfeaturevaluesBuilderList() {
      return getGameversionfeaturevaluesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        proto.GameVersionFeatureValue, proto.GameVersionFeatureValue.Builder, proto.GameVersionFeatureValueOrBuilder> 
        getGameversionfeaturevaluesFieldBuilder() {
      if (gameversionfeaturevaluesBuilder_ == null) {
        gameversionfeaturevaluesBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            proto.GameVersionFeatureValue, proto.GameVersionFeatureValue.Builder, proto.GameVersionFeatureValueOrBuilder>(
                gameversionfeaturevalues_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        gameversionfeaturevalues_ = null;
      }
      return gameversionfeaturevaluesBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:proto.GameVersionFeatureValueResult)
  }

  // @@protoc_insertion_point(class_scope:proto.GameVersionFeatureValueResult)
  private static final proto.GameVersionFeatureValueResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new proto.GameVersionFeatureValueResult();
  }

  public static proto.GameVersionFeatureValueResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GameVersionFeatureValueResult>
      PARSER = new com.google.protobuf.AbstractParser<GameVersionFeatureValueResult>() {
    @java.lang.Override
    public GameVersionFeatureValueResult parsePartialFrom(
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

  public static com.google.protobuf.Parser<GameVersionFeatureValueResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GameVersionFeatureValueResult> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public proto.GameVersionFeatureValueResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

