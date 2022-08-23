package tp2;

import javax.swing.*;

class Tp2 {

	public static void main(String[] args) {
		int dado1, dado2, sumaDado, menu, paloGeneral, carta, paloOro = 0, paloBasto = 0, paloEspada = 0, paloCopa = 0,
				pato, totPato = 0;
		double apuesta;
		String jugar;
		do {
			
		JOptionPane.showMessageDialog(null, "Juegos callejeros con apuestas","Juegos",JOptionPane.DEFAULT_OPTION,new ImageIcon(Tp2.class.getResource("/img/juegos.gif")));
		menu = Integer.parseInt(
				JOptionPane.showInputDialog("Elige un juego\n0-Tirar 2 dados\n1-Mini envido\n2-Tiro al pato,"));
		if (menu == 0) {
			apuesta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese su apuesta"));
			JOptionPane.showMessageDialog(null, "Dos dados\n-Se tira dos dados si su suma da 7 u 11 gana","Dados",JOptionPane.DEFAULT_OPTION,new ImageIcon(Tp2.class.getResource("/img/dados.gif")));
			dado1 = (int) (Math.random() * 6 + 1);
			dado2 = (int) (Math.random() * 6 + 1);
			sumaDado = dado1 + dado2;
			if (sumaDado == 7 || sumaDado == 11) {
				System.out.println(
						"Primer dado " + dado1 + " Segundo dado " + dado2 + " Suma de sus dos dados es: " + sumaDado);
				JOptionPane.showMessageDialog(null,
						"Primer dado " + dado1 + " Segundo dado " + dado2 + " Suma de sus dos dados es: " + sumaDado);
				apuesta = apuesta * 2;
				JOptionPane.showMessageDialog(null, "Usted gano su apuesta se duplica " + apuesta);
			} else {
				System.out.println(
						"Primer dado " + dado1 + " Segundo dado " + dado2 + " Suma de sus dos dados es: " + sumaDado);
				JOptionPane.showMessageDialog(null, "Usted perdio todo");
			}
		} else if (menu == 1) {
			apuesta = 0;
			apuesta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese su apuesta"));
			JOptionPane.showMessageDialog(null,
					"Mini envido\n-Son 3 cartas, si dos son del mismo palo gana, si no pierde");

			for (int i = 0; i < 3; i++) {
				carta = (int) (Math.random() * 12 + 1);
				paloGeneral = (int) (Math.random() * 4);
				// 0 -basto, 1 - copa 2- oro 3 -espada
				if (paloGeneral == 0) {
					JOptionPane.showMessageDialog(null, "Te toco un  " + carta + " de basto" , "Carta basto", JOptionPane.DEFAULT_OPTION, 
							new ImageIcon(Tp2.class.getResource ("/img/basto" + carta + ".jpg")));
					paloBasto++;
				} else if (paloGeneral == 1) {
					JOptionPane.showMessageDialog(null, "Te toco un  " + carta + " de copa" , "Carta copa", JOptionPane.DEFAULT_OPTION, 
							new ImageIcon(Tp2.class.getResource ("/img/copa" + carta + ".jpg")));
					paloCopa++;
				} else if (paloGeneral == 2) {
					JOptionPane.showMessageDialog(null, "Te toco un  " + carta + " de oro" , "Carta oro", JOptionPane.DEFAULT_OPTION, 
							new ImageIcon(Tp2.class.getResource ("/img/oro" + carta + ".jpg")));
					paloOro++;
				} else if (paloGeneral == 3) {
					JOptionPane.showMessageDialog(null, "Te toco un  " + carta + " de espada" , "Carta espada", JOptionPane.DEFAULT_OPTION, 
							new ImageIcon(Tp2.class.getResource ("/img/espada" + carta + ".jpg")));
					paloEspada++;
				} else {
					JOptionPane.showMessageDialog(null, "Hubo un error");
				}
			}
			if (paloOro >= 2 || paloCopa >= 2 || paloBasto >= 2 || paloEspada >= 2) {
				apuesta = apuesta * 2;
				JOptionPane.showMessageDialog(null, "Usted gano su apuesta se duplica " + apuesta);
			} else {
				apuesta = 0;
				JOptionPane.showMessageDialog(null, "Usted perdio todo su monto es de  " + apuesta);
			}
		} else if (menu == 2) {
			JOptionPane.showMessageDialog(null, "Tiro al pato\n-6 patos (3 patos puntaje 0, dos con 5 puntos, otro con "
					+ "10), tiene 3 disparos, si " + "tiene mas de 20 puntos gana ");
			apuesta = 0;
			apuesta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese su apuesta"));
			for (int i = 0; i < 3; i++) { // Tiene 3 tiros
				pato =(int)(Math.random()*6); // 6 patos random
				if (pato==0 || pato==1 || pato==2) {//Patos con valor 0
					JOptionPane.showMessageDialog(null, "Le diste al patito de valor 0","Pato-0",JOptionPane.DEFAULT_OPTION,new ImageIcon(Tp2.class.getResource("/img/pato-0.png")));
					totPato=totPato+0;
				} else if(pato==3 || pato==4) {//Patos con valor 5
					JOptionPane.showMessageDialog(null, "Le diste al patito de valor 5","Pato-5",JOptionPane.DEFAULT_OPTION,new ImageIcon(Tp2.class.getResource("/img/pato-5.png")));
					totPato=totPato+5;
				}else{//Pato con valor 10
					JOptionPane.showMessageDialog(null, "Le diste al patito de valor 10","Pato-10",JOptionPane.DEFAULT_OPTION,new ImageIcon(Tp2.class.getResource("/img/pato-10.png")));
					totPato=totPato+10;
				}
				System.out.println(pato);//Consola patos
			}
			if (totPato>=20) {
				apuesta = apuesta * 2;
				JOptionPane.showMessageDialog(null, "Usted gano su apuesta se duplica " + apuesta);
			} else {
				apuesta = 0;
				JOptionPane.showMessageDialog(null, "Usted perdio todo su monto es de  " + apuesta);
			}
		}
		jugar=JOptionPane.showInputDialog("Quiere volver a jugar?" + "\n SI - NO");
		} while (jugar.equalsIgnoreCase("SI"));
	}
		
}
