public class MathExample {
	public static void main(String[] args) {
		/*
		Java mette a disposizione dell’utente alcune funzioni matematica, tramite la classe java.lang.Math,
		tali funzioni quindi, sono raggiungibile tramite la notazione:
		Math.metodo(valore);
		Nella maggior parte dei casi, esse ricevono uno o due double.
		Ecco un elenco di alcune delle funzioni della classe Math:

		Trigonometriche : sin(x), cos(x), tan(x);
		Valore assoluto : abs(x)
		Radice quadrata : sqrt(x)
		Esponenziale : exp(x)
		Logaritmo : log (x) – Logaritmo in base naturale
		Potenza : pow (x,y) – Calcola la potenza di x alla y
		Massimo : max(x,y) – ritona il massimo tra x e y
		Minimo : min(x,y) – ritorna il minimo tra x e y
		Arrotondamento : rounx (x) – ritorna l’intero più vicino

		Oltre ad esportare i metodi elencati in precendenza, la classe Math fornisce i valore approssimati di:
		e – Base dei numeri di nepero Math.E
		pi – Pigreco Math.PI

		Vediamo come utilizzarne questa classe.
		*/
		System.out.println("PI greco "+Math.PI);
		System.out.println("Numero di nepero "+Math.E);
		System.out.println("Il logaritmo di 10 in base naturale è "+Math.log(10));
		System.out.println("Arrotondamento di 5,21 : "+Math.round(5.16));
	}
}
