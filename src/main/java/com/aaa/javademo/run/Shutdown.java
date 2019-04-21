package com.aaa.javademo.run;

import com.aaa.javademo.common.AppEnv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;


public class Shutdown implements ApplicationListener<ContextClosedEvent> {

    private static final Logger log = LoggerFactory.getLogger(Shutdown.class);

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        AppEnv.running = false;
        log.info("正在停止系统");
        int timeout = 1;
        while (AppEnv.runningTasks.size() > 0) {
            timeout++;
            if (timeout > 10) {
                break;
            }
            log.info("正在等待任务执行完成，请勿强行关闭,剩余任务数:" + AppEnv.runningTasks.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("停止系统完成");
    }

}
