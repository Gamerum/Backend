// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

/**
 * Protobuf type {@code proto.AlternativeNameResult}
 */
public final class AlternativeNameResult extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:proto.AlternativeNameResult)
    AlternativeNameResultOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      AlternativeNameResult.class.getName());
  }
  // Use AlternativeNameResult.newBuilder() to construct.
  private AlternativeNameResult(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private AlternativeNameResult() {
    alternativenames_ = java.util.Collections.emptyList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return proto.Igdbapi.internal_static_proto_AlternativeNameResult_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return proto.Igdbapi.internal_static_proto_AlternativeNameResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            proto.AlternativeNameResult.class, proto.AlternativeNameResult.Builder.class);
  }

  public static final int ALTERNATIVENAMES_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<proto.AlternativeName> alternativenames_;
  /**
   * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
   */
  @java.lang.Override
  public java.util.List<proto.AlternativeName> getAlternativenamesList() {
    return alternativenames_;
  }
  /**
   * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends proto.AlternativeNameOrBuilder> 
      getAlternativenamesOrBuilderList() {
    return alternativenames_;
  }
  /**
   * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
   */
  @java.lang.Override
  public int getAlternativenamesCount() {
    return alternativenames_.size();
  }
  /**
   * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
   */
  @java.lang.Override
  public proto.AlternativeName getAlternativenames(int index) {
    return alternativenames_.get(index);
  }
  /**
   * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
   */
  @java.lang.Override
  public proto.AlternativeNameOrBuilder getAlternativenamesOrBuilder(
      int index) {
    return alternativenames_.get(index);
  }

  public static proto.AlternativeNameResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.AlternativeNameResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.AlternativeNameResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.AlternativeNameResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.AlternativeNameResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.AlternativeNameResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.AlternativeNameResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.AlternativeNameResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static proto.AlternativeNameResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static proto.AlternativeNameResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static proto.AlternativeNameResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.AlternativeNameResult parseFrom(
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
  public static Builder newBuilder(proto.AlternativeNameResult prototype) {
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
   * Protobuf type {@code proto.AlternativeNameResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.AlternativeNameResult)
      proto.AlternativeNameResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proto.Igdbapi.internal_static_proto_AlternativeNameResult_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proto.Igdbapi.internal_static_proto_AlternativeNameResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proto.AlternativeNameResult.class, proto.AlternativeNameResult.Builder.class);
    }

    // Construct using proto.AlternativeNameResult.newBuilder()
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
      if (alternativenamesBuilder_ == null) {
        alternativenames_ = java.util.Collections.emptyList();
      } else {
        alternativenames_ = null;
        alternativenamesBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return proto.Igdbapi.internal_static_proto_AlternativeNameResult_descriptor;
    }

    @java.lang.Override
    public proto.AlternativeNameResult getDefaultInstanceForType() {
      return proto.AlternativeNameResult.getDefaultInstance();
    }

    @java.lang.Override
    public proto.AlternativeNameResult build() {
      proto.AlternativeNameResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public proto.AlternativeNameResult buildPartial() {
      proto.AlternativeNameResult result = new proto.AlternativeNameResult(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(proto.AlternativeNameResult result) {
      if (alternativenamesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          alternativenames_ = java.util.Collections.unmodifiableList(alternativenames_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.alternativenames_ = alternativenames_;
      } else {
        result.alternativenames_ = alternativenamesBuilder_.build();
      }
    }

    private void buildPartial0(proto.AlternativeNameResult result) {
      int from_bitField0_ = bitField0_;
    }

    private int bitField0_;

    private java.util.List<proto.AlternativeName> alternativenames_ =
      java.util.Collections.emptyList();
    private void ensureAlternativenamesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        alternativenames_ = new java.util.ArrayList<proto.AlternativeName>(alternativenames_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        proto.AlternativeName, proto.AlternativeName.Builder, proto.AlternativeNameOrBuilder> alternativenamesBuilder_;

    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public java.util.List<proto.AlternativeName> getAlternativenamesList() {
      if (alternativenamesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(alternativenames_);
      } else {
        return alternativenamesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public int getAlternativenamesCount() {
      if (alternativenamesBuilder_ == null) {
        return alternativenames_.size();
      } else {
        return alternativenamesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public proto.AlternativeName getAlternativenames(int index) {
      if (alternativenamesBuilder_ == null) {
        return alternativenames_.get(index);
      } else {
        return alternativenamesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public Builder setAlternativenames(
        int index, proto.AlternativeName value) {
      if (alternativenamesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAlternativenamesIsMutable();
        alternativenames_.set(index, value);
        onChanged();
      } else {
        alternativenamesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public Builder setAlternativenames(
        int index, proto.AlternativeName.Builder builderForValue) {
      if (alternativenamesBuilder_ == null) {
        ensureAlternativenamesIsMutable();
        alternativenames_.set(index, builderForValue.build());
        onChanged();
      } else {
        alternativenamesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public Builder addAlternativenames(proto.AlternativeName value) {
      if (alternativenamesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAlternativenamesIsMutable();
        alternativenames_.add(value);
        onChanged();
      } else {
        alternativenamesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public Builder addAlternativenames(
        int index, proto.AlternativeName value) {
      if (alternativenamesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAlternativenamesIsMutable();
        alternativenames_.add(index, value);
        onChanged();
      } else {
        alternativenamesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public Builder addAlternativenames(
        proto.AlternativeName.Builder builderForValue) {
      if (alternativenamesBuilder_ == null) {
        ensureAlternativenamesIsMutable();
        alternativenames_.add(builderForValue.build());
        onChanged();
      } else {
        alternativenamesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public Builder addAlternativenames(
        int index, proto.AlternativeName.Builder builderForValue) {
      if (alternativenamesBuilder_ == null) {
        ensureAlternativenamesIsMutable();
        alternativenames_.add(index, builderForValue.build());
        onChanged();
      } else {
        alternativenamesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public Builder addAllAlternativenames(
        java.lang.Iterable<? extends proto.AlternativeName> values) {
      if (alternativenamesBuilder_ == null) {
        ensureAlternativenamesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, alternativenames_);
        onChanged();
      } else {
        alternativenamesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public Builder clearAlternativenames() {
      if (alternativenamesBuilder_ == null) {
        alternativenames_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        alternativenamesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public Builder removeAlternativenames(int index) {
      if (alternativenamesBuilder_ == null) {
        ensureAlternativenamesIsMutable();
        alternativenames_.remove(index);
        onChanged();
      } else {
        alternativenamesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public proto.AlternativeName.Builder getAlternativenamesBuilder(
        int index) {
      return getAlternativenamesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public proto.AlternativeNameOrBuilder getAlternativenamesOrBuilder(
        int index) {
      if (alternativenamesBuilder_ == null) {
        return alternativenames_.get(index);  } else {
        return alternativenamesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public java.util.List<? extends proto.AlternativeNameOrBuilder> 
         getAlternativenamesOrBuilderList() {
      if (alternativenamesBuilder_ != null) {
        return alternativenamesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(alternativenames_);
      }
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public proto.AlternativeName.Builder addAlternativenamesBuilder() {
      return getAlternativenamesFieldBuilder().addBuilder(
          proto.AlternativeName.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public proto.AlternativeName.Builder addAlternativenamesBuilder(
        int index) {
      return getAlternativenamesFieldBuilder().addBuilder(
          index, proto.AlternativeName.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.AlternativeName alternativenames = 1;</code>
     */
    public java.util.List<proto.AlternativeName.Builder> 
         getAlternativenamesBuilderList() {
      return getAlternativenamesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        proto.AlternativeName, proto.AlternativeName.Builder, proto.AlternativeNameOrBuilder> 
        getAlternativenamesFieldBuilder() {
      if (alternativenamesBuilder_ == null) {
        alternativenamesBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            proto.AlternativeName, proto.AlternativeName.Builder, proto.AlternativeNameOrBuilder>(
                alternativenames_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        alternativenames_ = null;
      }
      return alternativenamesBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:proto.AlternativeNameResult)
  }

  // @@protoc_insertion_point(class_scope:proto.AlternativeNameResult)
  private static final proto.AlternativeNameResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new proto.AlternativeNameResult();
  }

  public static proto.AlternativeNameResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AlternativeNameResult>
      PARSER = new com.google.protobuf.AbstractParser<AlternativeNameResult>() {
    @java.lang.Override
    public AlternativeNameResult parsePartialFrom(
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

  public static com.google.protobuf.Parser<AlternativeNameResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AlternativeNameResult> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public proto.AlternativeNameResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
