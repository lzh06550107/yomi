package cn.liaozh.service.interceptor;

import cn.liaozh.service.service.YmFansService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {
    private static final Logger log = LoggerFactory.getLogger(Scheduler.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Resource
    private YmFansService fansService;

    public Scheduler() {
    }

    @Scheduled(
            cron = "0 07 03 ? * *"
    )
    public void Tasks() {
        int deleteRows = this.fansService.removeSoftDeleted();
        log.info("定时任务执行时间：" + dateFormat.format(new Date()));
    }
}
