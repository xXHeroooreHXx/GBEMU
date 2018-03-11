package com.gbemu;

public class SingleByteRegister implements Register {
    private byte value;
    public SingleByteRegister(byte _value){
        value = _value;
    }
    public byte get(){
        return value;
    }
    public void set(byte _value){
        value = _value;
    }
}
