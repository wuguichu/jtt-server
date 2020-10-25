package com.ljq.framework.netty;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.MessageEncode;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JttEncodeHandler extends MessageToByteEncoder<AbstractInstruction> {

    public JttEncodeHandler(MessageEncode encode) {
        this.encode = encode;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, AbstractInstruction abstractInstruction, ByteBuf byteBuf) {
        ByteBuf buf = this.encode.encode(abstractInstruction);
        if (log.isDebugEnabled())
            log.debug("<<<<<编码报文[ip={}],hex={}", channelHandlerContext.channel().remoteAddress(), ByteBufUtil.hexDump(buf));
        byteBuf.writeBytes(buf);
    }

    private final MessageEncode encode;
    private static final Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
}
