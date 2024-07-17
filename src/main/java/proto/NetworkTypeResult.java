// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

/**
 * Protobuf type {@code proto.NetworkTypeResult}
 */
public final class NetworkTypeResult extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:proto.NetworkTypeResult)
    NetworkTypeResultOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      NetworkTypeResult.class.getName());
  }
  // Use NetworkTypeResult.newBuilder() to construct.
  private NetworkTypeResult(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private NetworkTypeResult() {
    networktypes_ = java.util.Collections.emptyList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return proto.Igdbapi.internal_static_proto_NetworkTypeResult_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return proto.Igdbapi.internal_static_proto_NetworkTypeResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            proto.NetworkTypeResult.class, proto.NetworkTypeResult.Builder.class);
  }

  public static final int NETWORKTYPES_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<proto.NetworkType> networktypes_;
  /**
   * <code>repeated .proto.NetworkType networktypes = 1;</code>
   */
  @java.lang.Override
  public java.util.List<proto.NetworkType> getNetworktypesList() {
    return networktypes_;
  }
  /**
   * <code>repeated .proto.NetworkType networktypes = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends proto.NetworkTypeOrBuilder> 
      getNetworktypesOrBuilderList() {
    return networktypes_;
  }
  /**
   * <code>repeated .proto.NetworkType networktypes = 1;</code>
   */
  @java.lang.Override
  public int getNetworktypesCount() {
    return networktypes_.size();
  }
  /**
   * <code>repeated .proto.NetworkType networktypes = 1;</code>
   */
  @java.lang.Override
  public proto.NetworkType getNetworktypes(int index) {
    return networktypes_.get(index);
  }
  /**
   * <code>repeated .proto.NetworkType networktypes = 1;</code>
   */
  @java.lang.Override
  public proto.NetworkTypeOrBuilder getNetworktypesOrBuilder(
      int index) {
    return networktypes_.get(index);
  }

  public static proto.NetworkTypeResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.NetworkTypeResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.NetworkTypeResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.NetworkTypeResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.NetworkTypeResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.NetworkTypeResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.NetworkTypeResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.NetworkTypeResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static proto.NetworkTypeResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static proto.NetworkTypeResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static proto.NetworkTypeResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.NetworkTypeResult parseFrom(
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
  public static Builder newBuilder(proto.NetworkTypeResult prototype) {
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
   * Protobuf type {@code proto.NetworkTypeResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.NetworkTypeResult)
      proto.NetworkTypeResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proto.Igdbapi.internal_static_proto_NetworkTypeResult_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proto.Igdbapi.internal_static_proto_NetworkTypeResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proto.NetworkTypeResult.class, proto.NetworkTypeResult.Builder.class);
    }

    // Construct using proto.NetworkTypeResult.newBuilder()
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
      if (networktypesBuilder_ == null) {
        networktypes_ = java.util.Collections.emptyList();
      } else {
        networktypes_ = null;
        networktypesBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return proto.Igdbapi.internal_static_proto_NetworkTypeResult_descriptor;
    }

    @java.lang.Override
    public proto.NetworkTypeResult getDefaultInstanceForType() {
      return proto.NetworkTypeResult.getDefaultInstance();
    }

    @java.lang.Override
    public proto.NetworkTypeResult build() {
      proto.NetworkTypeResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public proto.NetworkTypeResult buildPartial() {
      proto.NetworkTypeResult result = new proto.NetworkTypeResult(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(proto.NetworkTypeResult result) {
      if (networktypesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          networktypes_ = java.util.Collections.unmodifiableList(networktypes_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.networktypes_ = networktypes_;
      } else {
        result.networktypes_ = networktypesBuilder_.build();
      }
    }

    private void buildPartial0(proto.NetworkTypeResult result) {
      int from_bitField0_ = bitField0_;
    }

    private int bitField0_;

    private java.util.List<proto.NetworkType> networktypes_ =
      java.util.Collections.emptyList();
    private void ensureNetworktypesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        networktypes_ = new java.util.ArrayList<proto.NetworkType>(networktypes_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        proto.NetworkType, proto.NetworkType.Builder, proto.NetworkTypeOrBuilder> networktypesBuilder_;

    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public java.util.List<proto.NetworkType> getNetworktypesList() {
      if (networktypesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(networktypes_);
      } else {
        return networktypesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public int getNetworktypesCount() {
      if (networktypesBuilder_ == null) {
        return networktypes_.size();
      } else {
        return networktypesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public proto.NetworkType getNetworktypes(int index) {
      if (networktypesBuilder_ == null) {
        return networktypes_.get(index);
      } else {
        return networktypesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public Builder setNetworktypes(
        int index, proto.NetworkType value) {
      if (networktypesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureNetworktypesIsMutable();
        networktypes_.set(index, value);
        onChanged();
      } else {
        networktypesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public Builder setNetworktypes(
        int index, proto.NetworkType.Builder builderForValue) {
      if (networktypesBuilder_ == null) {
        ensureNetworktypesIsMutable();
        networktypes_.set(index, builderForValue.build());
        onChanged();
      } else {
        networktypesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public Builder addNetworktypes(proto.NetworkType value) {
      if (networktypesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureNetworktypesIsMutable();
        networktypes_.add(value);
        onChanged();
      } else {
        networktypesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public Builder addNetworktypes(
        int index, proto.NetworkType value) {
      if (networktypesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureNetworktypesIsMutable();
        networktypes_.add(index, value);
        onChanged();
      } else {
        networktypesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public Builder addNetworktypes(
        proto.NetworkType.Builder builderForValue) {
      if (networktypesBuilder_ == null) {
        ensureNetworktypesIsMutable();
        networktypes_.add(builderForValue.build());
        onChanged();
      } else {
        networktypesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public Builder addNetworktypes(
        int index, proto.NetworkType.Builder builderForValue) {
      if (networktypesBuilder_ == null) {
        ensureNetworktypesIsMutable();
        networktypes_.add(index, builderForValue.build());
        onChanged();
      } else {
        networktypesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public Builder addAllNetworktypes(
        java.lang.Iterable<? extends proto.NetworkType> values) {
      if (networktypesBuilder_ == null) {
        ensureNetworktypesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, networktypes_);
        onChanged();
      } else {
        networktypesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public Builder clearNetworktypes() {
      if (networktypesBuilder_ == null) {
        networktypes_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        networktypesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public Builder removeNetworktypes(int index) {
      if (networktypesBuilder_ == null) {
        ensureNetworktypesIsMutable();
        networktypes_.remove(index);
        onChanged();
      } else {
        networktypesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public proto.NetworkType.Builder getNetworktypesBuilder(
        int index) {
      return getNetworktypesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public proto.NetworkTypeOrBuilder getNetworktypesOrBuilder(
        int index) {
      if (networktypesBuilder_ == null) {
        return networktypes_.get(index);  } else {
        return networktypesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public java.util.List<? extends proto.NetworkTypeOrBuilder> 
         getNetworktypesOrBuilderList() {
      if (networktypesBuilder_ != null) {
        return networktypesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(networktypes_);
      }
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public proto.NetworkType.Builder addNetworktypesBuilder() {
      return getNetworktypesFieldBuilder().addBuilder(
          proto.NetworkType.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public proto.NetworkType.Builder addNetworktypesBuilder(
        int index) {
      return getNetworktypesFieldBuilder().addBuilder(
          index, proto.NetworkType.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.NetworkType networktypes = 1;</code>
     */
    public java.util.List<proto.NetworkType.Builder> 
         getNetworktypesBuilderList() {
      return getNetworktypesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        proto.NetworkType, proto.NetworkType.Builder, proto.NetworkTypeOrBuilder> 
        getNetworktypesFieldBuilder() {
      if (networktypesBuilder_ == null) {
        networktypesBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            proto.NetworkType, proto.NetworkType.Builder, proto.NetworkTypeOrBuilder>(
                networktypes_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        networktypes_ = null;
      }
      return networktypesBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:proto.NetworkTypeResult)
  }

  // @@protoc_insertion_point(class_scope:proto.NetworkTypeResult)
  private static final proto.NetworkTypeResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new proto.NetworkTypeResult();
  }

  public static proto.NetworkTypeResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NetworkTypeResult>
      PARSER = new com.google.protobuf.AbstractParser<NetworkTypeResult>() {
    @java.lang.Override
    public NetworkTypeResult parsePartialFrom(
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

  public static com.google.protobuf.Parser<NetworkTypeResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NetworkTypeResult> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public proto.NetworkTypeResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

