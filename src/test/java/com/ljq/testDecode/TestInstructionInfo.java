package com.ljq.testDecode;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.InstructionBeanHelper;
import com.ljq.framework.codec.InstructionBeanInfo;
import org.junit.Test;

import java.util.HashMap;

public class TestInstructionInfo {
    @Test
    public void testGetClassInfo() {
        HashMap<Integer, InstructionBeanInfo<AbstractInstruction>> beanInfo = InstructionBeanHelper.getBeanInfo("com.ljq.protocol.basic");
        System.out.println(beanInfo);
    }
}
