package edu.tallerweb.cuentas;

/**
 * Similar a la CuentaSueldo, pero se pide que luego de la
 * quinta extracción de dinero se cobre un costo adicional
 * por extracción de $ 6
 */
public class CajaAhorros extends AbstractCuenta {
	private Double cuenta = 0.0;
	private Integer interes = 0;
	/**
	 * No hay reglas adicionales para el depósito
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) {
		if (monto < 0.0) {
			throw new CuentaBancariaException(null);
		}
		this.cuenta = monto + this.cuenta;
	}

	/**
	 * Se cobran $6 adicionales por cada extracción luego de
	 * la quinta.
	 * @param monto a extraer
	 */
	public void extraer(final Double monto) {
		if (monto < 0.0){
			throw new CuentaBancariaException(null);
		}
		if (monto > cuenta) {
			throw new CuentaBancariaException(null);
		}
		this.cuenta = this.cuenta - monto;
		this.interes++;
		if (this.interes > 5) {
			if ((this.cuenta - 6.0) < 0.0) {
				this.cuenta = this.cuenta + monto;
				throw new CuentaBancariaException(null);
			}
			this.cuenta = this.cuenta - 6.0;
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
