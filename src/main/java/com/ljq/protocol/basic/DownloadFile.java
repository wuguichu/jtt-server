package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.fields.FieldType;

@Instruction(BasicId.DOWNLOAD_FILE)
public class DownloadFile extends AbstractInstruction {
    @Field(index = 0, type = FieldType.FIXEDSTRING, length = 64)
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Field(index = 1, type = FieldType.FIXEDSTRING, length = 64)
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "DownloadFile{" +
                "fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", header=" + header +
                '}';
    }

    private String fileName;
    private String filePath;
}
