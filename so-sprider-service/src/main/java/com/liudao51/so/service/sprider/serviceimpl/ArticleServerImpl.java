package com.liudao51.so.service.sprider.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liudao51.so.entity.po.Article;
import com.liudao51.so.facade.IArticleService;
import com.liudao51.so.service.sprider.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 文章概要 服务实现类
 * </p>
 *
 * @author Jewel
 * @since 2020-12-24
 */
@Service
public class ArticleServerImpl implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 增加文章
     *
     * @param article
     * @return
     */
    public int addArticle(Article article) {
        return articleMapper.insert(article);
    }

    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    public int deleteArticle(Serializable id) {
        if (id != null) {
            return articleMapper.deleteById(id);
        }
        return 0;
    }

    /**
     * 修改文章
     *
     * @param article
     * @return
     */
    public int updateArticle(Article article) {
        return articleMapper.updateById(article);
    }

    /**
     * 获取单个文章
     *
     * @param id
     * @return
     */
    public Article getArticle(Serializable id) {
        if (id != null) {
            return articleMapper.selectById(id);
        }
        return null;
    }

    /**
     * 获取文章列表
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Page<Article> getArticleList(Integer currentPage, Integer pageSize) {
        Page<Article> page = new Page<>(currentPage, pageSize);
        return (Page<Article>) articleMapper.selectPage(page, new QueryWrapper<Article>().orderByDesc("id"));
    }
}
