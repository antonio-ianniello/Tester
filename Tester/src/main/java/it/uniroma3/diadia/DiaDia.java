package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.interfacciaComandi.IO;
import it.uniroma3.diadia.interfacciaComandi.IOConsole;

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
		this.factory=new FabbricaDiComandiFisarmonica(interfaccia);
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
		comandoDaEseguire= factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);

		if(this.partita.vinta())
			IO.mostraMessaggio("Hai vinto ");

		if(!this.partita.getGiocatore().giocatoreIsVivo())
			IO.mostraMessaggio("Hai esaurito i Cfu");
		
		return this.partita.isFinita();
		
	}
	public static void main(String[] args) {
		DiaDia dia = new DiaDia(new IOConsole());
		dia.gioca();
	}

}
