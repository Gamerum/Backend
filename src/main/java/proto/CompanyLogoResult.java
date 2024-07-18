// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

/**
 * Protobuf type {@code proto.CompanyLogoResult}
 */
public final class CompanyLogoResult extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:proto.CompanyLogoResult)
    CompanyLogoResultOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      CompanyLogoResult.class.getName());
  }
  // Use CompanyLogoResult.newBuilder() to construct.
  private CompanyLogoResult(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private CompanyLogoResult() {
    companylogos_ = java.util.Collections.emptyList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return proto.Igdbapi.internal_static_proto_CompanyLogoResult_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return proto.Igdbapi.internal_static_proto_CompanyLogoResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            proto.CompanyLogoResult.class, proto.CompanyLogoResult.Builder.class);
  }

  public static final int COMPANYLOGOS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<proto.CompanyLogo> companylogos_;
  /**
   * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
   */
  @java.lang.Override
  public java.util.List<proto.CompanyLogo> getCompanylogosList() {
    return companylogos_;
  }
  /**
   * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends proto.CompanyLogoOrBuilder> 
      getCompanylogosOrBuilderList() {
    return companylogos_;
  }
  /**
   * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
   */
  @java.lang.Override
  public int getCompanylogosCount() {
    return companylogos_.size();
  }
  /**
   * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
   */
  @java.lang.Override
  public proto.CompanyLogo getCompanylogos(int index) {
    return companylogos_.get(index);
  }
  /**
   * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
   */
  @java.lang.Override
  public proto.CompanyLogoOrBuilder getCompanylogosOrBuilder(
      int index) {
    return companylogos_.get(index);
  }

  public static proto.CompanyLogoResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.CompanyLogoResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.CompanyLogoResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.CompanyLogoResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.CompanyLogoResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.CompanyLogoResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.CompanyLogoResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.CompanyLogoResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static proto.CompanyLogoResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static proto.CompanyLogoResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static proto.CompanyLogoResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.CompanyLogoResult parseFrom(
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
  public static Builder newBuilder(proto.CompanyLogoResult prototype) {
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
   * Protobuf type {@code proto.CompanyLogoResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.CompanyLogoResult)
      proto.CompanyLogoResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proto.Igdbapi.internal_static_proto_CompanyLogoResult_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proto.Igdbapi.internal_static_proto_CompanyLogoResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proto.CompanyLogoResult.class, proto.CompanyLogoResult.Builder.class);
    }

    // Construct using proto.CompanyLogoResult.newBuilder()
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
      if (companylogosBuilder_ == null) {
        companylogos_ = java.util.Collections.emptyList();
      } else {
        companylogos_ = null;
        companylogosBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return proto.Igdbapi.internal_static_proto_CompanyLogoResult_descriptor;
    }

    @java.lang.Override
    public proto.CompanyLogoResult getDefaultInstanceForType() {
      return proto.CompanyLogoResult.getDefaultInstance();
    }

    @java.lang.Override
    public proto.CompanyLogoResult build() {
      proto.CompanyLogoResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public proto.CompanyLogoResult buildPartial() {
      proto.CompanyLogoResult result = new proto.CompanyLogoResult(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(proto.CompanyLogoResult result) {
      if (companylogosBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          companylogos_ = java.util.Collections.unmodifiableList(companylogos_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.companylogos_ = companylogos_;
      } else {
        result.companylogos_ = companylogosBuilder_.build();
      }
    }

    private void buildPartial0(proto.CompanyLogoResult result) {
      int from_bitField0_ = bitField0_;
    }

    private int bitField0_;

    private java.util.List<proto.CompanyLogo> companylogos_ =
      java.util.Collections.emptyList();
    private void ensureCompanylogosIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        companylogos_ = new java.util.ArrayList<proto.CompanyLogo>(companylogos_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        proto.CompanyLogo, proto.CompanyLogo.Builder, proto.CompanyLogoOrBuilder> companylogosBuilder_;

    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public java.util.List<proto.CompanyLogo> getCompanylogosList() {
      if (companylogosBuilder_ == null) {
        return java.util.Collections.unmodifiableList(companylogos_);
      } else {
        return companylogosBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public int getCompanylogosCount() {
      if (companylogosBuilder_ == null) {
        return companylogos_.size();
      } else {
        return companylogosBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public proto.CompanyLogo getCompanylogos(int index) {
      if (companylogosBuilder_ == null) {
        return companylogos_.get(index);
      } else {
        return companylogosBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public Builder setCompanylogos(
        int index, proto.CompanyLogo value) {
      if (companylogosBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCompanylogosIsMutable();
        companylogos_.set(index, value);
        onChanged();
      } else {
        companylogosBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public Builder setCompanylogos(
        int index, proto.CompanyLogo.Builder builderForValue) {
      if (companylogosBuilder_ == null) {
        ensureCompanylogosIsMutable();
        companylogos_.set(index, builderForValue.build());
        onChanged();
      } else {
        companylogosBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public Builder addCompanylogos(proto.CompanyLogo value) {
      if (companylogosBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCompanylogosIsMutable();
        companylogos_.add(value);
        onChanged();
      } else {
        companylogosBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public Builder addCompanylogos(
        int index, proto.CompanyLogo value) {
      if (companylogosBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCompanylogosIsMutable();
        companylogos_.add(index, value);
        onChanged();
      } else {
        companylogosBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public Builder addCompanylogos(
        proto.CompanyLogo.Builder builderForValue) {
      if (companylogosBuilder_ == null) {
        ensureCompanylogosIsMutable();
        companylogos_.add(builderForValue.build());
        onChanged();
      } else {
        companylogosBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public Builder addCompanylogos(
        int index, proto.CompanyLogo.Builder builderForValue) {
      if (companylogosBuilder_ == null) {
        ensureCompanylogosIsMutable();
        companylogos_.add(index, builderForValue.build());
        onChanged();
      } else {
        companylogosBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public Builder addAllCompanylogos(
        java.lang.Iterable<? extends proto.CompanyLogo> values) {
      if (companylogosBuilder_ == null) {
        ensureCompanylogosIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, companylogos_);
        onChanged();
      } else {
        companylogosBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public Builder clearCompanylogos() {
      if (companylogosBuilder_ == null) {
        companylogos_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        companylogosBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public Builder removeCompanylogos(int index) {
      if (companylogosBuilder_ == null) {
        ensureCompanylogosIsMutable();
        companylogos_.remove(index);
        onChanged();
      } else {
        companylogosBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public proto.CompanyLogo.Builder getCompanylogosBuilder(
        int index) {
      return getCompanylogosFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public proto.CompanyLogoOrBuilder getCompanylogosOrBuilder(
        int index) {
      if (companylogosBuilder_ == null) {
        return companylogos_.get(index);  } else {
        return companylogosBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public java.util.List<? extends proto.CompanyLogoOrBuilder> 
         getCompanylogosOrBuilderList() {
      if (companylogosBuilder_ != null) {
        return companylogosBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(companylogos_);
      }
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public proto.CompanyLogo.Builder addCompanylogosBuilder() {
      return getCompanylogosFieldBuilder().addBuilder(
          proto.CompanyLogo.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public proto.CompanyLogo.Builder addCompanylogosBuilder(
        int index) {
      return getCompanylogosFieldBuilder().addBuilder(
          index, proto.CompanyLogo.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.CompanyLogo companylogos = 1;</code>
     */
    public java.util.List<proto.CompanyLogo.Builder> 
         getCompanylogosBuilderList() {
      return getCompanylogosFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        proto.CompanyLogo, proto.CompanyLogo.Builder, proto.CompanyLogoOrBuilder> 
        getCompanylogosFieldBuilder() {
      if (companylogosBuilder_ == null) {
        companylogosBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            proto.CompanyLogo, proto.CompanyLogo.Builder, proto.CompanyLogoOrBuilder>(
                companylogos_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        companylogos_ = null;
      }
      return companylogosBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:proto.CompanyLogoResult)
  }

  // @@protoc_insertion_point(class_scope:proto.CompanyLogoResult)
  private static final proto.CompanyLogoResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new proto.CompanyLogoResult();
  }

  public static proto.CompanyLogoResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CompanyLogoResult>
      PARSER = new com.google.protobuf.AbstractParser<CompanyLogoResult>() {
    @java.lang.Override
    public CompanyLogoResult parsePartialFrom(
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

  public static com.google.protobuf.Parser<CompanyLogoResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CompanyLogoResult> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public proto.CompanyLogoResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
