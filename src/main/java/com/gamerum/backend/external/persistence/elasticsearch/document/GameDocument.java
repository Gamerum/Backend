package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;
import java.util.stream.Collectors;

@Document(indexName = "game")
@Data
@AllArgsConstructor
public class GameDocument {
    public enum Genre {
        POINT_AND_CLICK("Point & Click",2),
        FIGHTING("Fighting",4),
        SHOOTER("Shooter",5),
        MUSIC("Music",7),
        PLATFORM("Platform",8),
        PUZZLE("Puzzle",9),
        RACING("Racing",10),
        RTS("Real Time Strategy (RTS)",11),
        RPG("Role-playing (RPG)",12),
        SIMULATOR("Simulator",13),
        SPORT("Sport",14),
        STRATEGY("Strategy",15),
        TBS("Turn-based strategy (TBS)",16),
        TACTICAL("Tactical",24),
        HACK_AND_SLASH("Hack & Slash",25),
        QUIZ_TRIVIA("Quiz/Trivia",26),
        PINBALL("Pinball",30),
        ADVENTURE("Adventure",31),
        INDIE("Indie",32),
        ARCADE("Arcade",33),
        VISUAL_NOVEL("Visual Novel",34),
        CARD_BROAD_GAME("Card & Broad Game",35),
        MOBA("MOBA",36);

        private final String defaultName;
        private final long value;

        Genre(String defaultName, long value) {
            this.defaultName = defaultName;
            this.value = value;
        }

        @Override
        public String toString() {
            return defaultName;
        }

        public static Genre getByValue(long value) {
            for (Genre genre : Genre.values()) {
                if (genre.value == value) {
                    return genre;
                }
            }
            throw new IllegalArgumentException("No enum constant with number " + value);
        }
    }

    @Id
    private String id;
    private String name;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Integer> genreIds;

    // Factory method for JSON deserialization
    @JsonCreator
    public static GameDocument fromJson(@JsonProperty("id") String id,
                                        @JsonProperty("name") String name,
                                        @JsonProperty("genres") List<GenreEntity> genreEntities) {
        List<Integer> genreIds = genreEntities == null ? null : genreEntities.stream()
                .map(GenreEntity::getId)
                .collect(Collectors.toList());
        return new GameDocument(id, name, genreIds);
    }

    @Data
    public static class GenreEntity {
        private int id;
    }
}
