package cn.liaozh.dao;

import cn.liaozh.pojo.YmChatMsg;
import cn.liaozh.pojo.vo.PaginationVO;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface YmChatMsgMapper extends MPJBaseMapper<YmChatMsg> {
    List<YmChatMsg> selectMsgList(@Param("userId") String userId, @Param("page") PaginationVO page);
}
