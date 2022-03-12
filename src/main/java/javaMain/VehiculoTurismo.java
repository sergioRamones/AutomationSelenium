package javaMain;

public class VehiculoTurismo extends Vehiculo{

	private int numeroPuertas;
	
	/**
	 * @Description Constructor de VehiculoTurismo
	 * @author sramones
	 * @date 12/03/2022
	 * @param int, String, String String
	 */
	public VehiculoTurismo(int numeroPuertas, String matricula, String marca, String modelo) {
		super(matricula, marca, modelo);
		this.numeroPuertas=numeroPuertas;
	}
	
	/**
	 * @Description Constructor de VehiculoTurismo
	 * @author sramones
	 * @date 12/03/2022
	 * @param int, String, String String
	 */
	public VehiculoTurismo(String matricula, String marca, String modelo, int numeroPuertas) {
		super(matricula, marca, modelo);
		this.numeroPuertas=numeroPuertas;
	}
	
	/**
	 * @return the numeroPuertas
	 */
	public int getNumeroPuertas() {
		return numeroPuertas;
	}

	/**
	 * @param numeroPuertas the numeroPuertas to set
	 */
	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}
	
	
	@Override
	public String mostrarDatosDeVehiculo() {
		return "Matricula: "+getMatricula() + "\nMarca: " + getMarca() + "\nModelo: " + getModelo() + "\nNumero de puertas: " + getNumeroPuertas();
	}

}//end class
