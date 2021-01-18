package com.liudao51.so.facade;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liudao51.so.entity.vo.ArticleSearchResultVo;

/**
 * 文章搜索结果
 */
public interface IArticleSearchService {
    IPage<ArticleSearchResultVo> getArticleSearchPage(Integer currentPage, Integer pageSize);
}
