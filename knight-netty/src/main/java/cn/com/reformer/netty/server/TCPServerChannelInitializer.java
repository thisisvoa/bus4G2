package cn.com.reformer.netty.server;

import cn.com.reformer.netty.handler.TCPMessageHandler;
import cn.com.reformer.netty.server.code.ExterStringEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  Copyright 2017 the original author or authors hangzhou Reformer 
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @author zhangjin
 * @create 2017-05-08
**/
public class TCPServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Autowired
    private TCPMessageHandler tcpMessageHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("tcpMsgEncoder", new ExterStringEncoder());
        ByteBuf delimiter = Unpooled.copiedBuffer("\n\r".getBytes());
        DelimiterBasedFrameDecoder decoder = new DelimiterBasedFrameDecoder(1500,delimiter);
        pipeline.addLast("tcpMsgDecoder", new StringDecoder(CharsetUtil.UTF_8));
        pipeline.addLast("tcpMsgHandler", tcpMessageHandler);
    }
}
