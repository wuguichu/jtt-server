package com.ljq.temp;

import org.junit.Test;

import java.util.Arrays;

public class TempTest {
    @Test
    public void test() {
        short[] channelStatus = new short[8];
        channelStatus[0] = 58;
        channelStatus[1] = 419;
        channelStatus[2] = 5;
        channelStatus[3] = 5898;
        channelStatus[4] = 5819;
        channelStatus[5] = 581;

        String channelString = Arrays.toString(channelStatus);

        System.out.println(channelString);
        System.out.println(channelString.toCharArray());
    }
}
