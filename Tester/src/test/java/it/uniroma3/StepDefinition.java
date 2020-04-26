package it.uniroma3;
import static org.junit.Assert.assertTrue;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import it.uniroma3.diadia.DiaDia;

public class StepDefinition {	
		private TestableIO interfaccia;
		private DiaDia dia ;
		private int punteggio=0;

		@Given("^Ho iniziato la partita$")
		public void ho_iniziato_la_partita() throws Throwable {
			interfaccia = new TestableIO();
		}

		@When("^ho digitato \"([^\"]*)\"$")
		public void ho_digitato(String rigaInserita) throws Throwable {
			this.getMyInterfacciaUtente().addRigaSingola(rigaInserita);
		}

		@When("^il programma ha stampato\"([^\"]*)\"$")
		public void il_programma_ha_stampato(String messaggio_stampato) throws Throwable {
			//vuoto a questo punto il messaggio non è in lista
		}

		@When("^la partita e finita$")
		public void la_partita_e_finita() throws Throwable {
			this.dia = new DiaDia(interfaccia);
			this.dia.gioca();
			System.out.println("\n RIGHE INPUT SONO: \n"+this.getMyInterfacciaUtente().getRighe().toString());
		}

		@Then("^la riga \"([^\"]*)\" ha stampato \"([^\"]*)\"$")
		public void la_riga_ha_stampato(int indice, String messaggio) throws Throwable {
			List<String> messaggiSalvati = this.getMyInterfacciaUtente().getMessaggiAtRiga(indice);
			boolean trovato = this.stringaPresente(messaggiSalvati, messaggio);
			assertTrue(trovato);
		}

		@Then("^il programma ha stampato \"([^\"]*)\"$")
		public void il_programma_ha_stampato1(String messaggio) throws Throwable {			
			List<String> messaggiFinali = this.getMyInterfacciaUtente().getMessaggiFinali();
			boolean trovato = this.stringaPresente(messaggiFinali, messaggio);
			assertTrue(trovato);

			System.out.println("\n MESSAGGI OUTPUT SONO: \n"+this.getMyInterfacciaUtente().getMessaggi());
			//this.stampaPunteggio();
		}

		public TestableIO getMyInterfacciaUtente() {
			return this.interfaccia;
		}

		public boolean stringaPresente(List<String> stringhe,String verifica) {
			boolean trovato = false;
			for(String mex: stringhe) {
				if(mex.contains(verifica)) {
					trovato = true;
					this.punteggio++;
				}
			}
			return trovato;
		}

		public void stampaPunteggio() {
			System.out.println("PUNTEGGIO SCENARIO OTTENUTO DALLO STUDENTE:"+this.punteggio);
		}
	
	@Given("^nulla$")
	public void nulla() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("nulla\n");
	}

	@When("^ciao$")
	public void ciao() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("ciao 2\n");
	}

	@Then("^saluta$")
	public void saluta() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("saluta");
	}
}