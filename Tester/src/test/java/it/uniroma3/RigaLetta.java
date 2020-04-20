package it.uniroma3;

import java.util.ArrayList;
import java.util.List;

public class RigaLetta {
	
	private String riga;
	private List<String> messaggi;
	
	public RigaLetta() {
		this.riga= new String();
		this.messaggi = new ArrayList<String>();
		
	}
	
	public RigaLetta(String riga) {
		this.riga = riga;
		this.messaggi = new ArrayList<String>();
	}

	public String getRiga() {
		return riga;
	}

	public void setRiga(String riga) {
		this.riga = riga;
	}	
	
	public List<String> getMessaggi() {
		return messaggi;
	}

	public void setMessaggi(List<String> messaggi) {
		this.messaggi = messaggi;
	}


	@Override
	public int hashCode() {
		return this.getRiga().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		RigaLetta that = (RigaLetta) o;
		return this.getRiga().equals(that.getRiga());
	}
	
	@Override
	public String toString() {
		StringBuilder stringa = new StringBuilder();
		stringa.append(this.getRiga());		
		return stringa.toString();
		
	}
	
	
	

}
