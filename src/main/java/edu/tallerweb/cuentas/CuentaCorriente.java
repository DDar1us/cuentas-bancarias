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
	private Double cuenta=0.0;
	private Double descubiertoTotal=0.0;
	private Double Descubierto=0.0;
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
		if(monto<0.0){
			throw new CuentaBancariaException(null);
		}
		if(this.Descubierto>0.0){
			if(monto<this.Descubierto){
				this.Descubierto=this.Descubierto-monto;
			}
			else
			{
				this.cuenta=monto-this.Descubierto;
				this.Descubierto=0.0;
			}
		}
		if(this.Descubierto==0.0){
			this.cuenta=monto+this.cuenta;
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
		if(monto<0.0){
			throw new CuentaBancariaException(null);
		}
		if(monto>this.cuenta){		
			this.Descubierto=monto-this.cuenta;
			if(this.descubiertoTotal<this.Descubierto||((this.Descubierto/20.0)+this.Descubierto)>this.descubiertoTotal){
				this.Descubierto=0.0;
				throw new CuentaBancariaException(null);
			}
			else{
				this.Descubierto=this.Descubierto+(this.Descubierto/20.0);
			}
			this.cuenta=0.0;
		}
		else
		{	
		this.cuenta=this.cuenta-monto;
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
