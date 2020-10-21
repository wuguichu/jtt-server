package com.ljq.protocol.basic;

public interface BasicId {
    int CENTER_RESPONSE = 0x0001;
    int TERMINAL_RESPONSE = 0x0002;
    int TERMINAL_AUTH = 0x0101;
    int TERMINAL_HEARTBEAT = 0x0107;
    int CENTER_HEARTBEAT = 0x0108;
    int VEHICLE_DEVICE_INFO = 0x1001;
    int POWERON_SELF_CHECK_INFO = 0x1002;
}
