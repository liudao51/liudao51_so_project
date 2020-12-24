package com.liudao51.so.facade;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liudao51.so.entity.po.Article;

import java.io.Serializable;

/**
 * <p>
 * 文章概要 服务类
 * </p>
 *
 * @author Jewel
 * @since 2020-12-24
 */
public interface IArticleService {

    /**
     * 增加文章
     *
     * @param article
     * @return
     */
    public int addArticle(Article article);

    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    public int deleteArticle(Serializable id);

    /**
     * 修改文章
     *
     * @param article
     * @return
     */
    public int updateArticle(Article article);

    /**
     * 获取单个文章
     *
     * @param id
     * @return
     */
    public Article getArticle(Serializable id);

    /**
     * 获取文章列表
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Page<Article> getArticleList(Integer currentPage, Integer pageSize);
}
