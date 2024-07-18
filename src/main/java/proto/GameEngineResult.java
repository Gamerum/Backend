// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

/**
 * Protobuf type {@code proto.GameEngineResult}
 */
public final class GameEngineResult extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:proto.GameEngineResult)
    GameEngineResultOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      GameEngineResult.class.getName());
  }
  // Use GameEngineResult.newBuilder() to construct.
  private GameEngineResult(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private GameEngineResult() {
    gameengines_ = java.util.Collections.emptyList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return proto.Igdbapi.internal_static_proto_GameEngineResult_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return proto.Igdbapi.internal_static_proto_GameEngineResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            proto.GameEngineResult.class, proto.GameEngineResult.Builder.class);
  }

  public static final int GAMEENGINES_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<proto.GameEngine> gameengines_;
  /**
   * <code>repeated .proto.GameEngine gameengines = 1;</code>
   */
  @java.lang.Override
  public java.util.List<proto.GameEngine> getGameenginesList() {
    return gameengines_;
  }
  /**
   * <code>repeated .proto.GameEngine gameengines = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends proto.GameEngineOrBuilder> 
      getGameenginesOrBuilderList() {
    return gameengines_;
  }
  /**
   * <code>repeated .proto.GameEngine gameengines = 1;</code>
   */
  @java.lang.Override
  public int getGameenginesCount() {
    return gameengines_.size();
  }
  /**
   * <code>repeated .proto.GameEngine gameengines = 1;</code>
   */
  @java.lang.Override
  public proto.GameEngine getGameengines(int index) {
    return gameengines_.get(index);
  }
  /**
   * <code>repeated .proto.GameEngine gameengines = 1;</code>
   */
  @java.lang.Override
  public proto.GameEngineOrBuilder getGameenginesOrBuilder(
      int index) {
    return gameengines_.get(index);
  }

  public static proto.GameEngineResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.GameEngineResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.GameEngineResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.GameEngineResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.GameEngineResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.GameEngineResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.GameEngineResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.GameEngineResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static proto.GameEngineResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static proto.GameEngineResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static proto.GameEngineResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.GameEngineResult parseFrom(
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
  public static Builder newBuilder(proto.GameEngineResult prototype) {
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
   * Protobuf type {@code proto.GameEngineResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.GameEngineResult)
      proto.GameEngineResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proto.Igdbapi.internal_static_proto_GameEngineResult_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proto.Igdbapi.internal_static_proto_GameEngineResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proto.GameEngineResult.class, proto.GameEngineResult.Builder.class);
    }

    // Construct using proto.GameEngineResult.newBuilder()
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
      if (gameenginesBuilder_ == null) {
        gameengines_ = java.util.Collections.emptyList();
      } else {
        gameengines_ = null;
        gameenginesBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return proto.Igdbapi.internal_static_proto_GameEngineResult_descriptor;
    }

    @java.lang.Override
    public proto.GameEngineResult getDefaultInstanceForType() {
      return proto.GameEngineResult.getDefaultInstance();
    }

    @java.lang.Override
    public proto.GameEngineResult build() {
      proto.GameEngineResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public proto.GameEngineResult buildPartial() {
      proto.GameEngineResult result = new proto.GameEngineResult(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(proto.GameEngineResult result) {
      if (gameenginesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          gameengines_ = java.util.Collections.unmodifiableList(gameengines_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.gameengines_ = gameengines_;
      } else {
        result.gameengines_ = gameenginesBuilder_.build();
      }
    }

    private void buildPartial0(proto.GameEngineResult result) {
      int from_bitField0_ = bitField0_;
    }

    private int bitField0_;

    private java.util.List<proto.GameEngine> gameengines_ =
      java.util.Collections.emptyList();
    private void ensureGameenginesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        gameengines_ = new java.util.ArrayList<proto.GameEngine>(gameengines_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        proto.GameEngine, proto.GameEngine.Builder, proto.GameEngineOrBuilder> gameenginesBuilder_;

    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public java.util.List<proto.GameEngine> getGameenginesList() {
      if (gameenginesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(gameengines_);
      } else {
        return gameenginesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public int getGameenginesCount() {
      if (gameenginesBuilder_ == null) {
        return gameengines_.size();
      } else {
        return gameenginesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public proto.GameEngine getGameengines(int index) {
      if (gameenginesBuilder_ == null) {
        return gameengines_.get(index);
      } else {
        return gameenginesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public Builder setGameengines(
        int index, proto.GameEngine value) {
      if (gameenginesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGameenginesIsMutable();
        gameengines_.set(index, value);
        onChanged();
      } else {
        gameenginesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public Builder setGameengines(
        int index, proto.GameEngine.Builder builderForValue) {
      if (gameenginesBuilder_ == null) {
        ensureGameenginesIsMutable();
        gameengines_.set(index, builderForValue.build());
        onChanged();
      } else {
        gameenginesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public Builder addGameengines(proto.GameEngine value) {
      if (gameenginesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGameenginesIsMutable();
        gameengines_.add(value);
        onChanged();
      } else {
        gameenginesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public Builder addGameengines(
        int index, proto.GameEngine value) {
      if (gameenginesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGameenginesIsMutable();
        gameengines_.add(index, value);
        onChanged();
      } else {
        gameenginesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public Builder addGameengines(
        proto.GameEngine.Builder builderForValue) {
      if (gameenginesBuilder_ == null) {
        ensureGameenginesIsMutable();
        gameengines_.add(builderForValue.build());
        onChanged();
      } else {
        gameenginesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public Builder addGameengines(
        int index, proto.GameEngine.Builder builderForValue) {
      if (gameenginesBuilder_ == null) {
        ensureGameenginesIsMutable();
        gameengines_.add(index, builderForValue.build());
        onChanged();
      } else {
        gameenginesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public Builder addAllGameengines(
        java.lang.Iterable<? extends proto.GameEngine> values) {
      if (gameenginesBuilder_ == null) {
        ensureGameenginesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, gameengines_);
        onChanged();
      } else {
        gameenginesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public Builder clearGameengines() {
      if (gameenginesBuilder_ == null) {
        gameengines_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        gameenginesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public Builder removeGameengines(int index) {
      if (gameenginesBuilder_ == null) {
        ensureGameenginesIsMutable();
        gameengines_.remove(index);
        onChanged();
      } else {
        gameenginesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public proto.GameEngine.Builder getGameenginesBuilder(
        int index) {
      return getGameenginesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public proto.GameEngineOrBuilder getGameenginesOrBuilder(
        int index) {
      if (gameenginesBuilder_ == null) {
        return gameengines_.get(index);  } else {
        return gameenginesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public java.util.List<? extends proto.GameEngineOrBuilder> 
         getGameenginesOrBuilderList() {
      if (gameenginesBuilder_ != null) {
        return gameenginesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(gameengines_);
      }
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public proto.GameEngine.Builder addGameenginesBuilder() {
      return getGameenginesFieldBuilder().addBuilder(
          proto.GameEngine.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public proto.GameEngine.Builder addGameenginesBuilder(
        int index) {
      return getGameenginesFieldBuilder().addBuilder(
          index, proto.GameEngine.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.GameEngine gameengines = 1;</code>
     */
    public java.util.List<proto.GameEngine.Builder> 
         getGameenginesBuilderList() {
      return getGameenginesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        proto.GameEngine, proto.GameEngine.Builder, proto.GameEngineOrBuilder> 
        getGameenginesFieldBuilder() {
      if (gameenginesBuilder_ == null) {
        gameenginesBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            proto.GameEngine, proto.GameEngine.Builder, proto.GameEngineOrBuilder>(
                gameengines_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        gameengines_ = null;
      }
      return gameenginesBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:proto.GameEngineResult)
  }

  // @@protoc_insertion_point(class_scope:proto.GameEngineResult)
  private static final proto.GameEngineResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new proto.GameEngineResult();
  }

  public static proto.GameEngineResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GameEngineResult>
      PARSER = new com.google.protobuf.AbstractParser<GameEngineResult>() {
    @java.lang.Override
    public GameEngineResult parsePartialFrom(
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

  public static com.google.protobuf.Parser<GameEngineResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GameEngineResult> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public proto.GameEngineResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

