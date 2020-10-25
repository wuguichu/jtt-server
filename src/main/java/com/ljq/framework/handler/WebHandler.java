package com.ljq.framework.handler;

import com.ljq.framework.codec.AbstractInstruction;

public interface WebHandler {
    <T extends AbstractInstruction> T handleWebRequest(Object obj);
}