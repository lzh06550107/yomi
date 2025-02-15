package cn.liaozh.service.service.impl;

import cn.liaozh.dao.YmArticleImageMapper;
import cn.liaozh.pojo.YmArticleImage;
import cn.liaozh.service.service.YmArticleImageService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class YmArticleImageServiceImpl extends MPJBaseServiceImpl<YmArticleImageMapper, YmArticleImage> implements YmArticleImageService {

    public void update(YmArticleImage image) {
        this.baseMapper.insert(image);
    }
}
