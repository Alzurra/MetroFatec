package methods;

import static java.lang.System.exit;

import java.util.Locale;

import javax.swing.JOptionPane;

import application.ApplicationMetro;

public class Metro extends ApplicationMetro {

	public void userName() {
		nome = JOptionPane.showInputDialog(null, "Digite o seu nome: ");
		validar(1);
		JOptionPane.showMessageDialog(null, "Nome: " + nome);
	}

	public void cadBilhetes() {
		Locale.setDefault(Locale.US);
		qBilhetes = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de bilhetes: "));
		validar(2);
		JOptionPane.showMessageDialog(null, "Bilhete(s): " + qBilhetes);
	}

	public void valueTotal() {
		Locale.setDefault(Locale.US);
		valorTotal = qBilhetes * valueTicket;
		JOptionPane.showMessageDialog(null, "Valor Total: R$" + String.format("%.2f", valorTotal));
	}

	public void getMoney() {
		Locale.setDefault(Locale.US);
		money = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor monetário: "));
		validar(3);
		JOptionPane.showMessageDialog(null, "Dinheiro R$:" + money);
	}

	public void changeValue(double valorTotal) {
		Locale.setDefault(Locale.US);
		JOptionPane.showMessageDialog(null, "\n\nINFORMAÇÕES SOBRE O USUÁRIO" 
		+ "\nNome: " + nome
		+ "\nQuantidade Bilhete(s): " + qBilhetes 
		+ "\nValor Total: R$" + String.format("%.2f", valorTotal));

		if (valorTotal == money) {
			troco = money - valorTotal;
			JOptionPane.showMessageDialog(null, "PODE PASSAR!");
		} else if (money < valorTotal) {
			JOptionPane.showMessageDialog(null, "VALOR INSUFICIENTE!");
		} else {
			Locale.setDefault(Locale.US);
			troco = money - valorTotal;
			JOptionPane.showMessageDialog(null, "VALOR DO TROCO: R$" 
			+ String.format("%.2f", troco));
		}
	}

	public void showMessage() {
		JOptionPane.showMessageDialog(null,
				"\n\nINFORMAÇÕES SOBRE O USUÁRIO" 
		+ "\nNome: " + nome 
		+ "\nQuantidade Bilhete(s): " + qBilhetes
	    + "\nValor Recebido: R$" + String.format("%.2f", money) 
	    + "\nValor Total: R$"
		+ String.format("%.2f", valorTotal) 
		+ "\nValor Troco: R$" + String.format("%.2f", troco));

		exit(0);
	}

	public void validar(int etapa) {
		switch (etapa) {
		// Nome
		case 1:
			while ("".equals(nome)) {
				nome = JOptionPane
						.showInputDialog("[O CAMPO NOME NÂO PODE FICAR VAZIO!!]\n " + "\nDigite o seu nome: ");
			}
			break;
		// Qauntidade Bilhetes
		case 2:
			while (qBilhetes < 0 || qBilhetes == 0) {
				qBilhetes = Integer.parseInt(
						JOptionPane.showInputDialog("[DADO INCOMPATÍVEL]\n\n" + "QUANTIDADE DEVE SER SUPERIOR A 0"));
			}
			break;
		// Dinheiro
		case 3:
			while (money == 0 || money < valorTotal) {
				money = Double.parseDouble(JOptionPane.showInputDialog(
						"[O VALOR INSERIDO DEVE SER IGUAL OU MAIOR QUE O VALOR DA COMPRA]\n\n" + "Valor Total: R$"
								+ String.format("%.2f", valorTotal) + "\n\nDigite o valor novamente: "));
			}
			break;
		default:
			break;
		}
	}
}
