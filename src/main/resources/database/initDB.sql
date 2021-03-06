CREATE TABLE IF NOT EXISTS customer(
    ID INTEGER generated by default as identity (start with 1),
    INN VARCHAR(50) NOT NULL,
    NAME VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS loan(
    ID INTEGER generated by default as identity (start with 1),
    INN VARCHAR(50) NOT NULL,
    SUM BIGINT NOT NULL
);