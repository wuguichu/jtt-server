package com.ljq.framework.netty;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.handler.AbstractHandler;
import com.ljq.framework.handler.HandlerBeanHelper;
import com.ljq.framework.handler.JttSession;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class JttProtocolHandler extends ChannelInboundHandlerAdapter {

    public JttProtocolHandler(String packagePath) {
        handlerHashMap = HandlerBeanHelper.getBeanInfo(packagePath);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (!(msg instanceof AbstractInstruction))
            return;
        Channel channel = ctx.channel();
        AbstractInstruction request = (AbstractInstruction) msg;
        log.debug("channelRead: {}", request);

        AbstractHandler<? extends AbstractInstruction> abstractHandler = handlerHashMap.get((int) request.getHeader().getInstruction());
        if (abstractHandler == null) {
            log.warn("没有找到指令 0x{} 对应的处理handler", Long.toHexString(request.getHeader().getInstruction()));
            return;
        }
        AbstractInstruction response = abstractHandler.handleMessage(channel.attr(JttSession.KEY).get(), request);
        if (response == null) {
            log.warn("处理 {} 的指令 0x{} 结果返回了null", channel.remoteAddress(), Long.toHexString(request.getHeader().getInstruction()));
            return;
        }

        log.debug("响应：{}", response);
        channel.writeAndFlush(response);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        JttSession jttSession = new JttSession(ctx.channel());
        ctx.channel().attr(JttSession.KEY).set(jttSession);
        log.info("-----> 有新连接 ip[{}]", ctx.channel().remoteAddress());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        JttSession jttSession = ctx.channel().attr(JttSession.KEY).get();
        log.info("<----- 连接断开 ip[{}]", ctx.channel().remoteAddress());
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    private final HashMap<Integer, AbstractHandler<? extends AbstractInstruction>> handlerHashMap;
    private static final Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
}
