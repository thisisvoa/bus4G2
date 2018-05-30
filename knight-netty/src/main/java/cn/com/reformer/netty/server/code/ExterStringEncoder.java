package cn.com.reformer.netty.server.code;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by Administrator on 2018/5/30/030.
 */
public class ExterStringEncoder extends StringEncoder {


    protected void encode(ChannelHandlerContext ctx, CharSequence msg, List<Object> out) throws Exception {
        if(msg.length() != 0) {
            ByteBuf e = ByteBufUtil.encodeString(ctx.alloc(), CharBuffer.wrap(msg), CharsetUtil.UTF_8);
            out.add(e);
        }
    }

}
