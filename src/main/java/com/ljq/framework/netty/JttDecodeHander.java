package com.ljq.framework.netty;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.MessageDecode;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class JttDecodeHander extends ByteToMessageDecoder {
    public JttDecodeHander(MessageDecode decoder) {
        this.decoder = decoder;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        if (log.isInfoEnabled()) {
            String hex;
            if (byteBuf.readableBytes() < 1024)
                hex = ByteBufUtil.hexDump(byteBuf);
            else
                hex = ByteBufUtil.hexDump(byteBuf, 0, 128);
            log.info("收到一帧数据报文: {}", hex);
        }
        AbstractInstruction instruction = decoder.decode(byteBuf);
        if (instruction != null) {
            list.add(instruction);
        }
    }

    private final MessageDecode decoder;
    private static final Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
}
