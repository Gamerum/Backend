// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

/**
 * Protobuf type {@code proto.PlatformVersionResult}
 */
public final class PlatformVersionResult extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:proto.PlatformVersionResult)
    PlatformVersionResultOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      PlatformVersionResult.class.getName());
  }
  // Use PlatformVersionResult.newBuilder() to construct.
  private PlatformVersionResult(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private PlatformVersionResult() {
    platformversions_ = java.util.Collections.emptyList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return proto.Igdbapi.internal_static_proto_PlatformVersionResult_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return proto.Igdbapi.internal_static_proto_PlatformVersionResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            proto.PlatformVersionResult.class, proto.PlatformVersionResult.Builder.class);
  }

  public static final int PLATFORMVERSIONS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<proto.PlatformVersion> platformversions_;
  /**
   * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
   */
  @java.lang.Override
  public java.util.List<proto.PlatformVersion> getPlatformversionsList() {
    return platformversions_;
  }
  /**
   * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends proto.PlatformVersionOrBuilder> 
      getPlatformversionsOrBuilderList() {
    return platformversions_;
  }
  /**
   * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
   */
  @java.lang.Override
  public int getPlatformversionsCount() {
    return platformversions_.size();
  }
  /**
   * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
   */
  @java.lang.Override
  public proto.PlatformVersion getPlatformversions(int index) {
    return platformversions_.get(index);
  }
  /**
   * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
   */
  @java.lang.Override
  public proto.PlatformVersionOrBuilder getPlatformversionsOrBuilder(
      int index) {
    return platformversions_.get(index);
  }

  public static proto.PlatformVersionResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.PlatformVersionResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.PlatformVersionResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.PlatformVersionResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.PlatformVersionResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.PlatformVersionResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.PlatformVersionResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.PlatformVersionResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static proto.PlatformVersionResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static proto.PlatformVersionResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static proto.PlatformVersionResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.PlatformVersionResult parseFrom(
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
  public static Builder newBuilder(proto.PlatformVersionResult prototype) {
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
   * Protobuf type {@code proto.PlatformVersionResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.PlatformVersionResult)
      proto.PlatformVersionResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proto.Igdbapi.internal_static_proto_PlatformVersionResult_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proto.Igdbapi.internal_static_proto_PlatformVersionResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proto.PlatformVersionResult.class, proto.PlatformVersionResult.Builder.class);
    }

    // Construct using proto.PlatformVersionResult.newBuilder()
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
      if (platformversionsBuilder_ == null) {
        platformversions_ = java.util.Collections.emptyList();
      } else {
        platformversions_ = null;
        platformversionsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return proto.Igdbapi.internal_static_proto_PlatformVersionResult_descriptor;
    }

    @java.lang.Override
    public proto.PlatformVersionResult getDefaultInstanceForType() {
      return proto.PlatformVersionResult.getDefaultInstance();
    }

    @java.lang.Override
    public proto.PlatformVersionResult build() {
      proto.PlatformVersionResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public proto.PlatformVersionResult buildPartial() {
      proto.PlatformVersionResult result = new proto.PlatformVersionResult(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(proto.PlatformVersionResult result) {
      if (platformversionsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          platformversions_ = java.util.Collections.unmodifiableList(platformversions_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.platformversions_ = platformversions_;
      } else {
        result.platformversions_ = platformversionsBuilder_.build();
      }
    }

    private void buildPartial0(proto.PlatformVersionResult result) {
      int from_bitField0_ = bitField0_;
    }

    private int bitField0_;

    private java.util.List<proto.PlatformVersion> platformversions_ =
      java.util.Collections.emptyList();
    private void ensurePlatformversionsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        platformversions_ = new java.util.ArrayList<proto.PlatformVersion>(platformversions_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        proto.PlatformVersion, proto.PlatformVersion.Builder, proto.PlatformVersionOrBuilder> platformversionsBuilder_;

    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public java.util.List<proto.PlatformVersion> getPlatformversionsList() {
      if (platformversionsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(platformversions_);
      } else {
        return platformversionsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public int getPlatformversionsCount() {
      if (platformversionsBuilder_ == null) {
        return platformversions_.size();
      } else {
        return platformversionsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public proto.PlatformVersion getPlatformversions(int index) {
      if (platformversionsBuilder_ == null) {
        return platformversions_.get(index);
      } else {
        return platformversionsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public Builder setPlatformversions(
        int index, proto.PlatformVersion value) {
      if (platformversionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePlatformversionsIsMutable();
        platformversions_.set(index, value);
        onChanged();
      } else {
        platformversionsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public Builder setPlatformversions(
        int index, proto.PlatformVersion.Builder builderForValue) {
      if (platformversionsBuilder_ == null) {
        ensurePlatformversionsIsMutable();
        platformversions_.set(index, builderForValue.build());
        onChanged();
      } else {
        platformversionsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public Builder addPlatformversions(proto.PlatformVersion value) {
      if (platformversionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePlatformversionsIsMutable();
        platformversions_.add(value);
        onChanged();
      } else {
        platformversionsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public Builder addPlatformversions(
        int index, proto.PlatformVersion value) {
      if (platformversionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePlatformversionsIsMutable();
        platformversions_.add(index, value);
        onChanged();
      } else {
        platformversionsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public Builder addPlatformversions(
        proto.PlatformVersion.Builder builderForValue) {
      if (platformversionsBuilder_ == null) {
        ensurePlatformversionsIsMutable();
        platformversions_.add(builderForValue.build());
        onChanged();
      } else {
        platformversionsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public Builder addPlatformversions(
        int index, proto.PlatformVersion.Builder builderForValue) {
      if (platformversionsBuilder_ == null) {
        ensurePlatformversionsIsMutable();
        platformversions_.add(index, builderForValue.build());
        onChanged();
      } else {
        platformversionsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public Builder addAllPlatformversions(
        java.lang.Iterable<? extends proto.PlatformVersion> values) {
      if (platformversionsBuilder_ == null) {
        ensurePlatformversionsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, platformversions_);
        onChanged();
      } else {
        platformversionsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public Builder clearPlatformversions() {
      if (platformversionsBuilder_ == null) {
        platformversions_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        platformversionsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public Builder removePlatformversions(int index) {
      if (platformversionsBuilder_ == null) {
        ensurePlatformversionsIsMutable();
        platformversions_.remove(index);
        onChanged();
      } else {
        platformversionsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public proto.PlatformVersion.Builder getPlatformversionsBuilder(
        int index) {
      return getPlatformversionsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public proto.PlatformVersionOrBuilder getPlatformversionsOrBuilder(
        int index) {
      if (platformversionsBuilder_ == null) {
        return platformversions_.get(index);  } else {
        return platformversionsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public java.util.List<? extends proto.PlatformVersionOrBuilder> 
         getPlatformversionsOrBuilderList() {
      if (platformversionsBuilder_ != null) {
        return platformversionsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(platformversions_);
      }
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public proto.PlatformVersion.Builder addPlatformversionsBuilder() {
      return getPlatformversionsFieldBuilder().addBuilder(
          proto.PlatformVersion.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public proto.PlatformVersion.Builder addPlatformversionsBuilder(
        int index) {
      return getPlatformversionsFieldBuilder().addBuilder(
          index, proto.PlatformVersion.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.PlatformVersion platformversions = 1;</code>
     */
    public java.util.List<proto.PlatformVersion.Builder> 
         getPlatformversionsBuilderList() {
      return getPlatformversionsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        proto.PlatformVersion, proto.PlatformVersion.Builder, proto.PlatformVersionOrBuilder> 
        getPlatformversionsFieldBuilder() {
      if (platformversionsBuilder_ == null) {
        platformversionsBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            proto.PlatformVersion, proto.PlatformVersion.Builder, proto.PlatformVersionOrBuilder>(
                platformversions_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        platformversions_ = null;
      }
      return platformversionsBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:proto.PlatformVersionResult)
  }

  // @@protoc_insertion_point(class_scope:proto.PlatformVersionResult)
  private static final proto.PlatformVersionResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new proto.PlatformVersionResult();
  }

  public static proto.PlatformVersionResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PlatformVersionResult>
      PARSER = new com.google.protobuf.AbstractParser<PlatformVersionResult>() {
    @java.lang.Override
    public PlatformVersionResult parsePartialFrom(
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

  public static com.google.protobuf.Parser<PlatformVersionResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PlatformVersionResult> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public proto.PlatformVersionResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
