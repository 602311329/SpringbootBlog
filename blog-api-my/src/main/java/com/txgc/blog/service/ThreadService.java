package com.txgc.blog.service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.txgc.blog.dao.mapper.ArticleMapper;
import com.txgc.blog.dao.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ThreadService {
    //期望此操作在线程池中执行，不会影响原有的主线程
    @Async("taskExcutor")
    public void updateArticleViewCount(ArticleMapper articleMapper, Article article) {
        int viewCounts=article.getViewCounts();
        Article articleUpdate=new Article();
        articleUpdate.setViewCounts(viewCounts+1);
        LambdaUpdateWrapper<Article> updateWrapper=new LambdaUpdateWrapper<>();
        updateWrapper.eq(Article::getId,article.getId());
        updateWrapper.eq(Article::getViewCounts,viewCounts);
        //很像半个CAS，场景：原先数据是1，A线程要改为2，这个时候B线程先改成了2。如果没有判断那就是写值丢失了
        // update article set view_count=100 where view_count=99 and id=1
        articleMapper.update(articleUpdate,updateWrapper);
        try {
            Thread.sleep(5000);
            System.out.println("更新完成了......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
