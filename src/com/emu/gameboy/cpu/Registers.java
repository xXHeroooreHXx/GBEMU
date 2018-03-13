package com.emu.gameboy.cpu;

import com.emu.Register;

public class Registers {
	
	private SingleByteRegister A, B, C, D, E, F, H, L;
	private DoubleByteRegister AF, BC, DE, HL, SP, PC;
	
	public Registers() {
		Register[] registers = new Register[]{A, B, C, D, E, F, H, L, AF, BC, DE, HL, SP, PC};
		int i = 0;
		
		for (Register r : registers){
			switch (i++) {
				case 5:
					r = new FlagByteRegister((byte) 0);
					break;
				case 8:
					r = new DoubleByteRegister(A, F);
					break;
				case 9:
					r = new DoubleByteRegister(B, C);
					break;
				case 10: 
					r = new DoubleByteRegister(D, E);
					break;
				case 11:
					r = new DoubleByteRegister(H, L);
					break;
				case 12: case 13:
					r = new DoubleByteRegister((byte) 0);
					break;
				default:
					r = new SingleByteRegister((byte) 0);
			}
		}
	}

	public SingleByteRegister getA() {
		return A;
	}

	public SingleByteRegister getB() {
		return B;
	}

	public SingleByteRegister getC() {
		return C;
	}

	public SingleByteRegister getD() {
		return D;
	}

	public SingleByteRegister getE() {
		return E;
	}

	public SingleByteRegister getF() {
		return F;
	}

	public SingleByteRegister getH() {
		return H;
	}

	public SingleByteRegister getL() {
		return L;
	}

	public DoubleByteRegister getAF() {
		return AF;
	}

	public DoubleByteRegister getBC() {
		return BC;
	}

	public DoubleByteRegister getDE() {
		return DE;
	}

	public DoubleByteRegister getHL() {
		return HL;
	}

	public DoubleByteRegister getSP() {
		return SP;
	}

	public DoubleByteRegister getPC() {
		return PC;
	}

	public void setA(SingleByteRegister a) {
		A = a;
	}

	public void setB(SingleByteRegister b) {
		B = b;
	}

	public void setC(SingleByteRegister c) {
		C = c;
	}

	public void setD(SingleByteRegister d) {
		D = d;
	}

	public void setE(SingleByteRegister e) {
		E = e;
	}

	public void setF(SingleByteRegister f) {
		F = f;
	}

	public void setH(SingleByteRegister h) {
		H = h;
	}

	public void setL(SingleByteRegister l) {
		L = l;
	}

	public void setAF(DoubleByteRegister aF) {
		AF = aF;
	}

	public void setBC(DoubleByteRegister bC) {
		BC = bC;
	}

	public void setDE(DoubleByteRegister dE) {
		DE = dE;
	}

	public void setHL(DoubleByteRegister hL) {
		HL = hL;
	}

	public void setSP(DoubleByteRegister sP) {
		SP = sP;
	}

	public void setPC(DoubleByteRegister pC) {
		PC = pC;
	}
	
	
}
