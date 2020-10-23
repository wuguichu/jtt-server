package com.ljq.testDecode;//package com.ssh.framework.test;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.MessageDecode;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TestDecode {
    //private static Logger logger = Logger.getLogger(TestDecode.class);

    @Test
    public void TestDecodeJtt() {
        //System.out.println("argv is null");
		/*if(args.length <= 0){
			System.out.println("argv is null");
			return;
		}
		System.out.println("test decode:" + args[0]);
		logger.debug("test decode:" + args[0]);
		logger.warn("test decode:" + args[0]);
		logger.info("test decode:" + args[0]);
		logger.error("test decode:" + args[0]);*/
        MessageDecode decoder = new MessageDecode("com.ljq.protocol.basic");
        byte[] res = {'R', 'P', 'T', 'P', 67, 125, 0, 0, 0, 1, 0, 0, 0, 0, 0, 10, 0, 0, 0, 3,
                0, 0, 0, 1, 20, 1, 9, 2, 8, 5, 0, 0, 9, 2, 8, 5, 0, 0, 0, 0, 'c', 's', 'i', 'd', 'c', 's', 'i', 'd'
                , 'c', 's', 'i', 'd', 'c', 's', 'i', 'd', 'c', 's', 'i', 'd', 'c', 's', 'i', 'd', 'c', 's', 'i', 'd', 'c', 's', 'i', 'd'};
        AbstractInstruction decode = decoder.decode(Unpooled.copiedBuffer(res));
        System.out.println(decode);
    }
}
