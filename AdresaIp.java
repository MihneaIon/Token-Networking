package jeton;

import java.util.Random;

public class AdresaIp {

	private int ip1;
	private int ip2;
	private int ip3;
	private int ip4;

	public AdresaIp() {
		Random random = new Random();

		ip1 = Math.abs(random.nextInt(256)%256);
		ip2 = Math.abs(random.nextInt(256)%256);
		ip3 = Math.abs(random.nextInt(256)%256);
		ip4 = Math.abs(random.nextInt(256)%256);

	}

	public AdresaIp(int ip1, int ip2, int ip3, int ip4) {
		this.ip1 = ip1;
		this.ip2 = ip2;
		this.ip3 = ip3;
		this.ip4 = ip4;
	}

	public String toString() {
		return ip1 + " " + ip2 + " " + ip3 + " " + ip4;
	}

	public static boolean egalitate(AdresaIp address1, AdresaIp address2) {
		if (address1.ip1 != address2.ip1) {
			return false;
		}
		if (address1.ip2 != address2.ip2) {
			return false;
		}
		if (address1.ip3 != address2.ip3) {
			return false;
		}
		if (address1.ip4 != address2.ip4) {
			return false;
		}
		
		return true;
	}

	public int getIp1() {
		return ip1;
	}

	public void setIp1(int ip1) {
		this.ip1 = ip1;
	}

	public int getIp2() {
		return ip2;
	}

	public void setIp2(int ip2) {
		this.ip2 = ip2;
	}

	public int getIp3() {
		return ip3;
	}

	public void setIp3(int ip3) {
		this.ip3 = ip3;
	}

	public int getIp4() {
		return ip4;
	}

	public void setIp4(int ip4) {
		this.ip4 = ip4;
	}
	
	

}
