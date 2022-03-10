package javaMain;

public class Vehiculo {
	
	private String matricula;
	private String marca;
	private String modelo;
	
	/**
	 * @Description Constructor de Vehiculo
	 * @author sramones
	 * @date 09/03/2022
	 * @param String, String String
	 */
	public Vehiculo(String matricula, String marca, String modelo) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	/**
	 * @Description Constructor de Vehiculo
	 * @author sramones
	 * @date 09/03/2022
	 * @param String, String String
	 */
	public String mostrarDatosDeVehiculo() {
		return "Matricula :" + getMatricula()+ "\nMarca : " +getMarca() + "\nModelo: " + getModelo();
	}
	
	
	
	
	
	
}
