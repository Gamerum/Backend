// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

/**
 * Protobuf type {@code proto.PlatformVersionCompany}
 */
public final class PlatformVersionCompany extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:proto.PlatformVersionCompany)
    PlatformVersionCompanyOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      PlatformVersionCompany.class.getName());
  }
  // Use PlatformVersionCompany.newBuilder() to construct.
  private PlatformVersionCompany(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private PlatformVersionCompany() {
    comment_ = "";
    checksum_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return proto.Igdbapi.internal_static_proto_PlatformVersionCompany_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return proto.Igdbapi.internal_static_proto_PlatformVersionCompany_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            proto.PlatformVersionCompany.class, proto.PlatformVersionCompany.Builder.class);
  }

  private int bitField0_;
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

  public static final int COMMENT_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object comment_ = "";
  /**
   * <code>string comment = 2;</code>
   * @return The comment.
   */
  @java.lang.Override
  public java.lang.String getComment() {
    java.lang.Object ref = comment_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      comment_ = s;
      return s;
    }
  }
  /**
   * <code>string comment = 2;</code>
   * @return The bytes for comment.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getCommentBytes() {
    java.lang.Object ref = comment_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      comment_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int COMPANY_FIELD_NUMBER = 3;
  private proto.Company company_;
  /**
   * <code>.proto.Company company = 3;</code>
   * @return Whether the company field is set.
   */
  @java.lang.Override
  public boolean hasCompany() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.proto.Company company = 3;</code>
   * @return The company.
   */
  @java.lang.Override
  public proto.Company getCompany() {
    return company_ == null ? proto.Company.getDefaultInstance() : company_;
  }
  /**
   * <code>.proto.Company company = 3;</code>
   */
  @java.lang.Override
  public proto.CompanyOrBuilder getCompanyOrBuilder() {
    return company_ == null ? proto.Company.getDefaultInstance() : company_;
  }

  public static final int DEVELOPER_FIELD_NUMBER = 4;
  private boolean developer_ = false;
  /**
   * <code>bool developer = 4;</code>
   * @return The developer.
   */
  @java.lang.Override
  public boolean getDeveloper() {
    return developer_;
  }

  public static final int MANUFACTURER_FIELD_NUMBER = 5;
  private boolean manufacturer_ = false;
  /**
   * <code>bool manufacturer = 5;</code>
   * @return The manufacturer.
   */
  @java.lang.Override
  public boolean getManufacturer() {
    return manufacturer_;
  }

  public static final int CHECKSUM_FIELD_NUMBER = 6;
  @SuppressWarnings("serial")
  private volatile java.lang.Object checksum_ = "";
  /**
   * <code>string checksum = 6;</code>
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
   * <code>string checksum = 6;</code>
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

  public static proto.PlatformVersionCompany parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.PlatformVersionCompany parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.PlatformVersionCompany parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.PlatformVersionCompany parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.PlatformVersionCompany parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.PlatformVersionCompany parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.PlatformVersionCompany parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.PlatformVersionCompany parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static proto.PlatformVersionCompany parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static proto.PlatformVersionCompany parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static proto.PlatformVersionCompany parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.PlatformVersionCompany parseFrom(
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
  public static Builder newBuilder(proto.PlatformVersionCompany prototype) {
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
   * Protobuf type {@code proto.PlatformVersionCompany}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.PlatformVersionCompany)
      proto.PlatformVersionCompanyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proto.Igdbapi.internal_static_proto_PlatformVersionCompany_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proto.Igdbapi.internal_static_proto_PlatformVersionCompany_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proto.PlatformVersionCompany.class, proto.PlatformVersionCompany.Builder.class);
    }

    // Construct using proto.PlatformVersionCompany.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage
              .alwaysUseFieldBuilders) {
        getCompanyFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      id_ = 0L;
      comment_ = "";
      company_ = null;
      if (companyBuilder_ != null) {
        companyBuilder_.dispose();
        companyBuilder_ = null;
      }
      developer_ = false;
      manufacturer_ = false;
      checksum_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return proto.Igdbapi.internal_static_proto_PlatformVersionCompany_descriptor;
    }

    @java.lang.Override
    public proto.PlatformVersionCompany getDefaultInstanceForType() {
      return proto.PlatformVersionCompany.getDefaultInstance();
    }

    @java.lang.Override
    public proto.PlatformVersionCompany build() {
      proto.PlatformVersionCompany result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public proto.PlatformVersionCompany buildPartial() {
      proto.PlatformVersionCompany result = new proto.PlatformVersionCompany(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(proto.PlatformVersionCompany result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.id_ = id_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.comment_ = comment_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.company_ = companyBuilder_ == null
            ? company_
            : companyBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.developer_ = developer_;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.manufacturer_ = manufacturer_;
      }
      if (((from_bitField0_ & 0x00000020) != 0)) {
        result.checksum_ = checksum_;
      }
      result.bitField0_ |= to_bitField0_;
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

    private java.lang.Object comment_ = "";
    /**
     * <code>string comment = 2;</code>
     * @return The comment.
     */
    public java.lang.String getComment() {
      java.lang.Object ref = comment_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        comment_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string comment = 2;</code>
     * @return The bytes for comment.
     */
    public com.google.protobuf.ByteString
        getCommentBytes() {
      java.lang.Object ref = comment_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        comment_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string comment = 2;</code>
     * @param value The comment to set.
     * @return This builder for chaining.
     */
    public Builder setComment(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      comment_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string comment = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearComment() {
      comment_ = getDefaultInstance().getComment();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string comment = 2;</code>
     * @param value The bytes for comment to set.
     * @return This builder for chaining.
     */
    public Builder setCommentBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      comment_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private proto.Company company_;
    private com.google.protobuf.SingleFieldBuilder<
        proto.Company, proto.Company.Builder, proto.CompanyOrBuilder> companyBuilder_;
    /**
     * <code>.proto.Company company = 3;</code>
     * @return Whether the company field is set.
     */
    public boolean hasCompany() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>.proto.Company company = 3;</code>
     * @return The company.
     */
    public proto.Company getCompany() {
      if (companyBuilder_ == null) {
        return company_ == null ? proto.Company.getDefaultInstance() : company_;
      } else {
        return companyBuilder_.getMessage();
      }
    }
    /**
     * <code>.proto.Company company = 3;</code>
     */
    public Builder setCompany(proto.Company value) {
      if (companyBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        company_ = value;
      } else {
        companyBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.proto.Company company = 3;</code>
     */
    public Builder setCompany(
        proto.Company.Builder builderForValue) {
      if (companyBuilder_ == null) {
        company_ = builderForValue.build();
      } else {
        companyBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.proto.Company company = 3;</code>
     */
    public Builder mergeCompany(proto.Company value) {
      if (companyBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0) &&
          company_ != null &&
          company_ != proto.Company.getDefaultInstance()) {
          getCompanyBuilder().mergeFrom(value);
        } else {
          company_ = value;
        }
      } else {
        companyBuilder_.mergeFrom(value);
      }
      if (company_ != null) {
        bitField0_ |= 0x00000004;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.proto.Company company = 3;</code>
     */
    public Builder clearCompany() {
      bitField0_ = (bitField0_ & ~0x00000004);
      company_ = null;
      if (companyBuilder_ != null) {
        companyBuilder_.dispose();
        companyBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.proto.Company company = 3;</code>
     */
    public proto.Company.Builder getCompanyBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getCompanyFieldBuilder().getBuilder();
    }
    /**
     * <code>.proto.Company company = 3;</code>
     */
    public proto.CompanyOrBuilder getCompanyOrBuilder() {
      if (companyBuilder_ != null) {
        return companyBuilder_.getMessageOrBuilder();
      } else {
        return company_ == null ?
            proto.Company.getDefaultInstance() : company_;
      }
    }
    /**
     * <code>.proto.Company company = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        proto.Company, proto.Company.Builder, proto.CompanyOrBuilder> 
        getCompanyFieldBuilder() {
      if (companyBuilder_ == null) {
        companyBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            proto.Company, proto.Company.Builder, proto.CompanyOrBuilder>(
                getCompany(),
                getParentForChildren(),
                isClean());
        company_ = null;
      }
      return companyBuilder_;
    }

    private boolean developer_ ;
    /**
     * <code>bool developer = 4;</code>
     * @return The developer.
     */
    @java.lang.Override
    public boolean getDeveloper() {
      return developer_;
    }
    /**
     * <code>bool developer = 4;</code>
     * @param value The developer to set.
     * @return This builder for chaining.
     */
    public Builder setDeveloper(boolean value) {

      developer_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>bool developer = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearDeveloper() {
      bitField0_ = (bitField0_ & ~0x00000008);
      developer_ = false;
      onChanged();
      return this;
    }

    private boolean manufacturer_ ;
    /**
     * <code>bool manufacturer = 5;</code>
     * @return The manufacturer.
     */
    @java.lang.Override
    public boolean getManufacturer() {
      return manufacturer_;
    }
    /**
     * <code>bool manufacturer = 5;</code>
     * @param value The manufacturer to set.
     * @return This builder for chaining.
     */
    public Builder setManufacturer(boolean value) {

      manufacturer_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>bool manufacturer = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearManufacturer() {
      bitField0_ = (bitField0_ & ~0x00000010);
      manufacturer_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object checksum_ = "";
    /**
     * <code>string checksum = 6;</code>
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
     * <code>string checksum = 6;</code>
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
     * <code>string checksum = 6;</code>
     * @param value The checksum to set.
     * @return This builder for chaining.
     */
    public Builder setChecksum(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      checksum_ = value;
      bitField0_ |= 0x00000020;
      onChanged();
      return this;
    }
    /**
     * <code>string checksum = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearChecksum() {
      checksum_ = getDefaultInstance().getChecksum();
      bitField0_ = (bitField0_ & ~0x00000020);
      onChanged();
      return this;
    }
    /**
     * <code>string checksum = 6;</code>
     * @param value The bytes for checksum to set.
     * @return This builder for chaining.
     */
    public Builder setChecksumBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      checksum_ = value;
      bitField0_ |= 0x00000020;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:proto.PlatformVersionCompany)
  }

  // @@protoc_insertion_point(class_scope:proto.PlatformVersionCompany)
  private static final proto.PlatformVersionCompany DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new proto.PlatformVersionCompany();
  }

  public static proto.PlatformVersionCompany getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PlatformVersionCompany>
      PARSER = new com.google.protobuf.AbstractParser<PlatformVersionCompany>() {
    @java.lang.Override
    public PlatformVersionCompany parsePartialFrom(
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

  public static com.google.protobuf.Parser<PlatformVersionCompany> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PlatformVersionCompany> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public proto.PlatformVersionCompany getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

