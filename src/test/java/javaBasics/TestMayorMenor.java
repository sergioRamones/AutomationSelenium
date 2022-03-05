package javaBasics;

import org.testng.annotations.Test;

import javaMain.MayorMenor;



public class TestMayorMenor {
	
	
			
	
	@Test
	public void probarMayorMenor() {
		
		
		MayorMenor obj = new MayorMenor(100,200);
		
		MayorMenor obj2 = new MayorMenor();
		
	
		
		obj2.pedirNumerosIguales();
		
		
//		System.out.println(obj.getNum1());
//		System.out.println(obj.getNum2());
//		
//		obj.calcularNumeroMayorMenor(100,200);
//		obj.calcularNumeroMayorMenor(700,500);
//		obj.calcularNumeroMayorMenor(400,400);
//		
//		obj.pedirNumerosIguales();
		
	}

}
