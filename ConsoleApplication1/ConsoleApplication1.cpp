// ConsoleApplication1.cpp: define el punto de entrada de la aplicación de consola.
//

#include "stdafx.h"
#include "Register.h"
#include <iostream>

using namespace std;

int main()
{
	Register *r = new ByteRegister();
	std::cout << (Register) r->get();
    return 0;
}

