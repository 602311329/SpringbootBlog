package com.txgc.blog.vo.params;

import com.txgc.blog.vo.CategoryVo;
import com.txgc.blog.vo.TagVo;
import lombok.Data;

import java.util.List;

@Data
public class ArticleParam {

    private String id;

    private ArticleBodyParam body;

    private CategoryVo category;

    private String summary;

    private List<TagVo> tags;

    private String title;
}
