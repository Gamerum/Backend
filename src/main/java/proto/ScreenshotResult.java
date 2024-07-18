// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

/**
 * Protobuf type {@code proto.ScreenshotResult}
 */
public final class ScreenshotResult extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:proto.ScreenshotResult)
    ScreenshotResultOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      ScreenshotResult.class.getName());
  }
  // Use ScreenshotResult.newBuilder() to construct.
  private ScreenshotResult(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private ScreenshotResult() {
    screenshots_ = java.util.Collections.emptyList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return proto.Igdbapi.internal_static_proto_ScreenshotResult_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return proto.Igdbapi.internal_static_proto_ScreenshotResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            proto.ScreenshotResult.class, proto.ScreenshotResult.Builder.class);
  }

  public static final int SCREENSHOTS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<proto.Screenshot> screenshots_;
  /**
   * <code>repeated .proto.Screenshot screenshots = 1;</code>
   */
  @java.lang.Override
  public java.util.List<proto.Screenshot> getScreenshotsList() {
    return screenshots_;
  }
  /**
   * <code>repeated .proto.Screenshot screenshots = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends proto.ScreenshotOrBuilder> 
      getScreenshotsOrBuilderList() {
    return screenshots_;
  }
  /**
   * <code>repeated .proto.Screenshot screenshots = 1;</code>
   */
  @java.lang.Override
  public int getScreenshotsCount() {
    return screenshots_.size();
  }
  /**
   * <code>repeated .proto.Screenshot screenshots = 1;</code>
   */
  @java.lang.Override
  public proto.Screenshot getScreenshots(int index) {
    return screenshots_.get(index);
  }
  /**
   * <code>repeated .proto.Screenshot screenshots = 1;</code>
   */
  @java.lang.Override
  public proto.ScreenshotOrBuilder getScreenshotsOrBuilder(
      int index) {
    return screenshots_.get(index);
  }

  public static proto.ScreenshotResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.ScreenshotResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.ScreenshotResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.ScreenshotResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.ScreenshotResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.ScreenshotResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.ScreenshotResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.ScreenshotResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static proto.ScreenshotResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static proto.ScreenshotResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static proto.ScreenshotResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.ScreenshotResult parseFrom(
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
  public static Builder newBuilder(proto.ScreenshotResult prototype) {
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
   * Protobuf type {@code proto.ScreenshotResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.ScreenshotResult)
      proto.ScreenshotResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proto.Igdbapi.internal_static_proto_ScreenshotResult_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proto.Igdbapi.internal_static_proto_ScreenshotResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proto.ScreenshotResult.class, proto.ScreenshotResult.Builder.class);
    }

    // Construct using proto.ScreenshotResult.newBuilder()
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
      if (screenshotsBuilder_ == null) {
        screenshots_ = java.util.Collections.emptyList();
      } else {
        screenshots_ = null;
        screenshotsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return proto.Igdbapi.internal_static_proto_ScreenshotResult_descriptor;
    }

    @java.lang.Override
    public proto.ScreenshotResult getDefaultInstanceForType() {
      return proto.ScreenshotResult.getDefaultInstance();
    }

    @java.lang.Override
    public proto.ScreenshotResult build() {
      proto.ScreenshotResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public proto.ScreenshotResult buildPartial() {
      proto.ScreenshotResult result = new proto.ScreenshotResult(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(proto.ScreenshotResult result) {
      if (screenshotsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          screenshots_ = java.util.Collections.unmodifiableList(screenshots_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.screenshots_ = screenshots_;
      } else {
        result.screenshots_ = screenshotsBuilder_.build();
      }
    }

    private void buildPartial0(proto.ScreenshotResult result) {
      int from_bitField0_ = bitField0_;
    }

    private int bitField0_;

    private java.util.List<proto.Screenshot> screenshots_ =
      java.util.Collections.emptyList();
    private void ensureScreenshotsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        screenshots_ = new java.util.ArrayList<proto.Screenshot>(screenshots_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        proto.Screenshot, proto.Screenshot.Builder, proto.ScreenshotOrBuilder> screenshotsBuilder_;

    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public java.util.List<proto.Screenshot> getScreenshotsList() {
      if (screenshotsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(screenshots_);
      } else {
        return screenshotsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public int getScreenshotsCount() {
      if (screenshotsBuilder_ == null) {
        return screenshots_.size();
      } else {
        return screenshotsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public proto.Screenshot getScreenshots(int index) {
      if (screenshotsBuilder_ == null) {
        return screenshots_.get(index);
      } else {
        return screenshotsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public Builder setScreenshots(
        int index, proto.Screenshot value) {
      if (screenshotsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureScreenshotsIsMutable();
        screenshots_.set(index, value);
        onChanged();
      } else {
        screenshotsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public Builder setScreenshots(
        int index, proto.Screenshot.Builder builderForValue) {
      if (screenshotsBuilder_ == null) {
        ensureScreenshotsIsMutable();
        screenshots_.set(index, builderForValue.build());
        onChanged();
      } else {
        screenshotsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public Builder addScreenshots(proto.Screenshot value) {
      if (screenshotsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureScreenshotsIsMutable();
        screenshots_.add(value);
        onChanged();
      } else {
        screenshotsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public Builder addScreenshots(
        int index, proto.Screenshot value) {
      if (screenshotsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureScreenshotsIsMutable();
        screenshots_.add(index, value);
        onChanged();
      } else {
        screenshotsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public Builder addScreenshots(
        proto.Screenshot.Builder builderForValue) {
      if (screenshotsBuilder_ == null) {
        ensureScreenshotsIsMutable();
        screenshots_.add(builderForValue.build());
        onChanged();
      } else {
        screenshotsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public Builder addScreenshots(
        int index, proto.Screenshot.Builder builderForValue) {
      if (screenshotsBuilder_ == null) {
        ensureScreenshotsIsMutable();
        screenshots_.add(index, builderForValue.build());
        onChanged();
      } else {
        screenshotsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public Builder addAllScreenshots(
        java.lang.Iterable<? extends proto.Screenshot> values) {
      if (screenshotsBuilder_ == null) {
        ensureScreenshotsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, screenshots_);
        onChanged();
      } else {
        screenshotsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public Builder clearScreenshots() {
      if (screenshotsBuilder_ == null) {
        screenshots_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        screenshotsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public Builder removeScreenshots(int index) {
      if (screenshotsBuilder_ == null) {
        ensureScreenshotsIsMutable();
        screenshots_.remove(index);
        onChanged();
      } else {
        screenshotsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public proto.Screenshot.Builder getScreenshotsBuilder(
        int index) {
      return getScreenshotsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public proto.ScreenshotOrBuilder getScreenshotsOrBuilder(
        int index) {
      if (screenshotsBuilder_ == null) {
        return screenshots_.get(index);  } else {
        return screenshotsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public java.util.List<? extends proto.ScreenshotOrBuilder> 
         getScreenshotsOrBuilderList() {
      if (screenshotsBuilder_ != null) {
        return screenshotsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(screenshots_);
      }
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public proto.Screenshot.Builder addScreenshotsBuilder() {
      return getScreenshotsFieldBuilder().addBuilder(
          proto.Screenshot.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public proto.Screenshot.Builder addScreenshotsBuilder(
        int index) {
      return getScreenshotsFieldBuilder().addBuilder(
          index, proto.Screenshot.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.Screenshot screenshots = 1;</code>
     */
    public java.util.List<proto.Screenshot.Builder> 
         getScreenshotsBuilderList() {
      return getScreenshotsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        proto.Screenshot, proto.Screenshot.Builder, proto.ScreenshotOrBuilder> 
        getScreenshotsFieldBuilder() {
      if (screenshotsBuilder_ == null) {
        screenshotsBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            proto.Screenshot, proto.Screenshot.Builder, proto.ScreenshotOrBuilder>(
                screenshots_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        screenshots_ = null;
      }
      return screenshotsBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:proto.ScreenshotResult)
  }

  // @@protoc_insertion_point(class_scope:proto.ScreenshotResult)
  private static final proto.ScreenshotResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new proto.ScreenshotResult();
  }

  public static proto.ScreenshotResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ScreenshotResult>
      PARSER = new com.google.protobuf.AbstractParser<ScreenshotResult>() {
    @java.lang.Override
    public ScreenshotResult parsePartialFrom(
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

  public static com.google.protobuf.Parser<ScreenshotResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ScreenshotResult> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public proto.ScreenshotResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

