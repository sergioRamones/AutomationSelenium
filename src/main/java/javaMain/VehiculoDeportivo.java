package javaMain;

public class VehiculoDeportivo extends Vehiculo {

	private int clilindrada;
	
	public VehiculoDeportivo(String matricula, String marca, String modelo, int cilindrada) {
		super(matricula, marca, modelo);
		this.clilindrada=cilindrada;
	}

	/**
	 * @return the clilindrada
	 */
	public int getClilindrada() {
		return clilindrada;
	}

	/**
	 * @param clilindrada the clilindrada to set
	 */
	public void setClilindrada(int clilindrada) {
		this.clilindrada = clilindrada;
	}
	
	
	
	
	@Override
	public String mostrarDatosDeVehiculo() {
		return "Matricula :" + getMatricula()+ "\nMarca : " +getMarca() + "\nModelo: " + getModelo() + "\nCilindrada: " + getClilindrada();
	}

}
