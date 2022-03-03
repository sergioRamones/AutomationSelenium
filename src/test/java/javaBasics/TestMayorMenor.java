package javaBasics;

import org.testng.annotations.Test;

import javaMain.MayorMenor;

public class TestMayorMenor {
	
	MayorMenor obj;
			
	
	@Test
	public void probarMayorMenor() {
		obj = new MayorMenor(100,200);
		System.out.println(obj.getNum1());
		System.out.println(obj.getNum2());
		
		obj.calcularNumeroMayorMenor(100,200);
		obj.calcularNumeroMayorMenor(500,700);
		obj.calcularNumeroMayorMenor(400,400);
		
		obj.pedirNumerosIguales();
		
	}

}
