package com.txgc.blog.Controller;

import com.txgc.blog.utils.QiniuUtils;
import com.txgc.blog.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("upload")
public class UploadController {
    @Autowired
    private QiniuUtils qiniuUtils;
    @PostMapping
    public Result upload(@RequestParam("image")MultipartFile file){
        //原始文件名称==>改为随机 唯一性的名称
        String originalFilename = file.getOriginalFilename();
        //唯一性的名称
        String fileName = UUID.randomUUID().toString() + "." + StringUtils.substringAfterLast(originalFilename, ".");
        //上传文件到哪？  七牛云服务器 按量付费 速度快 把图片上传到离用户最近的服务器上
        //降低自身应用服务器的带宽消耗
        boolean upload = qiniuUtils.upload(file, fileName);
        if(upload){
            return Result.success(QiniuUtils.url+fileName);
        }
        return Result.fail(20001,"图片上传失败");
    }
}
