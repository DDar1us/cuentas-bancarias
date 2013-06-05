package edu.tallerweb.cuentas;

/**
 * Es el tipo de cuenta más simple, ya que se rige por la premisa
 * de que en tanto y en cuanto se tenga tanto o más dinero en
 * cuenta del que se quiere extraer, la operación se debe efectuar
 * correctamente.
 */
public class CuentaSueldo {
	private Double cuenta=0.0;
	/**
	 * No hay reglas adicionales para el depósito
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) {
		this.cuenta=monto+cuenta;
	}

	/**
	 * No hay reglas adicionales para la extracción
	 * @param monto a extraer
	 */
	public void extraer(final Double monto) {
		if(monto>cuenta){
			throw new CuentaBancariaException(null);
		}
		this.cuenta=cuenta-monto;
	}

	/**
	 * Permite saber el cuenta de la cuenta
	 * @return el cuenta de la cuenta
	 */
	public Double getSaldo() {
		return this.cuenta;
	}

}
