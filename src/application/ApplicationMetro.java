package application;

import methods.Metro;

public class ApplicationMetro {

	protected String nome;
	protected int qBilhetes;
	protected static double valueTicket = 4.40;
	protected static double valorTotal;
	protected double money;
	protected double troco;

	public static void main(String[] args) {
		Metro e = new Metro();
		e.userName();
		e.cadBilhetes();
		e.valueTotal();
		e.getMoney();
		e.changeValue(valorTotal);
		e.showMessage();
	}
}
