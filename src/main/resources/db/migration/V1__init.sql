CREATE TABLE coffee (
  -- id is auto incremental
  id    SERIAL8     NOT NULL,
  name  VARCHAR(20) NOT NULL,
  price FLOAT4      NOT NULL,

  PRIMARY KEY (id),
  UNIQUE (NAME)
);
