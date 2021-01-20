package com.liudao51.so.service.sprider.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liudao51.so.common.util.CollectionUtilsX;
import com.liudao51.so.common.util.ObjectUtilsX;
import com.liudao51.so.entity.po.Article;
import com.liudao51.so.entity.po.ArticleKeyword;
import com.liudao51.so.entity.po.ArticleSnapshot;
import com.liudao51.so.entity.vo.ArticleSearchResultVo;
import com.liudao51.so.facade.IArticleSearchService;
import com.liudao51.so.service.sprider.mapper.ArticleKeywordMapper;
import com.liudao51.so.service.sprider.mapper.ArticleMapper;
import com.liudao51.so.service.sprider.mapper.ArticleSnapshotMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章快照内容 服务实现类
 * </p>
 *
 * @author Jewel
 * @since 2020-12-31
 */
@DubboService  //注册到zookeeper注册中心
@Component  //注册到spring容器
public class ArticleSearchServiceImpl implements IArticleSearchService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleSnapshotMapper articleSnapshotMapper;

    @Autowired
    private ArticleKeywordMapper articleKeywordMapper;

    public IPage<ArticleSearchResultVo> getArticleSearchPage(Integer currentPage, Integer pageSize, Map<String, Object> args) {
        //ArticleSearchResultVoPage对象
        IPage<ArticleSearchResultVo> articleSearchResultVoPage = new Page<>(currentPage, pageSize);
        //ArticleSearchResultVo对象集合
        List<ArticleSearchResultVo> articleSearchResultVos = new ArrayList<>();

        //文章对象集合
        QueryWrapper<Article> qw = new QueryWrapper<>();
        if (!CollectionUtilsX.isEmpty(args.keySet())) {
            if (!ObjectUtilsX.isEmpty(args.get("keyword"))) {
                qw.like("title", args.get("keyword")).or().like("description", args.get("keyword"));
            }
        }
        qw.orderByDesc("id");
        IPage<Article> articlePage = articleMapper.selectPage(new Page<>(currentPage, pageSize), qw);

        if (!ObjectUtilsX.isEmpty(articlePage) && !CollectionUtilsX.isEmpty(articlePage.getRecords())) {
            List<Article> articles = articlePage.getRecords();
            for (Article article : articles) {
                //快照对象
                ArticleSnapshot articleSnapshot = articleSnapshotMapper.selectOne(new QueryWrapper<ArticleSnapshot>().eq("article_id", article.getId()));
                //关键词对象集合
                List<ArticleKeyword> articleKeywords = articleKeywordMapper.selectList(new QueryWrapper<ArticleKeyword>().eq("article_id", article.getId()));
                //关键词集合
                List<String> keywords = new ArrayList<>();
                if (!CollectionUtilsX.isEmpty(articleKeywords)) {
                    for (ArticleKeyword articleKeyword : articleKeywords) {
                        keywords.add(articleKeyword.getKeyword());
                    }
                }
                //组装ArticleSearchResultVo对象
                ArticleSearchResultVo articleSearchResultVo = new ArticleSearchResultVo();
                articleSearchResultVo.setArticleId(article.getId());
                articleSearchResultVo.setTitle(article.getTitle());
                articleSearchResultVo.setDescription(article.getDescription());
                articleSearchResultVo.setSiteUrl(article.getSiteUrl());
                articleSearchResultVo.setArticleSnapshotId(articleSnapshot.getId());
                articleSearchResultVo.setSnapshotUpdatedTime(articleSnapshot.getUpdatedTime());
                articleSearchResultVo.setKeywords(keywords);
                //加入ArticleSearchResultVo对象集合
                articleSearchResultVos.add(articleSearchResultVo);
            }
            //组装ArticleSearchResultVoPage对象
            articleSearchResultVoPage.setCurrent(articlePage.getCurrent());
            articleSearchResultVoPage.setSize(articlePage.getSize());
            articleSearchResultVoPage.setPages(articlePage.getPages());
            articleSearchResultVoPage.setTotal(articlePage.getTotal());
            articleSearchResultVoPage.setRecords(articleSearchResultVos);
        }

        return articleSearchResultVoPage;
    }
}
