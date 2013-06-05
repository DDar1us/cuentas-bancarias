package edu.tallerweb.cuentas;

/**
 * La más compleja de las cuentas, ésta permite establecer una
 * cantidad de dinero a girar en descubierto. Es por ello que
 * cada vez que se desee extraer dinero, no sólo se considera
 * el que se posee, sino el límite adicional que el banco
 * estará brindando.
 *
 * Por supuesto esto no es gratis, ya que el banco nos cobrará
 * un 5% como comisión sobre todo el monto en descubierto
 * consumido en la operación.
 *
 * Por ejemplo, si tuviéramos $ 100 en la cuenta, y quisiéramos
 * retirar $ 200 (con un descubierto de $ 150), podremos hacerlo.
 * Pasaremos a deberle al banco $ 105 en total: los $ 100 que
 * nos cubrió, más el 5% adicional sobre el descubierto otorgado.
 */
public class CuentaCorriente {
	private Double cuenta;
	private Double descubiertoTotal;
	private Double Descubierto;
	/**
	 * Toda cuenta corriente se inicia con un límite total
	 * para el descubierto.
	 * @param descubiertoTotal
	 */
	public CuentaCorriente(final Double descubiertoTotal) {
		this.descubiertoTotal=descubiertoTotal;
	}
	
	/**
	 * Todo depósito deberá cubrir primero el descubierto,
	 * si lo hubiera, y luego contar para el cuenta de la
	 * cuenta.
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) {
		this.cuenta=monto+cuenta;
		if(this.cuenta<this.descubiertoTotal){
			System.out.println("El deposito es insuficiente al descubierto");
			this.cuenta=cuenta-monto;
		}
	}

	/**
	 * Se cobrará el 5% de comisión sobre el monto girado
	 * en descubierto.
	 * Por supuesto, no puede extraerse más que el total
	 * de la cuenta, más el descubierto (comisión incluída)
	 * @param monto a extraer
	 */
	public void extraer(final Double monto) {
		if(monto>this.cuenta){
			this.Descubierto=monto-cuenta;
			if(this.descubiertoTotal<this.Descubierto){
				this.Descubierto=this.Descubierto-this.Descubierto;
				System.out.println("El descubierto excede el limite");
				throw new CuentaBancariaException(null);
			}
			this.Descubierto=this.Descubierto+((this.Descubierto/20.0)*100);
			this.cuenta=cuenta-cuenta;
		}
		else{	
		this.cuenta=cuenta-monto;
		}
	}

	/**
	 * Permite saber el cuenta de la cuenta
	 * @return el cuenta de la cuenta
	 */
	public Double getSaldo() {
		return this.cuenta;
	}
	
	/**
	 * Permite saber el cuenta en descubierto
	 * @return el descubierto de la cuenta
	 */
	public Double getDescubierto() {
		return this.Descubierto;
	}

}
