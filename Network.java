package jeton;

import java.util.Vector;

public class Network {

	private static Vector<MyPC> computerList = new Vector<>(10);
	public static Token Jeton = new Token();
	public static MyPC currentPc = new MyPC();
	private static MyPC sourceComputer;

	public static MyPC getSourceComputer() {
		return sourceComputer;
	}

	public static void setSourceComputer(MyPC sourceComputer) {
		Network.sourceComputer = sourceComputer;
		Jeton.setsource(sourceComputer.getAdresaIpMyPC());
	}

	public static void afisare() {
		for (int i = 0; i < 10; i++) {
			System.out.println(computerList.elementAt(i));
		}
	}

	public void startApp() {
		Jeton = new Token();
		Jeton.setMessage(" Proba ");
		sourceComputer = null;
		for (int i = 0; i < 10; i++) {
			MyPC computer = new MyPC(null);
			computer.setIndexComputer((i + 1));
			computerList.add(computer);
		}

		for (int i = 0; i < 9; i++) {
			computerList.elementAt(i).setNext(computerList.elementAt(i + 1));
		}
		computerList.elementAt(9).setNext(computerList.elementAt(0));

		afisare();

		for (int i = 0; i < 10; i++) {
			computerList.get(i).start();
		}

	}

	public static void run() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int source = (int) (Math.random() * 10);
		sourceComputer = computerList.elementAt(source);
		currentPc = sourceComputer;
		while (true) {
			int destination = (int) (Math.random() * 10);
			System.out.println(destination);
			while (destination == source) {
				destination = (int) (Math.random() * 10);

			}
			MyPC destinationComputer = computerList.elementAt(destination);
			System.out.println("calculatorul sursa: " + sourceComputer + "destinatie: " + destinationComputer);

			while (destinationComputer.getAdresaIpMyPC() == sourceComputer.getAdresaIpMyPC()) {
				destination = (int) (Math.random() * 10);
				destinationComputer = computerList.elementAt(destination);
			}

			boolean ok = true;
			int interval = 10;
			while (ok == true) {

				if (Jeton.isrightDestination() == false
						&& currentPc.getAdresaIpMyPC() == sourceComputer.getAdresaIpMyPC() && Jeton.isFree() == true) {

					System.out.println(sourceComputer + " a preluat jetonul ");
					Jeton.setFree(false);
					currentPc = currentPc.getNext();
				} else if (Jeton.isrightDestination() == true
						&& currentPc.getAdresaIpMyPC() == sourceComputer.getAdresaIpMyPC() && Jeton.isFree() == false) {
					System.out.println("C " + currentPc.getIndexComputer());
					System.out.println(" Am ajuns inapoi la sursa ");
					Jeton.setFree(true);
					Jeton.setrightDestination(false);
					ok = false;
				} else if (currentPc.getAdresaIpMyPC() == destinationComputer.getAdresaIpMyPC()
						&& Jeton.isFree() == false) {
					Jeton.setrightDestination(true);
					System.out.println("C " + currentPc.getIndexComputer());
					currentPc = currentPc.getNext();
					computerList.elementAt(destination).setBuffer(Jeton.getMessage());
					System.out.println("Am ajuns la destinatie ");

				} else {
					System.out.println("C " + currentPc.getIndexComputer());
					System.out.println("Am mutat");
					currentPc = currentPc.getNext();

				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Jeton.setsource(sourceComputer.getAdresaIpMyPC());
			}
		}
	}
}
