CREATE TABLE alarm
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    item_id BIGINT                NULL,
    CONSTRAINT pk_alarm PRIMARY KEY (id)
);

CREATE TABLE item
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       DATETIME              NULL,
    last_modified_at DATETIME              NULL,
    item_idx         SMALLINT              NOT NULL,
    list_id          BIGINT                NULL,
    content          VARCHAR(1200)         NOT NULL,
    active           BIT(1)                NOT NULL,
    created_by       BLOB                  NULL,
    last_modified_by BLOB                  NULL,
    child            BIGINT                NULL,
    CONSTRAINT pk_item PRIMARY KEY (id)
);

CREATE TABLE item_childes
(
    item_id    BIGINT NOT NULL,
    childes_id BIGINT NOT NULL,
    CONSTRAINT pk_item_childes PRIMARY KEY (item_id, childes_id)
);

CREATE TABLE list
(
    id                   BIGINT AUTO_INCREMENT NOT NULL,
    created_at           DATETIME              NULL,
    last_modified_at     DATETIME              NULL,
    note                 VARCHAR(255)          NOT NULL,
    list_participants_id BIGINT                NOT NULL,
    created_by           BLOB                  NULL,
    last_modified_by     BLOB                  NULL,
    CONSTRAINT pk_list PRIMARY KEY (id)
);

CREATE TABLE list_item_list
(
    item_list_id BIGINT NOT NULL,
    list_id      BIGINT NOT NULL,
    CONSTRAINT pk_list_itemlist PRIMARY KEY (item_list_id, list_id)
);

CREATE TABLE list_participants
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    list_id BIGINT                NULL,
    CONSTRAINT pk_list_participants PRIMARY KEY (id)
);

CREATE TABLE list_participants_users
(
    list_participants_id BIGINT NOT NULL,
    users_id             BIGINT NOT NULL,
    CONSTRAINT pk_list_participants_users PRIMARY KEY (list_participants_id, users_id)
);

CREATE TABLE member
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       DATETIME              NULL,
    last_modified_at DATETIME              NULL,
    email            VARCHAR(255)          NOT NULL,
    mobile           VARCHAR(15)           NULL,
    name             VARCHAR(20)           NULL,
    profile_pic      VARCHAR(500)          NULL,
    oauth_active     INT                   NOT NULL,
    CONSTRAINT pk_member PRIMARY KEY (id)
);

ALTER TABLE item_childes
    ADD CONSTRAINT uc_item_childes_childes UNIQUE (childes_id);

ALTER TABLE list_item_list
    ADD CONSTRAINT uc_list_item_list_itemlist UNIQUE (item_list_id);

ALTER TABLE list_participants_users
    ADD CONSTRAINT uc_list_participants_users_users UNIQUE (users_id);

ALTER TABLE alarm
    ADD CONSTRAINT fk_alarm_on_item FOREIGN KEY (item_id) REFERENCES item (id);

ALTER TABLE item
    ADD CONSTRAINT fk_item_on_child FOREIGN KEY (child) REFERENCES item (id);

ALTER TABLE item
    ADD CONSTRAINT fk_item_on_id FOREIGN KEY (id) REFERENCES alarm (id);

ALTER TABLE item
    ADD CONSTRAINT fk_item_on_list FOREIGN KEY (list_id) REFERENCES list (id);

ALTER TABLE list
    ADD CONSTRAINT fk_list_on_list_participants FOREIGN KEY (list_participants_id) REFERENCES list_participants (id);

ALTER TABLE list_participants
    ADD CONSTRAINT fk_list_participants_on_list FOREIGN KEY (list_id) REFERENCES list (id);

ALTER TABLE item_childes
    ADD CONSTRAINT fk_itechi_on_childes FOREIGN KEY (childes_id) REFERENCES item (id);

ALTER TABLE item_childes
    ADD CONSTRAINT fk_itechi_on_item FOREIGN KEY (item_id) REFERENCES item (id);

ALTER TABLE list_item_list
    ADD CONSTRAINT fk_lisitelis_on_item FOREIGN KEY (item_list_id) REFERENCES item (id);

ALTER TABLE list_item_list
    ADD CONSTRAINT fk_lisitelis_on_list FOREIGN KEY (list_id) REFERENCES list (id);

ALTER TABLE list_participants_users
    ADD CONSTRAINT fk_lisparuse_on_list_participants FOREIGN KEY (list_participants_id) REFERENCES list_participants (id);

ALTER TABLE list_participants_users
    ADD CONSTRAINT fk_lisparuse_on_member FOREIGN KEY (users_id) REFERENCES member (id);