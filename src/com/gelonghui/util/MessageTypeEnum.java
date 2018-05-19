package com.gelonghui.util;

/**
 * Created by quanwenchao
 * 2018/5/18 15:51:48
 */
public enum MessageTypeEnum {
    // 领取任务消息
    ReceiveTaskEvent(1),
    // 用户触发任务消息
    UserEvent(2),
    // 自定义
    SelfDefine(-1);


    private int msgType;

    MessageTypeEnum(int msgType) {
        this.msgType = msgType;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public static boolean contains(int msgType) {
        for (MessageTypeEnum typeEnum : values()) {
            if (typeEnum.getMsgType() == msgType) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(MessageTypeEnum.UserEvent.getMsgType());
        System.out.println(MessageTypeEnum.ReceiveTaskEvent.getMsgType());
        System.out.println(MessageTypeEnum.SelfDefine.getMsgType());
    }
}