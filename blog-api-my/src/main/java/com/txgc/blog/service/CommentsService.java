package com.txgc.blog.service;

import com.txgc.blog.vo.Result;
import com.txgc.blog.vo.params.CommentParam;

public interface CommentsService {
    /**
     * 根据文章id查询所有的评论列表
     * @param id
     * @return
     */
    Result commentsByArticleId(Long id);

    Result comment(CommentParam commentParam);
}
