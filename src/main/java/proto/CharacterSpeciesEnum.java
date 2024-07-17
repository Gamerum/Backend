// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: igdbapi.proto
// Protobuf Java Version: 4.27.2

package proto;

/**
 * Protobuf enum {@code proto.CharacterSpeciesEnum}
 */
public enum CharacterSpeciesEnum
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>CHARACTER_SPECIES_NULL = 0;</code>
   */
  CHARACTER_SPECIES_NULL(0),
  /**
   * <code>HUMAN = 1;</code>
   */
  HUMAN(1),
  /**
   * <code>ALIEN = 2;</code>
   */
  ALIEN(2),
  /**
   * <code>ANIMAL = 3;</code>
   */
  ANIMAL(3),
  /**
   * <code>ANDROID = 4;</code>
   */
  ANDROID(4),
  /**
   * <code>UNKNOWN = 5;</code>
   */
  UNKNOWN(5),
  UNRECOGNIZED(-1),
  ;

  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      CharacterSpeciesEnum.class.getName());
  }
  /**
   * <code>CHARACTER_SPECIES_NULL = 0;</code>
   */
  public static final int CHARACTER_SPECIES_NULL_VALUE = 0;
  /**
   * <code>HUMAN = 1;</code>
   */
  public static final int HUMAN_VALUE = 1;
  /**
   * <code>ALIEN = 2;</code>
   */
  public static final int ALIEN_VALUE = 2;
  /**
   * <code>ANIMAL = 3;</code>
   */
  public static final int ANIMAL_VALUE = 3;
  /**
   * <code>ANDROID = 4;</code>
   */
  public static final int ANDROID_VALUE = 4;
  /**
   * <code>UNKNOWN = 5;</code>
   */
  public static final int UNKNOWN_VALUE = 5;


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
  public static CharacterSpeciesEnum valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static CharacterSpeciesEnum forNumber(int value) {
    switch (value) {
      case 0: return CHARACTER_SPECIES_NULL;
      case 1: return HUMAN;
      case 2: return ALIEN;
      case 3: return ANIMAL;
      case 4: return ANDROID;
      case 5: return UNKNOWN;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<CharacterSpeciesEnum>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      CharacterSpeciesEnum> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<CharacterSpeciesEnum>() {
          public CharacterSpeciesEnum findValueByNumber(int number) {
            return CharacterSpeciesEnum.forNumber(number);
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
    return proto.Igdbapi.getDescriptor().getEnumTypes().get(4);
  }

  private static final CharacterSpeciesEnum[] VALUES = values();

  public static CharacterSpeciesEnum valueOf(
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

  private CharacterSpeciesEnum(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:proto.CharacterSpeciesEnum)
}

