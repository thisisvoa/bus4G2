package cn.com.reformer.netty.guava;

import com.google.common.eventbus.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import javax.annotation.Resource;

/**
 * Created by zhang on 2017/8/22.
 */
public class SimpleListener {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Subscribe
    public void task(String s) {

        this.simpMessagingTemplate.convertAndSend("/topic/getResponse", s);
    }

    public SimpMessagingTemplate getSimpMessagingTemplate() {
        return simpMessagingTemplate;
    }

    public void setSimpMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }
}
