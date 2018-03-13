package com.emu.gameboy.cpu;

import com.emu.Register;

public class FlagByteRegister implements Register {
	
	private boolean Z;
	private boolean N;
	private boolean H;
	private boolean C;
	
	public FlagByteRegister(byte _value) {
		
	}

	public boolean isZ() {
		return Z;
	}

	public boolean isN() {
		return N;
	}

	public boolean isH() {
		return H;
	}

	public boolean isC() {
		return C;
	}

	public void setZ(boolean z) {
		Z = z;
	}

	public void setN(boolean n) {
		N = n;
	}

	public void setH(boolean h) {
		H = h;
	}

	public void setC(boolean c) {
		C = c;
	}
	
	
}
