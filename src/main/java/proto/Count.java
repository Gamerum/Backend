// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

/**
 * Protobuf type {@code proto.Count}
 */
public final class Count extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:proto.Count)
    CountOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      Count.class.getName());
  }
  // Use Count.newBuilder() to construct.
  private Count(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private Count() {
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return proto.Igdbapi.internal_static_proto_Count_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return proto.Igdbapi.internal_static_proto_Count_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            proto.Count.class, proto.Count.Builder.class);
  }

  public static final int COUNT_FIELD_NUMBER = 1;
  private long count_ = 0L;
  /**
   * <code>int64 count = 1;</code>
   * @return The count.
   */
  @java.lang.Override
  public long getCount() {
    return count_;
  }

  public static proto.Count parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.Count parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.Count parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.Count parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.Count parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.Count parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.Count parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.Count parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static proto.Count parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static proto.Count parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static proto.Count parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.Count parseFrom(
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
  public static Builder newBuilder(proto.Count prototype) {
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
   * Protobuf type {@code proto.Count}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.Count)
      proto.CountOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proto.Igdbapi.internal_static_proto_Count_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proto.Igdbapi.internal_static_proto_Count_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proto.Count.class, proto.Count.Builder.class);
    }

    // Construct using proto.Count.newBuilder()
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
      count_ = 0L;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return proto.Igdbapi.internal_static_proto_Count_descriptor;
    }

    @java.lang.Override
    public proto.Count getDefaultInstanceForType() {
      return proto.Count.getDefaultInstance();
    }

    @java.lang.Override
    public proto.Count build() {
      proto.Count result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public proto.Count buildPartial() {
      proto.Count result = new proto.Count(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(proto.Count result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.count_ = count_;
      }
    }

    private int bitField0_;

    private long count_ ;
    /**
     * <code>int64 count = 1;</code>
     * @return The count.
     */
    @java.lang.Override
    public long getCount() {
      return count_;
    }
    /**
     * <code>int64 count = 1;</code>
     * @param value The count to set.
     * @return This builder for chaining.
     */
    public Builder setCount(long value) {

      count_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int64 count = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCount() {
      bitField0_ = (bitField0_ & ~0x00000001);
      count_ = 0L;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:proto.Count)
  }

  // @@protoc_insertion_point(class_scope:proto.Count)
  private static final proto.Count DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new proto.Count();
  }

  public static proto.Count getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Count>
      PARSER = new com.google.protobuf.AbstractParser<Count>() {
    @java.lang.Override
    public Count parsePartialFrom(
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

  public static com.google.protobuf.Parser<Count> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Count> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public proto.Count getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
