use liudao51_so;

## 文章表(article)
CREATE TABLE `article`(
	`id` BIGINT(20) NOT NULL COMMENT '文章id',
	`title` VARCHAR(30) NOT NULL DEFAULT '' COMMENT '标题',
	`description` VARCHAR(300) NOT NULL DEFAULT 0 COMMENT '描述',
	`created_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
	`updated_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '更新时间',
	`version` BIGINT(20) NOT NULL DEFAULT 1 COMMENT '版本(用于乐观锁)',
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章概要';
INSERT INTO `article` (`id`, `title`, `description`) VALUES
(1, 'java爬虫', '使用Jsoup+HttpClient技术'),
(2, 'python爬虫', '使用Scrapy框架技术');

## 文章内容表(article_content)
CREATE TABLE `article_content`(
    `id` BIGINT(20) NOT NULL COMMENT '文章内容id',
    `article_id` BIGINT(20) NOT NULL COMMENT '文章id',
    `content` VARCHAR(5000) NOT NULL DEFAULT 0 COMMENT '内容',
    `created_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '更新时间',
	`version` BIGINT(20) NOT NULL DEFAULT 1 COMMENT '版本(用于乐观锁)',
  PRIMARY KEY (id),
  UNIQUE KEY `unique_article_id` (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章内容';


## 文章关键词表(article_keyword)
CREATE TABLE `article_keyword`(
	`id` BIGINT(20) NOT NULL COMMENT '文章关键词id',
	`article_id` BIGINT(20) NOT NULL COMMENT '文章id',
	`keyword` VARCHAR(5000) NOT NULL DEFAULT 0 COMMENT '关键词',
	`created_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
	`updated_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '更新时间',
	`version` BIGINT(20) NOT NULL DEFAULT 1 COMMENT '版本(用于乐观锁)',
	PRIMARY KEY (id),
  KEY `index_article_id` (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章关键词';

