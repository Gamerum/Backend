CREATE TABLE Users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    is_active BOOLEAN NOT NULL,
    role VARCHAR(255) NOT NULL,
    profile_id BIGINT NOT NULL,
    version BIGINT,
    created_by BIGINT,
    created_date TIMESTAMP,
    last_modified_by BIGINT,
    last_modified_date TIMESTAMP
);

CREATE TABLE Profiles (
    id BIGSERIAL PRIMARY KEY,
    nickname VARCHAR(255),
    is_active BOOLEAN NOT NULL,
    user_id BIGINT NOT NULL UNIQUE,
    version BIGINT,
    created_by BIGINT,
    created_date TIMESTAMP,
    last_modified_by BIGINT,
    last_modified_date TIMESTAMP,
    UNIQUE (nickname),
    FOREIGN KEY (user_id) REFERENCES Users(id)
);

CREATE TABLE Communities (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL UNIQUE,
    description TEXT NOT NULL,
    tags TEXT NOT NULL,
    rules TEXT NOT NULL,
    game_id VARCHAR(255) NOT NULL,
    version BIGINT,
    created_by BIGINT,
    created_date TIMESTAMP,
    last_modified_by BIGINT,
    last_modified_date TIMESTAMP
);

CREATE TABLE CommunityMembers (
    id BIGSERIAL PRIMARY KEY,
    role VARCHAR(255) NOT NULL,
    profile_id BIGINT NOT NULL,
    community_id BIGINT NOT NULL,
    version BIGINT,
    created_by BIGINT,
    created_date TIMESTAMP,
    last_modified_by BIGINT,
    last_modified_date TIMESTAMP,
    FOREIGN KEY (profile_id) REFERENCES Profiles(id),
    FOREIGN KEY (community_id) REFERENCES Communities(id)
);

CREATE TABLE Posts (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    tag VARCHAR(255) NOT NULL,
    text TEXT,
    community_id BIGINT NOT NULL,
    profile_id BIGINT NOT NULL,
    version BIGINT,
    created_by BIGINT,
    created_date TIMESTAMP,
    last_modified_by BIGINT,
    last_modified_date TIMESTAMP,
    FOREIGN KEY (community_id) REFERENCES Communities(id),
    FOREIGN KEY (profile_id) REFERENCES Profiles(id)
);

CREATE TABLE Comments (
    id BIGSERIAL PRIMARY KEY,
    text TEXT NOT NULL,
    post_id BIGINT NOT NULL,
    profile_id BIGINT NOT NULL,
    version BIGINT,
    created_by BIGINT,
    created_date TIMESTAMP,
    last_modified_by BIGINT,
    last_modified_date TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES Posts(id),
    FOREIGN KEY (profile_id) REFERENCES Profiles(id)
);

CREATE TABLE Replies (
    id BIGSERIAL PRIMARY KEY,
    text TEXT NOT NULL,
    respond_comment_id BIGINT NOT NULL,
    profile_id BIGINT NOT NULL,
    version BIGINT,
    created_by BIGINT,
    created_date TIMESTAMP,
    last_modified_by BIGINT,
    last_modified_date TIMESTAMP,
    FOREIGN KEY (respond_comment_id) REFERENCES Comments(id),
    FOREIGN KEY (profile_id) REFERENCES Profiles(id)
);

CREATE TABLE Notifications (
    id BIGSERIAL PRIMARY KEY,
    notified_profile_id BIGINT NOT NULL,
    type VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    version BIGINT,
    created_by BIGINT,
    created_date TIMESTAMP,
    last_modified_by BIGINT,
    last_modified_date TIMESTAMP,
    FOREIGN KEY (notified_profile_id) REFERENCES Profiles(id)
);

CREATE TABLE Chats (
    id BIGSERIAL PRIMARY KEY,
    version BIGINT,
    created_by BIGINT,
    created_date TIMESTAMP,
    last_modified_by BIGINT,
    last_modified_date TIMESTAMP
);

CREATE TABLE ChatParticipants (
    id BIGSERIAL PRIMARY KEY,
    profile_id BIGINT NOT NULL,
    chat_id BIGINT NOT NULL,
    is_mod BOOLEAN NOT NULL,
    version BIGINT,
    created_by BIGINT,
    created_date TIMESTAMP,
    last_modified_by BIGINT,
    last_modified_date TIMESTAMP,
    FOREIGN KEY (profile_id) REFERENCES Profiles(id),
    FOREIGN KEY (chat_id) REFERENCES Chats(id)
);

CREATE TABLE Messages (
    id BIGSERIAL PRIMARY KEY,
    text TEXT NOT NULL,
    is_sent BOOLEAN NOT NULL,
    type VARCHAR(255) NOT NULL,
    chat_id BIGINT NOT NULL,
    profile_id BIGINT NOT NULL,
    version BIGINT,
    created_by BIGINT,
    created_date TIMESTAMP,
    last_modified_by BIGINT,
    last_modified_date TIMESTAMP,
    FOREIGN KEY (chat_id) REFERENCES Chats(id),
    FOREIGN KEY (profile_id) REFERENCES Profiles(id)
);
