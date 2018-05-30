package cn.com.reformer.netty.handler;

import cn.com.reformer.netty.adapter.TCPMessageHandlerAdapter;
import cn.com.reformer.netty.bean.BaseParam;
import cn.com.reformer.netty.msg.MSG_0x03;
import cn.com.reformer.netty.msg.MSG_0x04;
import cn.com.reformer.netty.util.DateUtils;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.Date;

/**
 *  Copyright 2017 the original author or authors hangzhou Reformer 
 * @Description: 上传状态
 * @author zhangjin
 * @create 2017-05-08
**/
public class Handler0x04 extends TCPMessageHandlerAdapter {

    Logger logger = LoggerFactory.getLogger(Handler0x04.class);
    @Autowired
    private SimpMessagingTemplate template;
    public void doHandle(BaseParam m, ChannelHandlerContext ctx) {
        try {
            if (m instanceof MSG_0x04) {
                template.convertAndSend("/topic/getResponse", "查询状态："+m.toString()+"  时间："+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
//                MsgCache.getInstance().remove(msg.getHead() + ";" + msg.getHead().getSeq());
            } else {
                logger.error("convert common reply fail:" + m.toString());
            }
        } catch (Exception e) {
            logger.error("handler common reply fail" + e);
        }
    }

}
