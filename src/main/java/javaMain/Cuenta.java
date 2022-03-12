package javaMain;

public class Cuenta {
	
	private String nombre;
	private String numeroCuenta;
	private double tipoInteres;
	private double saldo;
	
	/**
	 * @Description Constructor sin parametros
	 * @author sramones
	 * @date 12/03/2022
	 * @param N/A
	 */
	public Cuenta() {
		
	}


	/**
	 * @Description Constructor con parametros
	 * @author sramones
	 * @date 12/03/2022
	 * @param String, String, double, double
	 */
	public Cuenta(String nombre, String numeroCuenta, double tipoInteres, double saldo) {
		this.nombre = nombre;
		this.numeroCuenta = numeroCuenta;
		this.tipoInteres = tipoInteres;
		this.saldo = saldo;
	}
	
	/**
	 * @Description Constructor recibiendo parametro tipo cuenta
	 * @author sramones
	 * @date 12/03/2022
	 * @param Objecto
	 */
	public Cuenta(Cuenta c) {
		nombre=c.nombre;
		numeroCuenta = c.numeroCuenta;
		tipoInteres = c.tipoInteres;
		saldo = c.saldo;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @return the numeroCuenta
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}


	/**
	 * @return the tipoInteres
	 */
	public double getTipoInteres() {
		return tipoInteres;
	}


	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @param numeroCuenta the numeroCuenta to set
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}


	/**
	 * @param tipoInteres the tipoInteres to set
	 */
	public void setTipoInteres(double tipoInteres) {
		this.tipoInteres = tipoInteres;
	}


	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	/**
	 * @Description deposito a la cuenta
	 * @author sramones
	 * @date 12/03/2022
	 * @param double
	 */
	public boolean ingreso(double n) {
		boolean ingresoCorrecto = true;
		
		if(n<0) {
			ingresoCorrecto=false;
		} else {
			saldo = saldo + n;
			//saldo+=n;
		}
		
		return ingresoCorrecto;
	}
	
	/**
	 * @Description retiro a la cuenta
	 * @author sramones
	 * @date 12/03/2022
	 * @param double
	 */
	public boolean retiro(double n) {
		boolean retiroCorrecto=true;
		
		if (n < 0) {
			retiroCorrecto = false;
			
		} else if (saldo >= n) {
			// saldo = saldo-n;
			saldo -= n;

		} else {
			retiroCorrecto = false;
		}
		
		return retiroCorrecto;
	}
	
	/**
	 * @Description retiro a la cuenta
	 * @author sramones
	 * @date 12/03/2022
	 * @param Cuenta, double
	 */
	public boolean trasferencia(Cuenta c, double n) {
		boolean correcto = true;
		
		if (n < 0) {
			correcto = false;
		} else if (saldo >= n) {
			retiro(n);
			c.ingreso(n);
		} else {
			correcto = false;
		}
		
		
		return correcto;
	}
	

}
