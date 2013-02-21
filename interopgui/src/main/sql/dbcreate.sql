CREATE USER interopguiuser IDENTIFIED BY 'interopguipass';

CREATE DATABASE interopgui;

CREATE TABLE interopgui.orginfo (
    id BIGINT NOT NULL AUTO_INCREMENT,
    hcid VARCHAR(32) NOT NULL,
    first VARCHAR(32) NOT NULL,
    last VARCHAR(32) NOT NULL,
    dob VARCHAR(10) NOT NULL,
    gender CHAR(1) NOT NULL,
    docid VARCHAR(256) NOT NULL,
    doctype VARCHAR(256) NOT NULL,
    comment longtext,
    cert longtext,
    certtype VARCHAR(32),
  PRIMARY KEY(id)
);

GRANT SELECT,INSERT,UPDATE,DELETE ON *.* TO 'interopguiuser'@'localhost' IDENTIFIED BY 'interopguipass' WITH GRANT OPTION;
GRANT SELECT,INSERT,UPDATE,DELETE ON *.* TO 'interopguiuser'@'127.0.0.1' IDENTIFIED BY 'interopguipass' WITH GRANT OPTION;
FLUSH PRIVILEGES;
