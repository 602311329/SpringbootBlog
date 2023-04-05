package com.txgc.blog.vo.params;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PageParams {
    private int page=1;
    private int pageSize=10;
    private Long categoryId;

    private Long tagId;
    private String year;

    private String month;

    public String getMonth(){
        //如果月份只有一位，前面加零  1——01
        if (this.month != null && this.month.length() == 1){
            return "0"+this.month;
        }
        return this.month;
    }
}
