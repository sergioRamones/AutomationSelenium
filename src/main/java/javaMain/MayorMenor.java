package javaMain;

import javax.swing.JOptionPane;

import org.testng.Reporter;

public class MayorMenor {

	private double num1, num2;

	public MayorMenor() {

	}

	public MayorMenor(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;

	}

	/**
	 * @return the num1
	 */
	public double getNum1() {
		return num1;
	}

	/**
	 * @param num1 the num1 to set
	 */
	public void setNum1(double num1) {
		this.num1 = num1;
	}

	/**
	 * @return the num2
	 */
	public double getNum2() {
		return num2;
	}

	/**
	 * @param num2 the num2 to set
	 */
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	
	
	/**
	 * @Desription Dado dos numeros validar cual es mayor o si son iguales
	 * @author sramones
	 * @param double, double
	 * @return N/A
	 * @exception N/A
	 * **/
	public void calcularNumeroMayorMenor(double num1, double num2) {
		
		if(num1>num2) {
				Reporter.log("El numero1:[ "+ num1+" ] es mayor que el numero2: [ "+ num2+" ] ",true);
			} else if(num2>num1) {
				Reporter.log("El numero2:[ "+ num2+" ] es mayor que el numero1: [ "+ num1+" ] ",true);
			}else {
				Reporter.log("El numero1:[ "+ num1+" ] es igual que el numero: [ "+ num2+" ] ",true);
			}
	}//end calcularNumeroMayorOMenor
	
	/**
	 * @Desription pedir por telcado seguir pidiendolos hasta que sean iguales
	 * @author sramones
	 * @param double, double
	 * @return N/A
	 * @exception N/A
	 * **/
	public void pedirNumerosIguales() {
		
		String num1 = JOptionPane.showInputDialog(null, "Ingresa un numero");
		String num2 = JOptionPane.showInputDialog(null, "Ingresa un numero");
		
		setNum1(Double.parseDouble(num1));
		setNum2(Double.parseDouble(num2));
		
		while (this.num1 != this.num2) {
			JOptionPane.showMessageDialog(null, "Los nuemeros No son iguales ingresalos nuevamente");
			num1 = JOptionPane.showInputDialog(null, "Ingresa un numero");
			num2 = JOptionPane.showInputDialog(null, "Ingresa un numero");

			setNum1(Double.parseDouble(num1));
			setNum2(Double.parseDouble(num2));
			
			
		}
		
		calcularNumeroMayorMenor(this.num1, this.num2);

	}

}
