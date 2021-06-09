package practicaEntornos;

public class RPN {
	public void pushPila(double nuevo_dato) {
		NodoPila nuevo_nodo = new NodoPila(nuevo_dato, arriba);
		arriba = nuevo_nodo;
	}
	public double popPila( ) {
		double dato_arriba = arriba.dato;
		arriba = arriba.abajo;
		return dato_arriba;
	}
	public RPN(String commando) {
		arriba = null;
		this.commando = commando;
	}
	public double resultado( ) {
		double a, b;
		int j;
		for(int i = 0; i < commando.length( ); i++) {
			// si es un digito
			if(Character.isDigit(commando.charAt(i))) {
				double numero;
				// obtener un string a partir del numero
				String temp = "";
				for(j = 0; (j < 100) && (Character.isDigit(
						commando.charAt(i)) || (commando.charAt(i) == '.')); j++, i++) {
					temp = temp + String.valueOf(commando.
							charAt(i));
				}
				// convertir a double y añadir a la pila
				numero = Double.parseDouble(temp);
				pushPila(numero);
			} else if(commando.charAt(i) == '+') {
				suma();
			} else if(commando.charAt(i) == '-') {
				resta();
			} else if(commando.charAt(i) == '*') {
				producto();
			} else if(commando.charAt(i) == '/') {
				division();
			}
			else if(commando.charAt(i) == '^') {
				potencia();
			}
			else if(commando.charAt(i) == '%') {
				residuo();
			} else if(commando.charAt(i) != ' ') {
				throw new IllegalArgumentException( );
			}
		}
		double val = popPila( );
		if(arriba != null) {
			throw new IllegalArgumentException( );
		}
		return val;
	}
	public void residuo() {
		double a;
		double b;
		b = popPila( );
		a = popPila( );
		pushPila(a%b);
	}
	public void potencia() {
		double a;
		double b;
		b = popPila( );
		a = popPila( );
		pushPila(Math.pow(a, b));
	}
	public void division() {
		double a;
		double b;
		b = popPila( );
		a = popPila( );
		pushPila(a / b);
	}
	public void producto() {
		double a;
		double b;
		b = popPila( );
		a = popPila( );
		pushPila(a * b);
	}
	public void resta() {
		double a;
		double b;
		b = popPila( );
		a = popPila( );
		pushPila(a - b);
	}
	public void suma() {
		double a;
		double b;
		b = popPila( );
		a = popPila( );
		pushPila(a + b);
	}
	private String commando;
	private NodoPila arriba;
}