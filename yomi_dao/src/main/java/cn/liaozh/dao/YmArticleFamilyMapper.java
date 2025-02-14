package cn.liaozh.dao;

import cn.liaozh.pojo.YmArticleFamily;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface YmArticleFamilyMapper extends MPJBaseMapper<YmArticleFamily> {
    YmArticleFamily getYmArticleFamilyById(@Param("familyId") String familyId);
}
