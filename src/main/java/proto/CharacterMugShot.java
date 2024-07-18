// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

/**
 * Protobuf type {@code proto.CharacterMugShot}
 */
public final class CharacterMugShot extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:proto.CharacterMugShot)
    CharacterMugShotOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      CharacterMugShot.class.getName());
  }
  // Use CharacterMugShot.newBuilder() to construct.
  private CharacterMugShot(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private CharacterMugShot() {
    imageId_ = "";
    url_ = "";
    checksum_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return proto.Igdbapi.internal_static_proto_CharacterMugShot_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return proto.Igdbapi.internal_static_proto_CharacterMugShot_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            proto.CharacterMugShot.class, proto.CharacterMugShot.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private long id_ = 0L;
  /**
   * <code>uint64 id = 1;</code>
   * @return The id.
   */
  @java.lang.Override
  public long getId() {
    return id_;
  }

  public static final int ALPHA_CHANNEL_FIELD_NUMBER = 2;
  private boolean alphaChannel_ = false;
  /**
   * <code>bool alpha_channel = 2;</code>
   * @return The alphaChannel.
   */
  @java.lang.Override
  public boolean getAlphaChannel() {
    return alphaChannel_;
  }

  public static final int ANIMATED_FIELD_NUMBER = 3;
  private boolean animated_ = false;
  /**
   * <code>bool animated = 3;</code>
   * @return The animated.
   */
  @java.lang.Override
  public boolean getAnimated() {
    return animated_;
  }

  public static final int HEIGHT_FIELD_NUMBER = 4;
  private int height_ = 0;
  /**
   * <code>int32 height = 4;</code>
   * @return The height.
   */
  @java.lang.Override
  public int getHeight() {
    return height_;
  }

  public static final int IMAGE_ID_FIELD_NUMBER = 5;
  @SuppressWarnings("serial")
  private volatile java.lang.Object imageId_ = "";
  /**
   * <code>string image_id = 5;</code>
   * @return The imageId.
   */
  @java.lang.Override
  public java.lang.String getImageId() {
    java.lang.Object ref = imageId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      imageId_ = s;
      return s;
    }
  }
  /**
   * <code>string image_id = 5;</code>
   * @return The bytes for imageId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getImageIdBytes() {
    java.lang.Object ref = imageId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      imageId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int URL_FIELD_NUMBER = 6;
  @SuppressWarnings("serial")
  private volatile java.lang.Object url_ = "";
  /**
   * <code>string url = 6;</code>
   * @return The url.
   */
  @java.lang.Override
  public java.lang.String getUrl() {
    java.lang.Object ref = url_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      url_ = s;
      return s;
    }
  }
  /**
   * <code>string url = 6;</code>
   * @return The bytes for url.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getUrlBytes() {
    java.lang.Object ref = url_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      url_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int WIDTH_FIELD_NUMBER = 7;
  private int width_ = 0;
  /**
   * <code>int32 width = 7;</code>
   * @return The width.
   */
  @java.lang.Override
  public int getWidth() {
    return width_;
  }

  public static final int CHECKSUM_FIELD_NUMBER = 8;
  @SuppressWarnings("serial")
  private volatile java.lang.Object checksum_ = "";
  /**
   * <code>string checksum = 8;</code>
   * @return The checksum.
   */
  @java.lang.Override
  public java.lang.String getChecksum() {
    java.lang.Object ref = checksum_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      checksum_ = s;
      return s;
    }
  }
  /**
   * <code>string checksum = 8;</code>
   * @return The bytes for checksum.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getChecksumBytes() {
    java.lang.Object ref = checksum_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      checksum_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static proto.CharacterMugShot parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.CharacterMugShot parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.CharacterMugShot parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.CharacterMugShot parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.CharacterMugShot parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.CharacterMugShot parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.CharacterMugShot parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.CharacterMugShot parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static proto.CharacterMugShot parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static proto.CharacterMugShot parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static proto.CharacterMugShot parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.CharacterMugShot parseFrom(
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
  public static Builder newBuilder(proto.CharacterMugShot prototype) {
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
   * Protobuf type {@code proto.CharacterMugShot}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.CharacterMugShot)
      proto.CharacterMugShotOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proto.Igdbapi.internal_static_proto_CharacterMugShot_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proto.Igdbapi.internal_static_proto_CharacterMugShot_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proto.CharacterMugShot.class, proto.CharacterMugShot.Builder.class);
    }

    // Construct using proto.CharacterMugShot.newBuilder()
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
      id_ = 0L;
      alphaChannel_ = false;
      animated_ = false;
      height_ = 0;
      imageId_ = "";
      url_ = "";
      width_ = 0;
      checksum_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return proto.Igdbapi.internal_static_proto_CharacterMugShot_descriptor;
    }

    @java.lang.Override
    public proto.CharacterMugShot getDefaultInstanceForType() {
      return proto.CharacterMugShot.getDefaultInstance();
    }

    @java.lang.Override
    public proto.CharacterMugShot build() {
      proto.CharacterMugShot result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public proto.CharacterMugShot buildPartial() {
      proto.CharacterMugShot result = new proto.CharacterMugShot(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(proto.CharacterMugShot result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.id_ = id_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.alphaChannel_ = alphaChannel_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.animated_ = animated_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.height_ = height_;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.imageId_ = imageId_;
      }
      if (((from_bitField0_ & 0x00000020) != 0)) {
        result.url_ = url_;
      }
      if (((from_bitField0_ & 0x00000040) != 0)) {
        result.width_ = width_;
      }
      if (((from_bitField0_ & 0x00000080) != 0)) {
        result.checksum_ = checksum_;
      }
    }

    private int bitField0_;

    private long id_ ;
    /**
     * <code>uint64 id = 1;</code>
     * @return The id.
     */
    @java.lang.Override
    public long getId() {
      return id_;
    }
    /**
     * <code>uint64 id = 1;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(long value) {

      id_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      id_ = 0L;
      onChanged();
      return this;
    }

    private boolean alphaChannel_ ;
    /**
     * <code>bool alpha_channel = 2;</code>
     * @return The alphaChannel.
     */
    @java.lang.Override
    public boolean getAlphaChannel() {
      return alphaChannel_;
    }
    /**
     * <code>bool alpha_channel = 2;</code>
     * @param value The alphaChannel to set.
     * @return This builder for chaining.
     */
    public Builder setAlphaChannel(boolean value) {

      alphaChannel_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>bool alpha_channel = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAlphaChannel() {
      bitField0_ = (bitField0_ & ~0x00000002);
      alphaChannel_ = false;
      onChanged();
      return this;
    }

    private boolean animated_ ;
    /**
     * <code>bool animated = 3;</code>
     * @return The animated.
     */
    @java.lang.Override
    public boolean getAnimated() {
      return animated_;
    }
    /**
     * <code>bool animated = 3;</code>
     * @param value The animated to set.
     * @return This builder for chaining.
     */
    public Builder setAnimated(boolean value) {

      animated_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>bool animated = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearAnimated() {
      bitField0_ = (bitField0_ & ~0x00000004);
      animated_ = false;
      onChanged();
      return this;
    }

    private int height_ ;
    /**
     * <code>int32 height = 4;</code>
     * @return The height.
     */
    @java.lang.Override
    public int getHeight() {
      return height_;
    }
    /**
     * <code>int32 height = 4;</code>
     * @param value The height to set.
     * @return This builder for chaining.
     */
    public Builder setHeight(int value) {

      height_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>int32 height = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearHeight() {
      bitField0_ = (bitField0_ & ~0x00000008);
      height_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object imageId_ = "";
    /**
     * <code>string image_id = 5;</code>
     * @return The imageId.
     */
    public java.lang.String getImageId() {
      java.lang.Object ref = imageId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        imageId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string image_id = 5;</code>
     * @return The bytes for imageId.
     */
    public com.google.protobuf.ByteString
        getImageIdBytes() {
      java.lang.Object ref = imageId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        imageId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string image_id = 5;</code>
     * @param value The imageId to set.
     * @return This builder for chaining.
     */
    public Builder setImageId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      imageId_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>string image_id = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearImageId() {
      imageId_ = getDefaultInstance().getImageId();
      bitField0_ = (bitField0_ & ~0x00000010);
      onChanged();
      return this;
    }
    /**
     * <code>string image_id = 5;</code>
     * @param value The bytes for imageId to set.
     * @return This builder for chaining.
     */
    public Builder setImageIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      imageId_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }

    private java.lang.Object url_ = "";
    /**
     * <code>string url = 6;</code>
     * @return The url.
     */
    public java.lang.String getUrl() {
      java.lang.Object ref = url_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        url_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string url = 6;</code>
     * @return The bytes for url.
     */
    public com.google.protobuf.ByteString
        getUrlBytes() {
      java.lang.Object ref = url_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        url_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string url = 6;</code>
     * @param value The url to set.
     * @return This builder for chaining.
     */
    public Builder setUrl(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      url_ = value;
      bitField0_ |= 0x00000020;
      onChanged();
      return this;
    }
    /**
     * <code>string url = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearUrl() {
      url_ = getDefaultInstance().getUrl();
      bitField0_ = (bitField0_ & ~0x00000020);
      onChanged();
      return this;
    }
    /**
     * <code>string url = 6;</code>
     * @param value The bytes for url to set.
     * @return This builder for chaining.
     */
    public Builder setUrlBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      url_ = value;
      bitField0_ |= 0x00000020;
      onChanged();
      return this;
    }

    private int width_ ;
    /**
     * <code>int32 width = 7;</code>
     * @return The width.
     */
    @java.lang.Override
    public int getWidth() {
      return width_;
    }
    /**
     * <code>int32 width = 7;</code>
     * @param value The width to set.
     * @return This builder for chaining.
     */
    public Builder setWidth(int value) {

      width_ = value;
      bitField0_ |= 0x00000040;
      onChanged();
      return this;
    }
    /**
     * <code>int32 width = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearWidth() {
      bitField0_ = (bitField0_ & ~0x00000040);
      width_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object checksum_ = "";
    /**
     * <code>string checksum = 8;</code>
     * @return The checksum.
     */
    public java.lang.String getChecksum() {
      java.lang.Object ref = checksum_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        checksum_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string checksum = 8;</code>
     * @return The bytes for checksum.
     */
    public com.google.protobuf.ByteString
        getChecksumBytes() {
      java.lang.Object ref = checksum_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        checksum_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string checksum = 8;</code>
     * @param value The checksum to set.
     * @return This builder for chaining.
     */
    public Builder setChecksum(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      checksum_ = value;
      bitField0_ |= 0x00000080;
      onChanged();
      return this;
    }
    /**
     * <code>string checksum = 8;</code>
     * @return This builder for chaining.
     */
    public Builder clearChecksum() {
      checksum_ = getDefaultInstance().getChecksum();
      bitField0_ = (bitField0_ & ~0x00000080);
      onChanged();
      return this;
    }
    /**
     * <code>string checksum = 8;</code>
     * @param value The bytes for checksum to set.
     * @return This builder for chaining.
     */
    public Builder setChecksumBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      checksum_ = value;
      bitField0_ |= 0x00000080;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:proto.CharacterMugShot)
  }

  // @@protoc_insertion_point(class_scope:proto.CharacterMugShot)
  private static final proto.CharacterMugShot DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new proto.CharacterMugShot();
  }

  public static proto.CharacterMugShot getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CharacterMugShot>
      PARSER = new com.google.protobuf.AbstractParser<CharacterMugShot>() {
    @java.lang.Override
    public CharacterMugShot parsePartialFrom(
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

  public static com.google.protobuf.Parser<CharacterMugShot> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CharacterMugShot> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public proto.CharacterMugShot getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

