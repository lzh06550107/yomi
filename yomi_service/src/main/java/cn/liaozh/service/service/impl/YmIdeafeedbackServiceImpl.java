package cn.liaozh.service.service.impl;

import cn.liaozh.dao.YmIdeafeedbackMapper;
import cn.liaozh.pojo.YmIdeafeedback;
import cn.liaozh.service.service.YmIdeafeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class YmIdeafeedbackServiceImpl extends ServiceImpl<YmIdeafeedbackMapper, YmIdeafeedback> implements YmIdeafeedbackService {
    public YmIdeafeedbackServiceImpl() {
    }
}
