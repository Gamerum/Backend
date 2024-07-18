// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

/**
 * Protobuf type {@code proto.SearchResult}
 */
public final class SearchResult extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:proto.SearchResult)
    SearchResultOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      SearchResult.class.getName());
  }
  // Use SearchResult.newBuilder() to construct.
  private SearchResult(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private SearchResult() {
    searches_ = java.util.Collections.emptyList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return proto.Igdbapi.internal_static_proto_SearchResult_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return proto.Igdbapi.internal_static_proto_SearchResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            proto.SearchResult.class, proto.SearchResult.Builder.class);
  }

  public static final int SEARCHES_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<proto.Search> searches_;
  /**
   * <code>repeated .proto.Search searches = 1;</code>
   */
  @java.lang.Override
  public java.util.List<proto.Search> getSearchesList() {
    return searches_;
  }
  /**
   * <code>repeated .proto.Search searches = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends proto.SearchOrBuilder> 
      getSearchesOrBuilderList() {
    return searches_;
  }
  /**
   * <code>repeated .proto.Search searches = 1;</code>
   */
  @java.lang.Override
  public int getSearchesCount() {
    return searches_.size();
  }
  /**
   * <code>repeated .proto.Search searches = 1;</code>
   */
  @java.lang.Override
  public proto.Search getSearches(int index) {
    return searches_.get(index);
  }
  /**
   * <code>repeated .proto.Search searches = 1;</code>
   */
  @java.lang.Override
  public proto.SearchOrBuilder getSearchesOrBuilder(
      int index) {
    return searches_.get(index);
  }

  public static proto.SearchResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.SearchResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.SearchResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.SearchResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.SearchResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.SearchResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.SearchResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.SearchResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static proto.SearchResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static proto.SearchResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static proto.SearchResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static proto.SearchResult parseFrom(
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
  public static Builder newBuilder(proto.SearchResult prototype) {
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
   * Protobuf type {@code proto.SearchResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.SearchResult)
      proto.SearchResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proto.Igdbapi.internal_static_proto_SearchResult_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proto.Igdbapi.internal_static_proto_SearchResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proto.SearchResult.class, proto.SearchResult.Builder.class);
    }

    // Construct using proto.SearchResult.newBuilder()
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
      if (searchesBuilder_ == null) {
        searches_ = java.util.Collections.emptyList();
      } else {
        searches_ = null;
        searchesBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return proto.Igdbapi.internal_static_proto_SearchResult_descriptor;
    }

    @java.lang.Override
    public proto.SearchResult getDefaultInstanceForType() {
      return proto.SearchResult.getDefaultInstance();
    }

    @java.lang.Override
    public proto.SearchResult build() {
      proto.SearchResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public proto.SearchResult buildPartial() {
      proto.SearchResult result = new proto.SearchResult(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(proto.SearchResult result) {
      if (searchesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          searches_ = java.util.Collections.unmodifiableList(searches_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.searches_ = searches_;
      } else {
        result.searches_ = searchesBuilder_.build();
      }
    }

    private void buildPartial0(proto.SearchResult result) {
      int from_bitField0_ = bitField0_;
    }

    private int bitField0_;

    private java.util.List<proto.Search> searches_ =
      java.util.Collections.emptyList();
    private void ensureSearchesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        searches_ = new java.util.ArrayList<proto.Search>(searches_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        proto.Search, proto.Search.Builder, proto.SearchOrBuilder> searchesBuilder_;

    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public java.util.List<proto.Search> getSearchesList() {
      if (searchesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(searches_);
      } else {
        return searchesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public int getSearchesCount() {
      if (searchesBuilder_ == null) {
        return searches_.size();
      } else {
        return searchesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public proto.Search getSearches(int index) {
      if (searchesBuilder_ == null) {
        return searches_.get(index);
      } else {
        return searchesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public Builder setSearches(
        int index, proto.Search value) {
      if (searchesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSearchesIsMutable();
        searches_.set(index, value);
        onChanged();
      } else {
        searchesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public Builder setSearches(
        int index, proto.Search.Builder builderForValue) {
      if (searchesBuilder_ == null) {
        ensureSearchesIsMutable();
        searches_.set(index, builderForValue.build());
        onChanged();
      } else {
        searchesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public Builder addSearches(proto.Search value) {
      if (searchesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSearchesIsMutable();
        searches_.add(value);
        onChanged();
      } else {
        searchesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public Builder addSearches(
        int index, proto.Search value) {
      if (searchesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSearchesIsMutable();
        searches_.add(index, value);
        onChanged();
      } else {
        searchesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public Builder addSearches(
        proto.Search.Builder builderForValue) {
      if (searchesBuilder_ == null) {
        ensureSearchesIsMutable();
        searches_.add(builderForValue.build());
        onChanged();
      } else {
        searchesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public Builder addSearches(
        int index, proto.Search.Builder builderForValue) {
      if (searchesBuilder_ == null) {
        ensureSearchesIsMutable();
        searches_.add(index, builderForValue.build());
        onChanged();
      } else {
        searchesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public Builder addAllSearches(
        java.lang.Iterable<? extends proto.Search> values) {
      if (searchesBuilder_ == null) {
        ensureSearchesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, searches_);
        onChanged();
      } else {
        searchesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public Builder clearSearches() {
      if (searchesBuilder_ == null) {
        searches_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        searchesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public Builder removeSearches(int index) {
      if (searchesBuilder_ == null) {
        ensureSearchesIsMutable();
        searches_.remove(index);
        onChanged();
      } else {
        searchesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public proto.Search.Builder getSearchesBuilder(
        int index) {
      return getSearchesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public proto.SearchOrBuilder getSearchesOrBuilder(
        int index) {
      if (searchesBuilder_ == null) {
        return searches_.get(index);  } else {
        return searchesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public java.util.List<? extends proto.SearchOrBuilder> 
         getSearchesOrBuilderList() {
      if (searchesBuilder_ != null) {
        return searchesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(searches_);
      }
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public proto.Search.Builder addSearchesBuilder() {
      return getSearchesFieldBuilder().addBuilder(
          proto.Search.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public proto.Search.Builder addSearchesBuilder(
        int index) {
      return getSearchesFieldBuilder().addBuilder(
          index, proto.Search.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.Search searches = 1;</code>
     */
    public java.util.List<proto.Search.Builder> 
         getSearchesBuilderList() {
      return getSearchesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        proto.Search, proto.Search.Builder, proto.SearchOrBuilder> 
        getSearchesFieldBuilder() {
      if (searchesBuilder_ == null) {
        searchesBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            proto.Search, proto.Search.Builder, proto.SearchOrBuilder>(
                searches_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        searches_ = null;
      }
      return searchesBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:proto.SearchResult)
  }

  // @@protoc_insertion_point(class_scope:proto.SearchResult)
  private static final proto.SearchResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new proto.SearchResult();
  }

  public static proto.SearchResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SearchResult>
      PARSER = new com.google.protobuf.AbstractParser<SearchResult>() {
    @java.lang.Override
    public SearchResult parsePartialFrom(
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

  public static com.google.protobuf.Parser<SearchResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SearchResult> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public proto.SearchResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
