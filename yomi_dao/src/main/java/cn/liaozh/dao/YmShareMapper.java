package cn.liaozh.dao;

import cn.liaozh.pojo.YmShare;
import com.github.yulichang.base.MPJBaseMapper;
import org.mapstruct.Mapper;

@Mapper
public interface YmShareMapper extends MPJBaseMapper<YmShare> {
    int insertShare(YmShare share);
}
