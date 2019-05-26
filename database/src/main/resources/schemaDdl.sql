CREATE DATABASE jd2;

CREATE SCHEMA IF NOT EXISTS app;

SET SEARCH_PATH = "app";

DROP TABLE IF EXISTS app.user CASCADE;
CREATE TABLE app.user
(
    id            BIGSERIAL PRIMARY KEY,
    username      VARCHAR(150) NOT NULL UNIQUE,
    email         VARCHAR(100) NOT NULL UNIQUE,
    phone         VARCHAR(13),
    password      VARCHAR(100) NOT NULL,
    active        BOOLEAN,
    role          VARCHAR(100),
    register_date DATE,
    birth_date    DATE,
    name          VARCHAR(100),
    surname       VARCHAR(100)
);

DROP TABLE IF EXISTS app.tag CASCADE;
CREATE TABLE app.tag
(
    id    BIGSERIAL PRIMARY KEY,
    lang  VARCHAR(2),
    value VARCHAR(100)
);

DROP TABLE IF EXISTS app.category CASCADE;
CREATE TABLE app.category
(
    id        BIGSERIAL PRIMARY KEY,
    parent_id BIGINT,
    alias     VARCHAR(255),
    created   TIMESTAMP NOT NULL,
    active    BOOLEAN
);

DROP TABLE IF EXISTS app.category_translation CASCADE;
CREATE TABLE app.category_translation
(
    category_id      BIGINT REFERENCES app.category (id) ON DELETE CASCADE,
    lang             VARCHAR(2),
    name             VARCHAR(255) NOT NULL,
    intro_text       TEXT,
    meta_title       VARCHAR(255),
    meta_description VARCHAR(255),
    meta_keywords    VARCHAR(255),
    PRIMARY KEY (category_id, lang)
);

Drop TABLE IF EXISTS app.content_type CASCADE;
CREATE TABLE app.content_type
(
    id     BIGSERIAL PRIMARY KEY,
    name   VARCHAR(100),
    active BOOLEAN
);

Drop TABLE IF EXISTS app.extra_field_type CASCADE;
CREATE TABLE app.extra_field_type
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    metadata JSON
);

Drop TABLE IF EXISTS app.content CASCADE;
CREATE TABLE app.content
(
    id              BIGSERIAL PRIMARY KEY,
    content_type_id BIGINT REFERENCES app.content_type (id),
    category_id     BIGINT REFERENCES app.category (id),
    alias           VARCHAR(255),
    created         TIMESTAMP,
    created_by      BIGINT REFERENCES app.user (id),
    last_modified   TIMESTAMP,
    publish_up      TIMESTAMP,
    publish_down    TIMESTAMP,
    hits            INTEGER,
    active          BOOLEAN,
    extra_fields    JSONB,
    image           VARCHAR(255)
);

DROP TABLE IF EXISTS app.extra_field CASCADE;
CREATE TABLE app.extra_field
(
    id                  BIGSERIAL PRIMARY KEY,
    content_type_id     BIGINT REFERENCES app.content_type (id) ON DELETE CASCADE,
    extra_field_type_id BIGINT REFERENCES app.extra_field_type (id),
    name                VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS app.content_translation CASCADE;
CREATE TABLE app.content_translation
(
    content_id       BIGINT       NOT NULL REFERENCES app.content (id) ON DELETE CASCADE,
    lang             VARCHAR(2)   NOT NULL,
    name             VARCHAR(255) NOT NULL,
    intro_text       TEXT,
    full_text        TEXT,
    meta_title       VARCHAR(255),
    meta_description VARCHAR(255),
    meta_keywords    VARCHAR(255),
    PRIMARY KEY (content_id, lang)
);

DROP TABLE IF EXISTS app.content_tag CASCADE;
CREATE TABLE app.content_tag
(
    content_id BIGINT NOT NULL REFERENCES app.content (id) ON DELETE CASCADE,
    tag_id     BIGINT NOT NULL REFERENCES app.tag (id) ON DELETE CASCADE,
    PRIMARY KEY (content_id, tag_id)
);

DROP TABLE IF EXISTS app.comment CASCADE;
CREATE TABLE app.comment
(
    id         BIGSERIAL PRIMARY KEY,
    content_id BIGINT REFERENCES app.content (id) ON DELETE CASCADE,
    user_id    BIGINT    REFERENCES app.user (id),
    created    TIMESTAMP NOT NULL,
    full_text  TEXT      NOT NULL,
    status     VARCHAR(100)
);