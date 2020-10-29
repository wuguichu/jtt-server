package com.ljq.framework.fields;

import com.ljq.framework.codec.CommonDefine;
import com.ljq.protocol.basic.attribute.*;
import io.netty.buffer.ByteBuf;

public class BaseStatusField extends AbstractField<BaseStatus> {

    @Override
    public BaseStatus getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < 4) {
            return null;
        }
		int index = buf.readerIndex();
        long statusCount = buf.getUnsignedIntLE(index);
		index += 4;

		BaseStatus baseStatus = new BaseStatus();
		BaseStatusStorage storage = null;
		BaseStatusChannel channel = null;
		BaseStatusRecord record = null;
		BaseStatusPeripheral peripheral = null;
		int storageStatusIndex = 0;
		int recordStatusIndex = 0;
		int channelStatusIndex = 0;
		int peripheralStatusIndex = 0;

		while(statusCount-- > 0){
			if (buf.readableBytes() < index - buf.readerIndex() + 8) {
           		break;
        	}
			long statusId = buf.getUnsignedIntLE(index);
			long length = buf.getUnsignedIntLE(index + 4);
			if (buf.readableBytes() < length + 8 + index - buf.readerIndex()) {
           		break;
        	}
			index += 8;

			switch((int)statusId){
				case BaseStatusId.GPS:
					BaseStatusGps gps = new BaseStatusGps();
					gps.setGpsStatus(buf.getUnsignedByte(index));
					baseStatus.setGps(gps);
					break;

				case BaseStatusId.STORAGE:
					if (storage == null)
						storage = new BaseStatusStorage();
					short[] status = storage.getStatus();
					status[storageStatusIndex] = buf.getUnsignedByte(index);
					storage.setStatus(status);
					long[] totalCapacity = storage.getTotalCapacity();
					totalCapacity[storageStatusIndex] = buf.getUnsignedInt(index + 1);
					storage.setTotalCapacity(totalCapacity);
					String[] serial = storage.getSerial();
					serial[storageStatusIndex++] = buf.toString(index + 5, 20, CommonDefine.codecCharset);
					storage.setSerial(serial);
					break;

				case BaseStatusId.PARTITION:
					BaseStatusPartition partition = new BaseStatusPartition();
					partition.setUdiskStatus(buf.getUnsignedByte(index));
					partition.setUmmcStatus(buf.getUnsignedByte(index + 1));
					baseStatus.setPartition(partition);
					break;

				case BaseStatusId.CHANNEL:
					if (channel == null)
						channel = new BaseStatusChannel();
					short[] channelStatus = channel.getChannelStatus();
					channelStatus[channelStatusIndex++] = buf.getUnsignedByte(index);
					channel.setChannelStatus(channelStatus);
					break;

				case BaseStatusId.RECORD:
					if (record == null)
						record = new BaseStatusRecord();
					short[] recordStatus = record.getRecordStatus();
					recordStatus[recordStatusIndex++] = buf.getUnsignedByte(index);
					record.setRecordStatus(recordStatus);
					break;

				case BaseStatusId.WIRELESS:
					BaseStatusWireless wireless = new BaseStatusWireless();
					wireless.setType(buf.getUnsignedByte(index));
					wireless.setSignal(buf.getByte(index + 1));
					wireless.setMode(buf.getUnsignedByte(index + 2));
					wireless.setMac(buf.toString(index + 3, 20, CommonDefine.codecCharset));
					wireless.setIp(buf.toString(index + 23, 20, CommonDefine.codecCharset));
					baseStatus.setWireless(wireless);
					break;

				case BaseStatusId.WIFI:
					BaseStatusWifi wifi = new BaseStatusWifi();
					wifi.setModule(buf.getUnsignedByte(index));
					wifi.setSingel(buf.getShortLE(index + 1));
					wifi.setFeatures(buf.getUnsignedByte(index + 3));
					wifi.setMode(buf.getUnsignedByte(index + 4));
					baseStatus.setWifi(wifi);
					break;

				case BaseStatusId.PERIPHERAL:
					if (peripheral == null)
						peripheral = new BaseStatusPeripheral();
					short[] type = peripheral.getType();
					type[peripheralStatusIndex] = buf.getUnsignedByte(index);
					peripheral.setType(type);
					short[] stat = peripheral.getStat();
					stat[peripheralStatusIndex] = buf.getUnsignedByte(index + 1);
					peripheral.setStat(stat);
					long nameLength = buf.getUnsignedIntLE(index + 2);
					String[] name = peripheral.getName();
					name[peripheralStatusIndex++] = buf.toString(index + 3, (int)nameLength, CommonDefine.codecCharset);
					peripheral.setName(name);
					break;

				case BaseStatusId.GESENSOR:
					BaseStatusGsensor gsensor = new BaseStatusGsensor();
					gsensor.setGsensorStatus(buf.getUnsignedByte(index));
					baseStatus.setGsensor(gsensor);
					break;

				case BaseStatusId.VOLTAGE:
					BaseStatusVoltage voltage = new BaseStatusVoltage();
					voltage.setVoltageStatus(buf.getUnsignedShortLE(index));
					voltage.setAccStatus(buf.getUnsignedByte(index + 3));
					baseStatus.setVoltage(voltage);
					break;

				case BaseStatusId.AI_AUTHORIZATION:
					BaseStatusAiAuthorization aiAuthorization = new BaseStatusAiAuthorization();
					aiAuthorization.setDmsAuthStatus(buf.getUnsignedByte(index));
					aiAuthorization.setAdasAuthStatus(buf.getUnsignedByte(index + 1));
					aiAuthorization.setBsdAuthStatus(buf.getUnsignedByte(index + 2));
					baseStatus.setAiAuthorization(aiAuthorization);
					break;

				case BaseStatusId.TEMPERATURE:
					BaseStatusTemperature temperature = new BaseStatusTemperature();
					temperature.setInsideTemperature(buf.getShortLE(index));
					temperature.setOutsideTemperature(buf.getShortLE(index + 2));
					baseStatus.setTemperature(temperature);
					break;

				default:
					System.out.println("error id: " + (int)statusId + "  id: " + (int)statusId);
					return baseStatus;
			}

			index += length;
		}

		baseStatus.setStorage(storage);
		baseStatus.setChannel(channel);
		baseStatus.setRecord(record);
		baseStatus.setPeripheral(peripheral);
		
		buf.skipBytes(index - buf.readerIndex());

        return baseStatus;
    }

    @Override
    public void getByteArray(Object type, ByteBuf buf) {
        if (!(type instanceof String) || buf == null) {
        }
    }
}
