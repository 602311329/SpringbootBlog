# springboot_blog

基于springboot的博客系统搭建（前后端分离项目）继续更新修改项目

## 版本1

### 技术要点：

整体框架：springboot, vue

登录技术：redis,spring security安全验证，JWT令牌验证，

线程池+ThreadLocal实现用户信息线程内保存，保证线程安全

使用CAS算法对数据库部分信息进行修改，保证线程安全

利用注解搭建统一日志记录，作用于方法和类

### 实现功能：

blog-api-my：实现了博客系统中的用户登录验证，查看文章，书写文章并上传，文章分类，文章标签分类，点赞，评论等基本博客功能

blog-api-admin:后台管理系统，实现对用户的权限管理(vue+elementui)

blog-app：基于vue的前端系统登录端口号为8888