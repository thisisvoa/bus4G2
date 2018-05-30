package cn.com.reformer.netty.handler;

import cn.com.reformer.netty.adapter.TCPMessageHandlerAdapter;
import cn.com.reformer.netty.bean.BaseParam;
import cn.com.reformer.netty.cache.MsgCache;
import cn.com.reformer.netty.event.handler.IUploadHandler;
import cn.com.reformer.netty.guava.SimpleListener;
import cn.com.reformer.netty.msg.MSG_0x05;
import cn.com.reformer.netty.util.DateUtils;
import com.google.common.eventbus.EventBus;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.Date;

/**
 *  Copyright 2017 the original author or authors hangzhou Reformer 
 * @Description: 上传二维码
 * @author zhangjin
 * @create 2017-05-08
**/
public class Handler0x05 extends TCPMessageHandlerAdapter {

    Logger logger = LoggerFactory.getLogger(Handler0x05.class);

    @Autowired(required = false)
    EventBus eventBus;
    @Autowired(required = false)
    SimpleListener simpleListener;
    @Autowired
    private SimpMessagingTemplate template;

    public void doHandle(BaseParam m, ChannelHandlerContext ctx) {
        try {
            if (m instanceof MSG_0x05) {
                MSG_0x05 msg = (MSG_0x05) m;

                template.convertAndSend("/topic/getResponse", "二维码内容："+msg.getQrdata()+"  时间："+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
//                eventBus.register(simpleListener);
//                eventBus.post(msg.getQrdata());
              //  MsgCache.getInstance().remove(msg.getHead() + ";" + msg.getHead().getSeq());
            } else {
                logger.error("convert common reply fail:" + m.toString());
//                eventBus.register(simpleListener);
//            /    eventBus.post(m.toString());
                template.convertAndSend("/topic/getResponse", "二维码内容：为空！！！"+"  时间："+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
            }
        } catch (Exception e) {
            logger.error("handler common reply fail" + e);
        }
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public SimpleListener getSimpleListener() {
        return simpleListener;
    }

    public void setSimpleListener(SimpleListener simpleListener) {
        this.simpleListener = simpleListener;
    }
}
