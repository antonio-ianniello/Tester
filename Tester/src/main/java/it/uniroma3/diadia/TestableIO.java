package it.uniroma3.diadia;
import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia.interfacciaComandi.RigaLetta;


public class TestableIO implements IO{

	
	private RigaLetta rigaCorrente;
	private List<RigaLetta> righe;	
	private int indiceRigaLetta=0;
	private List<String> messaggiIniziali ;

	public TestableIO() {
		this.rigaCorrente = new RigaLetta();
		this.righe = new ArrayList<RigaLetta>();
		this.messaggiIniziali= new ArrayList<String>();
	}

	public void mostraMessaggio(String messaggio) {
		if(this.indiceRigaLetta==0)
			this.setMessaggiIninziali(messaggio);
		else
			this.addMessaggio(messaggio);
	}

	public String leggiRiga() {
		this.rigaCorrente = this.righe.get(indiceRigaLetta);
		this.indiceRigaLetta++;		
		return rigaCorrente.getRiga();
	}

	public List<RigaLetta> getRighe() {
		return this.righe;
	}

	public List<String> getMessaggi() {
		List<String> messaggi = new ArrayList<String>();
		
		if(this.messaggiIniziali.size()>0)
			messaggi.add(this.getMessaggiIninziali().toString());
		for(RigaLetta r: this.righe) {
			messaggi.addAll(r.getMessaggi());
		}
		return messaggi;
	}

	public TestableIO addMessaggio(String messaggio) {

		this.rigaCorrente.getMessaggi().add(messaggio);		
		return this;
	}

	public TestableIO addRigaSingola(String riga) {	
		RigaLetta nuovaRiga = new RigaLetta(riga);
		this.righe.add(nuovaRiga);
		return this;
	}

	public List<String> getMessaggiAtRiga(int numeroRiga) {
		return  this.righe.get(numeroRiga-1).getMessaggi();
	}

	public List<String> getMessaggiFinali(){
		return this.getRighe().get(indiceRigaLetta-1).getMessaggi();
	}

	public RigaLetta getRigaCorrente() {
		return rigaCorrente;
	}

	public void setRigaCorrente(RigaLetta rigaCorrente) {
		this.rigaCorrente = rigaCorrente;
	}

	public List<String> getMessaggiIninziali() {
		return this.messaggiIniziali;
	}	

	private void setMessaggiIninziali(String messaggioIniziale) {
		this.messaggiIniziali.add(messaggioIniziale);
		
	}
	
}