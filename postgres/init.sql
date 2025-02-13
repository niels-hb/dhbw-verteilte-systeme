CREATE TABLE public.trending
(
    fetched_on timestamp without time zone NOT NULL,
    video_id character varying(255) NOT NULL,
    category_id character varying(255),
    channel_id character varying(255),
    channel_title character varying(255),
    comment_count integer,
    description text,
    dislike_count integer,
    like_count integer,
    published_at timestamp without time zone,
    rank integer,
    region character varying(255),
    tags text,
    title character varying(255),
    view_count bigint,
    CONSTRAINT trending_pkey PRIMARY KEY (fetched_on, video_id, region)
);

CREATE INDEX idxrsf3k214e106xqth64vrgq0v1 ON public.trending (fetched_on);

CREATE TABLE tmp_import
AS
SELECT *
FROM trending
WITH NO DATA;

COPY tmp_import
FROM '/docker-entrypoint-initdb.d/data.csv'
DELIMITER ','
CSV HEADER
;

INSERT INTO trending
SELECT DISTINCT ON (fetched_on, video_id, region) *
FROM tmp_import
;

DROP TABLE tmp_import
;
