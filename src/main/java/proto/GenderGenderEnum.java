// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

/**
 * Protobuf enum {@code proto.GenderGenderEnum}
 */
public enum GenderGenderEnum
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>MALE = 0;</code>
   */
  MALE(0),
  /**
   * <code>FEMALE = 1;</code>
   */
  FEMALE(1),
  /**
   * <code>OTHER = 2;</code>
   */
  OTHER(2),
  UNRECOGNIZED(-1),
  ;

  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      GenderGenderEnum.class.getName());
  }
  /**
   * <code>MALE = 0;</code>
   */
  public static final int MALE_VALUE = 0;
  /**
   * <code>FEMALE = 1;</code>
   */
  public static final int FEMALE_VALUE = 1;
  /**
   * <code>OTHER = 2;</code>
   */
  public static final int OTHER_VALUE = 2;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static GenderGenderEnum valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static GenderGenderEnum forNumber(int value) {
    switch (value) {
      case 0: return MALE;
      case 1: return FEMALE;
      case 2: return OTHER;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<GenderGenderEnum>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      GenderGenderEnum> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<GenderGenderEnum>() {
          public GenderGenderEnum findValueByNumber(int number) {
            return GenderGenderEnum.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return proto.Igdbapi.getDescriptor().getEnumTypes().get(3);
  }

  private static final GenderGenderEnum[] VALUES = values();

  public static GenderGenderEnum valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private GenderGenderEnum(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:proto.GenderGenderEnum)
}
