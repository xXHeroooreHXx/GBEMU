package com.gbemu;

public class DoubleByteRegister implements Register {
    private byte value;
    private SingleByteRegister a, b;
    public DoubleByteRegister(byte _value){
        value = _value;
    }
    public DoubleByteRegister(SingleByteRegister _a, SingleByteRegister _b){
        a = _a;
        b = _b;
    }
    public byte getValue(){
        return value;
    }
    public byte[] getAll(){
        return new byte[]{a.get(), b.get()};
    }
    public void set(byte _value){
        value = _value;
    }
}
