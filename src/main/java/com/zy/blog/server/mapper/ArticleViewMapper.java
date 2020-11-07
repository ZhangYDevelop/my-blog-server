package com.zy.blog.server.mapper;

import com.zy.blog.server.entity.Article;
import com.zy.blog.server.entity.ArticleView;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章Mapper
 *
 * @author zhangyu
 */
public interface ArticleViewMapper extends Mapper<ArticleView> {

    @Select("select * from (  select DATE_FORMAT(create_time,'%Y-%m-%d') days,count(id) count from article_view group by days order by create_time desc limit 0, 20  ) a order by a.days asc ")
    List<Map> getArticleTongji();
}
