/*
 * cpu.h
 * 
 * Copyright 2018 pablo ramos muras <pablorm@pablo-pc>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
typedef struct reg{
	struct{
		union{
			struct{;
				unsigned char F; //Registros de 8bits
				unsigned char A;
			};
			unsigned short AF; //Registro de 8+8bits (16bits)
		};
	};
	struct{
		union{
			struct{;
				unsigned char B;
				unsigned char C;
			};
			unsigned short BC;
		};
	};
	struct{
		union{
			struct{;
				unsigned char D;
				unsigned char E;
			};
			unsigned short DE;
		};
	};
	struct{
		union{
			struct{;
				unsigned char H;
				unsigned char L;
			};
			unsigned short HL;
		};
	};
	unsigned short PC; //Program counter
	unsigned short SP; //Stack pointer
}reg;

typedef struct ins{
	char *instructionName;
	unsigned char operandLength;
	void *execute;
}ins;



class Cpu{
	//Codificacion de los registros.
	public:
	reg Registros;
	ins instrucciones[256];

	
};
