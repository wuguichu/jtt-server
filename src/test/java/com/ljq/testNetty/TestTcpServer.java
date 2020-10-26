package com.ljq.testNetty;

import com.ljq.framework.netty.TcpServer;

import java.util.Scanner;

public class TestTcpServer {
    //    @Test
    public void testTcpServer() {
        // 52505450000f000000000000000000000000000000000108010208010208000052505450
        // 52505450001000000000000c000000010000000000000108010208010208000052505450
        TcpServer tcpServer = new TcpServer();
        tcpServer.setPort(9106);

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
