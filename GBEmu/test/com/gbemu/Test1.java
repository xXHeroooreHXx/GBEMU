package com.gbemu;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void nochangeBytes() {
		SingleByteRegister a = new SingleByteRegister((byte) 23);
        SingleByteRegister f = new SingleByteRegister((byte) 3);
        DoubleByteRegister af = new DoubleByteRegister(a, f);
        
        assertArrayEquals(new byte[]{a.get(), f.get()},  af.getAll());
	}
	
	@Test
	public void changeBytes(){
		SingleByteRegister a = new SingleByteRegister((byte) 23);
        SingleByteRegister f = new SingleByteRegister((byte) 3);
        DoubleByteRegister af = new DoubleByteRegister(a, f);
        a.set((byte) 5);
        f.set((byte) 10);
        
        assertArrayEquals(new byte[]{a.get(), f.get()},  af.getAll());
	}

}
