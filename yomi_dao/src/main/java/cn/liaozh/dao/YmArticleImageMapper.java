package cn.liaozh.dao;

import cn.liaozh.pojo.YmArticleImage;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface YmArticleImageMapper extends MPJBaseMapper<YmArticleImage> {
    YmArticleImage getArticleImageById(@Param("imageId") String imageId);
}
