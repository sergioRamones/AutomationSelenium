package javaBasics;

import org.testng.annotations.Test;

import javaMain.Vehiculo;
import javaMain.VehiculoDeportivo;
import javaMain.VehiculoFurgoneta;
import javaMain.VehiculoTurismo;

public class TestVehiculo {
	
	
	@Test
	public void datosVehiculo() {
		Vehiculo misVehiculos = new Vehiculo("GSTW-2323","FORD","2020");	
		
		System.out.println(misVehiculos.mostrarDatosDeVehiculo());
		misVehiculos.setMatricula("GHZ-80-A");
		System.out.println(misVehiculos.mostrarDatosDeVehiculo());
		
		misVehiculos = new VehiculoDeportivo("LAER-2354","Mazda","2022", 4);
		
		System.out.println(misVehiculos.mostrarDatosDeVehiculo());
		
		
		
		
		
		
		
	}//end datos
	
	
	@Test
	public void datosVehiculoEnArreglo() {
		Vehiculo misVehiculos[] = new Vehiculo[4];
		misVehiculos[0] = new Vehiculo("GJT-289","BMW","2021");
		misVehiculos[1] = new VehiculoDeportivo("LKC-674","Audi","2022",8);
		misVehiculos[2] = new VehiculoFurgoneta("OPR-5869","Mercedez benz","2019",500);
		misVehiculos[3] = new VehiculoTurismo(3,"WER-345","Ferrari","1980");
		
		
		
		for(Vehiculo coche: misVehiculos) {
			System.out.println(coche.mostrarDatosDeVehiculo());
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&666");
		}
		
	}

}//end class
