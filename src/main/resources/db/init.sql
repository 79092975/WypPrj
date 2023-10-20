DROP TABLE IF EXISTS user_info;

CREATE TABLE user_info(
                          id BIGINT  PRIMARY KEY  AUTO_INCREMENT COMMENT 'id',
                          name VARCHAR(30) NOT NULL UNIQUE COMMENT '姓名',
                          age INT  NULL DEFAULT 0 COMMENT '年龄',
                          email VARCHAR(50) NOT NULL COMMENT '邮箱',
                          state TINYINT NOT NULL DEFAULT 1 COMMENT '状态（0-失效，1-有效）'
);