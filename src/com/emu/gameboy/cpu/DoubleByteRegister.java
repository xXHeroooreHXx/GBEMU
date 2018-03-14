package com.emu.gameboy.cpu;

import com.emu.Register;

public class DoubleByteRegister implements Register {
    private short value;
    private SingleByteRegister a, b;
    public DoubleByteRegister(byte _value){
        value = _value;
    }
    public DoubleByteRegister(SingleByteRegister _a, SingleByteRegister _b){
        a = _a;
        b = _b;
    }
    public short getValue(){
        return value;
    }
    public byte[] getAll(){
        return new byte[]{a.get(), b.get()};
    }
    public void set(short _value){
        value = _value;
    }
}
