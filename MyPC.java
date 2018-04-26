package jeton;

public class MyPC extends Thread {

	private String buffer;
	private AdresaIp adresaIpMyPC;
	private MyPC next;
	int indexComputer;
	Token jeToken;

	public MyPC() {
		buffer = "default";
		adresaIpMyPC = new AdresaIp();
		next = null;
		indexComputer = -1;
		jeToken = null;
	}

	public MyPC(String buffer) {
		this.buffer = buffer;
		AdresaIp myAdresaIp = new AdresaIp();
		this.adresaIpMyPC = myAdresaIp;
	}

	public int getIndexComputer() {
		return indexComputer;
	}

	public void setIndexComputer(int indexComputer) {
		this.indexComputer = indexComputer;
	}

	public String getBuffer() {
		return buffer;
	}

	public void setBuffer(String buffer) {
		this.buffer = buffer;
	}

	public AdresaIp getAdresaIpMyPC() {
		return adresaIpMyPC;
	}

	public void setAdresaIpMyPC(AdresaIp adresaIpMyPC) {
		this.adresaIpMyPC = adresaIpMyPC;
	}

	public MyPC getNext() {
		return next;
	}

	public void setNext(MyPC myPC) {
		this.next = myPC;
	}

	public Token getJeToken() {
		return jeToken;
	}

	public void setJeToken(Token jeToken) {
		this.jeToken = jeToken;
	}

	public String toString() {
		return "index:"+ indexComputer + "( " + adresaIpMyPC + " ) " + "->" + buffer + "\n";
	}

	public static boolean compareComputers(MyPC calculator1, MyPC calculator2) {
		return AdresaIp.egalitate(calculator1.getAdresaIpMyPC(), calculator2.getAdresaIpMyPC());
	}

	@Override
	public synchronized void run() {
		
		if(Network.getSourceComputer()==null)
		{
			Network.setSourceComputer(this);
			Network.run();
		}
		else {
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
