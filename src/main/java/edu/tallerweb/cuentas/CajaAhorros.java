package edu.tallerweb.cuentas;

/**
 * Similar a la CuentaSueldo, pero se pide que luego de la
 * quinta extracción de dinero se cobre un costo adicional
 * por extracción de $ 6
 */
public class CajaAhorros {
	private Double cuenta;
	private Integer Interes=0; 
	/**
	 * No hay reglas adicionales para el depósito
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) {
		this.cuenta=monto+cuenta;
	}

	/**
	 * Se cobran $6 adicionales por cada extracción luego de
	 * la quinta.
	 * @param monto a extraer
	 */
	public void extraer(final Double monto) {
		if(monto>cuenta){
			throw new CuentaBancariaException(null);
		}
		this.cuenta=cuenta-monto;
		this.Interes++;
		if(this.Interes>5){
			this.cuenta=cuenta-6;
		}
	}

	/**
	 * Permite saber el cuenta de la cuenta
	 * @return el cuenta de la cuenta
	 */
	public Double getSaldo() {
		return this.cuenta;
	}

}
