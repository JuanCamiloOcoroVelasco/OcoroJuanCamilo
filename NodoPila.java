package practicaEntornos;
/*
Este programa, RPN.java es una calculadora de notación inversa polaca que utiliza una pila.
Reverse Polish notation (RPN) Notación Polaca inversa, por ejemplo
la expresión: 4 * 5 - 7 / 2 % 3 nos da 1,5 respetando la prioridad de
los operadores en notación RPN seria: 4 5 * 7 2 / - 3 % (pues no podemos poner los paréntesis para alterar la prioridad)
 */
class NodoPila {
	public NodoPila(double dato, NodoPila abajo) {
		this.dato = dato;
		this.abajo = abajo;
	}
	public NodoPila abajo;
	public double dato;
}