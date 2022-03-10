package javaBasics;

import org.testng.annotations.Test;

import javaMain.Vehiculo;
import javaMain.VehiculoDeportivo;

public class TestVehiculo {
	
	
	
	@Test
	public void datosDeVehiculo() {
		Vehiculo misVehiculos = new Vehiculo("GST234","FORD","2020");
		
		System.out.println(misVehiculos.mostrarDatosDeVehiculo());
		String varible = "";
		misVehiculos.setModelo(varible);
		System.out.println(misVehiculos.mostrarDatosDeVehiculo());
		
		misVehiculos = new VehiculoDeportivo("HTY-23-G","Mazda","2021",4);
		System.out.println(misVehiculos.mostrarDatosDeVehiculo());
		
		VehiculoDeportivo coche = new VehiculoDeportivo("KKHL-G","BMW","1980",8);
		System.out.println(coche.mostrarDatosDeVehiculo());
	
		
	}
	

}
