package it.uniroma3.diadia;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;



public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	private Partita partita;
	private IO IO;
	private FabbricaDiComandi factory;

	public DiaDia(IO interfaccia) {
		this.IO = interfaccia;
		this.partita = new Partita();
		this.factory=new FabbricaDiComandiFisarmonica();		//*1 tolto parametro interfaccia
	}

	public void gioca() {
		String istruzione; 
		this.IO.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = IO.leggiRiga();
		while (!processaIstruzione(istruzione));

	}   

	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		comandoDaEseguire= factory.costruisciComando(istruzione,this.IO);		//*2 aggiunto secondo parmaetro io
		comandoDaEseguire.esegui(this.partita);

		if(this.partita.vinta())
			IO.mostraMessaggio("Hai vinto ");

			
	    // if(!this.partita.getGiocatore().giocatoreIsVivo())
		//	IO.mostraMessaggio("Hai esaurito i Cfu" );

		return this.partita.isFinita();

	}

	public static void main(String[] args)  throws IOException  {        
	
		
		/*
		File source= new File("C:\\Users\\anton\\git\\Tester\\target\\cucumber-reports\\report.js");
		//dest2 è la destinazione corretta per maven, solo dopo aver copiato le due cartelle nel progetto maven
		File dest2 = new File("C:\\Users\\anton\\.m2\\repository\\it\\uniroma3\\springBootwebAppdemo\\0.0.1-SNAPSHOT\\static\\js");
		copyFileUsingStream(source, dest2);
		*/
		//nuova destinazione di tymeleaf
		//File dest = new File("C:\\Users\\anton\\git\\CaricatoreFileHtml\\static\\js\\report.js");
		
		//vecchia destinazione prima di cambiare tymeleaf in property
		//File dest = new File("C:\\Users\\anton\\git\\CaricatoreFileHtml\\src\\main\\resources\\static\\js\\report.js");
		
		
		
		//bisogna metterlo su maven, per ora ho usato due folder esterne templates and static
		//copyFileUsingStream(source, dest);
		
		
	    }
		 
	private static void copyFileUsingStream(File source, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
	}}



