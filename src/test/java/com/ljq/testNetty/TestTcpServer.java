package com.ljq.testNetty;

import com.ljq.framework.netty.TcpServer;
import org.junit.Test;

import java.util.Scanner;

public class TestTcpServer {
    @Test
    public void testTcpServer() {
        TcpServer tcpServer = new TcpServer();
        //tcpServer.setPort(9106);

        tcpServer.start();

        System.out.println("按q退出");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            if ("q".equals(next)) {
                System.out.println("准备退出");
                break;
            } else {
                System.out.println("按q退出");
            }
        }
        System.out.println("准备退出");

        tcpServer.stop();
    }
}
