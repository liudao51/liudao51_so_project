use liudao51_so;

DROP TABLE `article`;
DROP TABLE `article_keyword`;
DROP TABLE `article_content`;
DROP TABLE `article_content_snapshot`;

############################################

## 文章表(article)
CREATE TABLE `article`
(
    `id`           BIGINT(20)   NOT NULL COMMENT '文章id',
    `title`        VARCHAR(30)  NOT NULL DEFAULT '' COMMENT '标题',
    `description`  VARCHAR(300) NOT NULL DEFAULT '' COMMENT '描述',
    `from_url`     VARCHAR(100) NOT NULL DEFAULT '' COMMENT '入口url',
    `site_url`     VARCHAR(100) NOT NULL DEFAULT '' COMMENT '站点url',
    `created_time` BIGINT(20)   NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_time` BIGINT(20)   NOT NULL DEFAULT 0 COMMENT '更新时间',
    `version`      BIGINT(20)   NOT NULL DEFAULT 1 COMMENT '版本(用于乐观锁)',
    PRIMARY KEY (id)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8 COMMENT ='文章概要';

## 文章关键词表(article_keyword)
CREATE TABLE `article_keyword`
(
    `id`           BIGINT(20)    NOT NULL COMMENT '文章关键词id',
    `article_id`   BIGINT(20)    NOT NULL COMMENT '文章id',
    `keyword`      VARCHAR(5000) NOT NULL DEFAULT '' COMMENT '关键词',
    `created_time` BIGINT(20)    NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_time` BIGINT(20)    NOT NULL DEFAULT 0 COMMENT '更新时间',
    `version`      BIGINT(20)    NOT NULL DEFAULT 1 COMMENT '版本(用于乐观锁)',
    PRIMARY KEY (id),
    KEY `index_article_id` (`article_id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8 COMMENT ='文章关键词';

## 文章内容表(article_content)
CREATE TABLE `article_content`
(
    `id`           BIGINT(20)    NOT NULL COMMENT '文章内容id',
    `article_id`   BIGINT(20)    NOT NULL COMMENT '文章id',
    `content`      VARCHAR(5000) NOT NULL DEFAULT '' COMMENT '内容',
    `created_time` BIGINT(20)    NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_time` BIGINT(20)    NOT NULL DEFAULT 0 COMMENT '更新时间',
    `version`      BIGINT(20)    NOT NULL DEFAULT 1 COMMENT '版本(用于乐观锁)',
    PRIMARY KEY (id),
    UNIQUE KEY `unique_article_id` (`article_id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8 COMMENT ='文章内容';


## 文章内容快照表(article_content_snapshot)
CREATE TABLE `article_content_snapshot`
(
    `id`           BIGINT(20)    NOT NULL COMMENT '文章内容id',
    `article_id`   BIGINT(20)    NOT NULL COMMENT '文章id',
    `content`      VARCHAR(5000) NOT NULL DEFAULT '' COMMENT '内容',
    `created_time` BIGINT(20)    NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_time` BIGINT(20)    NOT NULL DEFAULT 0 COMMENT '更新时间',
    `version`      BIGINT(20)    NOT NULL DEFAULT 1 COMMENT '版本(用于乐观锁)',
    PRIMARY KEY (id),
    UNIQUE KEY `unique_article_id` (`article_id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8 COMMENT ='文章快照内容';


############################################
#article
INSERT INTO `article` (`id`, `title`, `description`, `from_url`, `site_url`) VALUES (1, 'GitHub 上有哪些优秀的 Java 爬虫项目? - 知乎', 'WebCollector是一个无须配置、便于二次开发的JAVA爬虫框架(内核),它提供精简的的API,只需少量代码即可实现一个功能强大的爬虫。WebCollector-Hadoop是WebCollector的','http://www.baidu.com','https://www.zhihu.com/question/31427895');
INSERT INTO `article` (`id`, `title`, `description`, `from_url`, `site_url`) VALUES (1, 'Java爬虫_阳神-CSDN博客_java爬虫', 'Java爬虫 网络爬虫 概念 网络爬虫(Web crawler),是一种按照一定的规则,自动地抓取万维网信息的程序或者脚本。 简单的小程序 创建依赖...','http://www.baidu.com','https://blog.csdn.net/qq_44797965/article/details/108251164');
INSERT INTO `article` (`id`, `title`, `description`, `from_url`, `site_url`) VALUES (2, 'Python爬虫原理', '简单来说互联网是由一个个站点和网络设备组成的大网，我们通过浏览器访问站点，站点把HTML、JS、CSS代码返回给浏览器，这些代码经过浏览器解析、渲染，将丰富多彩的网页呈现我们眼前','http://www.baidu.com','https://www.cnblogs.com/sss4/p/7809821.html');
INSERT INTO `article` (`id`, `title`, `description`, `from_url`, `site_url`) VALUES (2, '入门Python爬虫——获取数据篇', '在如今的大数据时代，相信大家都对Python一词有所耳闻。而Python爬虫，简单来说，即通过Python程序获取对我们有用的数据。常用于商业分析，不过偶尔也可以辅助我们解决在日常生活中遇到的一些问题。','http://www.baidu.com','https://baijiahao.baidu.com/s?id=1670801762859023601');
#article_keyword
INSERT INTO `article_keyword` (`id`, `article_id`, `keyword`) VALUES (1, '1', 'java');
INSERT INTO `article_keyword` (`id`, `article_id`, `keyword`) VALUES (2, '1', '爬虫');
INSERT INTO `article_keyword` (`id`, `article_id`, `keyword`) VALUES (3, '1', 'java爬虫');
INSERT INTO `article_keyword` (`id`, `article_id`, `keyword`) VALUES (4, '2', 'python');
INSERT INTO `article_keyword` (`id`, `article_id`, `keyword`) VALUES (5, '2', '爬虫');
INSERT INTO `article_keyword` (`id`, `article_id`, `keyword`) VALUES (6, '2', 'python爬虫');
#article_content
INSERT INTO `article_content` (`id`, `article_id`, `content`) VALUES (1, '1', 'Gecco是一款用java语言开发的轻量化的易用的网络爬虫。整合了jsoup、httpclient、fastjson、spring、htmlunit、redission等框架，只需要配置一些jquery风格的选择器就能很快的写出一个爬虫。Gecco框架有优秀的可扩展性，框架基于开闭原则进行设计，对修改关闭、对扩展开放。 ');
INSERT INTO `article_content` (`id`, `article_id`, `content`) VALUES (2, '1', '在大数据时代，信息的采集是一项重要的工作，而互联网中的数据是海量的，如果单纯靠人力进行信息采集，不仅低效繁琐，搜集的成本也会提高。如何自动高效地获取互联网中我们感兴趣的信息并为我们所用是一个重要的问题，而爬虫技术就是为了解决这些问题而生的');
INSERT INTO `article_content` (`id`, `article_id`, `content`) VALUES (3, '2', 'python爬虫 可视化爬虫抓取流程,可爬取任意网页数据,API导出,秒级同步.python爬虫内置100+主流网站采集模板,简单3步,日采海量数据,百万用户的选择');
INSERT INTO `article_content` (`id`, `article_id`, `content`) VALUES (4, '2', '在如今的大数据时代,相信大家都对Python一词有所耳闻。而Python爬虫,简单来说,即通过Python程序获取对我们有用的数据。常用于商业分析,不过偶尔也可以辅助我们解决在');
#article_content_snapshot
INSERT INTO `article_content_snapshot` (`id`, `article_id`, `content`) VALUES (1, '1', '<blockquote>Gecco是一款用java语言开发的轻量化的易用的网络爬虫。整合了jsoup、httpclient、fastjson、spring、htmlunit、redission等框架，只需要配置一些jquery风格的选择器就能很快的写出一个爬虫。Gecco框架有优秀的可扩展性，框架基于开闭原则进行设计，对修改关闭、对扩展开放。<br></blockquote>');
INSERT INTO `article_content_snapshot` (`id`, `article_id`, `content`) VALUES (2, '1', '<p>在大数据时代，信息的采集是一项重要的工作，而互联网中的数据是海量的，如果单纯靠人力进行信息采集，不仅低效繁琐，搜集的成本也会提高。如何自动高效地获取互联网中我们感兴趣的信息并为我们所用是一个重要的问题，而爬虫技术就是为了解决这些问题而生的</p>');
INSERT INTO `article_content_snapshot` (`id`, `article_id`, `content`) VALUES (3, '2', '<p>简单来说互联网是由一个个站点和网络设备组成的大网，我们通过浏览器访问站点，站点把HTML、JS、CSS代码返回给浏览器，这些代码经过浏览器解析、渲染，将丰富多彩的网页呈现我们眼前；</p>');
INSERT INTO `article_content_snapshot` (`id`, `article_id`, `content`) VALUES (4, '2', '<p bdsfid="59"><span class="bjh-p" bdsfid="60">在如今的大数据时代，相信大家都对Python一词有所耳闻。而<span class="bjh-strong" bdsfid="61"><b style="color:black;background-color:#ffff66">Python爬虫</b></span>，简单来说，即<span class="bjh-strong" bdsfid="62">通过Python程序获取对我们有用的数据</span>。常用于商业分析，不过偶尔也可以辅助我们解决在日常生活中遇到的一些问题。</span></p>');



