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
				b = popPila( );
				a = popPila( );
				pushPila(a + b);
			} else if(commando.charAt(i) == '-') {
				b = popPila( );
				a = popPila( );
				pushPila(a - b);
			} else if(commando.charAt(i) == '*') {
				b = popPila( );
				a = popPila( );
				pushPila(a * b);
			} else if(commando.charAt(i) == '/') {
				b = popPila( );
				a = popPila( );
				pushPila(a / b);
			}
			else if(commando.charAt(i) == '^') {
				b = popPila( );
				a = popPila( );
				pushPila(Math.pow(a, b));}
			else if(commando.charAt(i) == '%') {
				b = popPila( );
				a = popPila( );
				pushPila(a%b);
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
	private String commando;
	private NodoPila arriba;
}