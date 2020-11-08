package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.fields.FieldType;

@Instruction(BasicId.SHELL_COMMAND)
public class ShellCommand extends AbstractInstruction {
    @Field(index = 0, type = FieldType.INT32STRING)
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "ShellCommand{" +
                "command='" + command + '\'' +
                ", header=" + header +
                '}';
    }

    private String command;
}
