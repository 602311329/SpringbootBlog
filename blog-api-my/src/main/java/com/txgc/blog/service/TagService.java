package com.txgc.blog.service;

import com.txgc.blog.vo.Result;
import com.txgc.blog.vo.TagVo;

import java.util.List;

public interface TagService {
    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);

    /**
     * 查询所有文章标签（写文章时选择文章分类）
     * @return
     */
    Result findAll();
    /**
     * 查询所有文章标签详细（首页文章分类）
     * @return
     */
    Result findAllDetail();

    /**
     * 打开文章分类中的标签，显示对应的文章（不设置之前显示的是所有的文章）
     * @param id
     * @return
     */
    Result findAllDetailById(Long id);
}
