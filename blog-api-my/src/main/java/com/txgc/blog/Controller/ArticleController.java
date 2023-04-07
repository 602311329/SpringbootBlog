package com.txgc.blog.Controller;

import com.txgc.blog.common.Cache.Cache;
import com.txgc.blog.common.aop.LogAnnotation;
import com.txgc.blog.service.ArticleService;
import com.txgc.blog.vo.params.ArticleParam;
import com.txgc.blog.vo.params.PageParams;
import com.txgc.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//json数据进行交互
@RestController
@RequestMapping("articles")
public class ArticleController {
    @Autowired(required = false)
    private ArticleService articleService;
    @PostMapping("search")
    public Result search(@RequestBody ArticleParam articleParam){
        //写一个搜索接口
        String search = articleParam.getSearch();
        return articleService.searchArticle(search);
    }
    /**
     * 首页文章列表  分页
     * @param pageParams
     * @return
     */
    @PostMapping
    //加上此注解代表要对此接口记录日志
    @LogAnnotation(module="文章",operator="获取文章列表")
    @Cache(expire = 5*60*1000,name ="list_article")
    public Result listArticle(@RequestBody PageParams pageParams){
        //int i=10/0;
        return articleService.listArticle(pageParams);
    }

    /**
     * 首页最热文章
     * @return
     */
    @PostMapping("hot")
    @Cache(expire = 5*60*1000,name ="hot_article")
    public Result hotArticle(){
        //int i=10/0;
        int limit=5;
        return articleService.hotArticle(limit);
    }
    /**
     * 首页最新文章
     * @return
     */
    @PostMapping("new")
    @Cache(expire = 5*60*1000,name ="news_article")
    public Result newArticles(){
        //int i=10/0;
        int limit=5;
        return articleService.newArticles(limit);
    }
    /**
     * 文章归档
     * @return
     */
    @PostMapping("listArchives")
    public Result listArchives(){return articleService.listArchives();}

    @PostMapping("view/{id}")
    public Result findArticleById(@PathVariable("id") Long articleId){
        return articleService.findArticleById(articleId);
    }
    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return articleService.publish(articleParam);
    }
    @PostMapping("{id}")
    public Result articleById(@PathVariable("id") Long articleId){
        return articleService.findArticleById(articleId);
    }

}
