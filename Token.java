package jeton;

public class Token extends Thread {

	private AdresaIp source;
	private AdresaIp destination;
	private String message;
	private boolean free;
	private boolean rightDestination;
	
	public Token() {
		source = null;
		destination = null;
		message = "default";
		free = true;
		rightDestination = false;
	}

	public Token(AdresaIp sursa, AdresaIp destinatie, String mesaj, boolean liber, boolean screieDestinatie) {
		this.source = sursa;
		this.destination = destinatie;
		this.message = mesaj;
		this.free = liber;
		this.rightDestination = screieDestinatie;
	}

	public AdresaIp getsource() {
		return source;
	}

	public void setsource(AdresaIp source) {
		this.source = source;
	}

	public AdresaIp getDestination() {
		return destination;
	}

	public void setDestination(AdresaIp destination) {
		this.destination = destination;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public boolean isrightDestination() {
		return rightDestination;
	}

	public void setrightDestination(boolean rightDestination) {
		this.rightDestination = rightDestination;
	}

	@Override
	public String toString() {
		return " Token (ipSource= " + source + " , ipDestination=" + destination + " , message= " + message + " ,free= "
				+ free + " , rightDestination =" + rightDestination;
	}

}
