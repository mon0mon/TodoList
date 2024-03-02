CREATE TABLE item
(
    id               BIGINT PRIMARY KEY,
    item_idx         SMALLINT      NOT NULL,
    alarm_id         BIGINT,
    list_id          BIGINT        NOT NULL,
    content          VARCHAR(1200) NOT NULL,
    active           BOOLEAN       NOT NULL,
    child            BIGINT,
    created_by       BIGINT        NOT NULL,
    last_modified_by BIGINT        NOT NULL,
    created_at       DATETIME      NOT NULL,
    last_modified_at DATETIME      NOT NULL,
    FOREIGN KEY (alarm_id) REFERENCES alarm (id)
);


CREATE TABLE member
(
    id           BIGINT PRIMARY KEY,
    email        VARCHAR(255) NOT NULL,
    mobile       VARCHAR(15),
    name         VARCHAR(20),
    profile_pic  VARCHAR(500),
    oauth_active TINYINT      NOT NULL
);


CREATE TABLE list
(
    id                   BIGINT PRIMARY KEY,
    note                 VARCHAR(255) NOT NULL,
    list_participants_id BIGINT       NOT NULL,
    created_by           BIGINT       NOT NULL,
    last_modified_by     BIGINT       NOT NULL,
    created_at           DATETIME     NOT NULL,
    last_modified_at     DATETIME     NOT NULL
);

CREATE TABLE list_participants
(
    id      BIGINT PRIMARY KEY,
    list_id BIGINT NOT NULL,
    FOREIGN KEY (list_id) REFERENCES list (id)
);

CREATE TABLE list_participants_users
(
    list_participants_id BIGINT NOT NULL,
    users_id             BIGINT NOT NULL,
    FOREIGN KEY (list_participants_id) REFERENCES list (id),
    FOREIGN KEY (users_id) REFERENCES member (id)
);

CREATE TABLE alarm
(
    id      BIGINT PRIMARY KEY,
    item_id BIGINT NOT NULL,
    FOREIGN KEY (item_id) REFERENCES item (id)
)