package com.ljq.protocol.basic;

public interface BasicId {
    int CENTER_RESPONSE = 0x0001;
    int TERMINAL_RESPONSE = 0x0002;
    int TERMINAL_AUTH = 0x0101;
    int TERMINAL_AUTH_RESP = 0x0102;
    int TERMINAL_ONLINE = 0x0103;
    int TERMINAL_ONLINE_RESP = 0x0104;
    int TERMINAL_HEARTBEAT = 0x0107;
    int CENTER_HEARTBEAT = 0x0108;
    int VEHICLE_DEVICE_INFO = 0x1001;
    int POWERON_SELF_CHECK_INFO = 0x1002;
    int TERMINAL_STATUS_CHANGE = 0x1003;
    int REAL_TIME_TRACK = 0x1004;
    int REAL_TIME_TRACK_REPORT = 0x1005;
    int UPGRADE = 0x100a;
    int UPGRADE_STATUS = 0x100b;
}
