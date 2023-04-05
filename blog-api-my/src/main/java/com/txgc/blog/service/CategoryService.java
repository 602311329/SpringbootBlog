package com.txgc.blog.service;

import com.txgc.blog.vo.CategoryVo;
import com.txgc.blog.vo.Result;

import java.util.List;

public interface CategoryService {

    CategoryVo findCategoryById(Long categoryId);

    /**
     * 写文章时选择文章分类
     * @return
     */
    Result findAll();
    /**
     * 查询所有文章分类详细（首页文章分类）
     * @return
     */
    Result findAllDetail();

    Result findAllDetailById(Long id);
}
