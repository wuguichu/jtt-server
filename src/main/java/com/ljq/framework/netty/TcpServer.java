package com.ljq.framework.netty;

import com.ljq.framework.codec.MessageDecode;
import com.ljq.framework.codec.MessageEncode;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioChannelOption;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class TcpServer {
    public void setPort(int port) {
        this.port = port;
    }

    public synchronized void start() {
        if (running) {
            log.warn("server is running");
            return;
        }
        running = true;
        new Thread(this::startServer).start();
    }

    public synchronized void stop() {
        if (!running) {
            log.warn("服务器没有在运行");
            return;
        }
        running = false;
        Future<?> future = bossGroup.shutdownGracefully();
        if (!future.isSuccess())
            log.warn("bossGroup 无法正常停止");
        future = workerGroup.shutdownGracefully();
        if (!future.isSuccess())
            log.warn("workerGroup 无法正常停止");
        log.info("================服务器停止成功=================");
    }

    private void startServer() {
        bossGroup = new NioEventLoopGroup(1);
        workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(bossGroup, workerGroup)
                //.option(NioChannelOption.SO_BACKLOG, 1024)
                .channel(NioServerSocketChannel.class)
                .childOption(NioChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) {
                        nioSocketChannel.pipeline()
                                .addLast(new IdleStateHandler(30, 0, 0, TimeUnit.SECONDS))
                                .addLast(new JttEncodeHandler(new MessageEncode("com.ljq.protocol.basic")))
                                .addLast(new JttDecodeHandler(new MessageDecode("com.ljq.protocol.basic")))
                                .addLast(new JttProtocolHandler("com.ljq.backstage.handler"));
                    }
                });

        try {
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            log.info("================服务器启动成功 port:{}=================", port);
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.warn("=================服务器启动异常=================");
            e.printStackTrace();
        } finally {
            stop();
        }
    }

    private int port = 9106;
    private boolean running = false;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private static final Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
}
