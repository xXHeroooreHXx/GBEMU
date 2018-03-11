package com.gbemu;

public class SHARPLR35902 implements CPU {

	private SingleByteRegister A, B, C, D, E, F, H, L;
	private DoubleByteRegister AF, BC, DE, HL, SP, PC;
	
	public SHARPLR35902() {
		
	}
	
	public void reset(){
		
		Register[] registers = registers();
		for (int i = 0; i < registers.length; i++) {
			Register r = registers[i];			
			switch (i) {
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
	private Register[] registers(){
		return new Register[]{A, B, C, D, E, F, H, L, AF, BC, DE, HL, SP, PC};
	}
}
