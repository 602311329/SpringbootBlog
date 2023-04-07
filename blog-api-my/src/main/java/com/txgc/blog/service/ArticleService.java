package com.txgc.blog.service;

import com.txgc.blog.vo.params.ArticleParam;
import com.txgc.blog.vo.params.PageParams;
import com.txgc.blog.vo.Result;
public interface ArticleService {
    /**
     * 分页查询 文章列表
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);

    /**
     * 最热文章
     * @return
     */
    Result hotArticle(int limit);
    /**
     * 最新文章
     * @return
     */
    Result newArticles(int limit);

    /**
     * 文章归档
     * @return
     */
    Result listArchives();

    /**
     * 查看文章详情
     * @param articleId
     * @return
     */
    Result findArticleById(Long articleId);

    /**
     * 文章发布服务
     * @param articleParam
     * @return
     */
    Result publish(ArticleParam articleParam);
    /**
     * 文章搜索
     * @param search
     * @return
     */
    Result searchArticle(String search);
}
