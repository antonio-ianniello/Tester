#Author:IANNIELLO ANTONIO
@HW2
Feature: HomeWork 2 Testing
  Voglio usare questo template per testare il codice inerente all' homework 2

  @Hw2
	Scenario: HW2 prova del comando aiuto
  Given Ho iniziato la partita
  When ho digitato "aiuto"
  And il programma ha stampato"vai,aiuto,fine,prendi,posa,guarda"
  When ho digitato "fine"
  And la partita e finita
  Then la riga "1" ha stampato "vai"
  And la riga "1" ha stampato "aiuto"
  And la riga "1" ha stampato "prendi"
  And la riga "1" ha stampato "posa"
  And la riga "1" ha stampato "guarda"
  And la riga "1" ha stampato "fine" 
  And il programma ha stampato "Grazie di aver giocato!"

  @Hw2
  Scenario: HW2 prova del comando fine
  Given Ho iniziato la partita
  When ho digitato "fine"
  And il programma ha stampato"Grazie di aver giocato!"
  And la partita e finita
  Then il programma ha stampato "Grazie di aver giocato!"
  
  @Hw2
  Scenario: Homework 2 caso digita vai est
  Given Ho iniziato la partita
  When ho digitato "vai est"
  And il programma ha stampato"Aula N11"
  When ho digitato "fine"
  And la partita e finita
  Then la riga "1" ha stampato "N11"
  And il programma ha stampato "Grazie di aver giocato!"
  
  @Hw2
  Scenario: Homework 2 caso digita vai ovest
  Given Ho iniziato la partita
  When ho digitato "vai ovest"
  And il programma ha stampato"Sei in Laboratorio Campus"
  When ho digitato "fine"
  And la partita e finita
  Then la riga "1" ha stampato "Laboratorio Campus"
  And il programma ha stampato "Grazie di aver giocato!"
  
  @Hw2
  Scenario: Homework 2 caso digita vai nord e vittoria
  Given Ho iniziato la partita
  When ho digitato "vai nord"
  And il programma ha stampato"Sei in Biblioteca"
  When ho digitato "fine"
  And la partita e finita
  Then la riga "1" ha stampato "Biblioteca"
  And il programma ha stampato "Hai vinto" 
  
  @Hw2  
  Scenario: Homework 2 caso digita vai ovest 2 volte
  Given Ho iniziato la partita
  When ho digitato "vai ovest"
  And il programma ha stampato"Sei in Laboratorio Campus"
  When ho digitato "vai ovest"
  And il programma ha stampato"Sei in Aula N11"
  When ho digitato "fine"
  And la partita e finita
  Then la riga "1" ha stampato "Laboratorio Campus"
  And la riga "2" ha stampato "N11"
  And il programma ha stampato "Grazie di aver giocato!"  
  
  @Hw2
  Scenario: Homework 2 caso stanza bloccata
  Given Ho iniziato la partita
  When ho digitato "vai est"
  And il programma ha stampato"Sei in Aula N11"
  When ho digitato "vai sud"
  And il programma ha stampato"Sei in Bloccata"
  When ho digitato "vai nord"
  And il programma ha stampato"Sei in Bloccata"
  When ho digitato "fine"
  And la partita e finita
  Then la riga "1" ha stampato "N11"
  And la riga "2" ha stampato "Bloccata"
  And la riga "3" ha stampato "Bloccata"
  And il programma ha stampato "Grazie di aver giocato!"
  
  @Hw2
  Scenario: Homework 2 caso stanza bloccata con chiave
  Given Ho iniziato la partita
  When ho digitato "prendi chiave"
  And il programma ha stampato"oggetto messo nella borsa correttamente!"
 	When ho digitato "vai est"
 	And il programma ha stampato"Sei in Aula N11"
  When ho digitato "vai sud"
  And il programma ha stampato"Sei in Bloccata"
  When ho digitato "posa chiave"
  And il programma ha stampato"L' oggetto:chiave è stato posato correttamente"
  When ho digitato "vai nord"
  And il programma ha stampato"Sei in Aula N11"
  When ho digitato "fine"
  And la partita e finita
  Then la riga "1" ha stampato "correttamente"
  And la riga "2" ha stampato "N11"
  And la riga "3" ha stampato "Bloccata"
  And la riga "4" ha stampato "chiave"
  And la riga "4" ha stampato "posato correttamente"
  And la riga "5" ha stampato "N11"
  And il programma ha stampato "Grazie di aver giocato!" 
  
  @Hw2
  Scenario: Homework 2 caso stanza buia
  Given Ho iniziato la partita
  When ho digitato "vai est"
  And il programma ha stampato"Sei in N11"
  When ho digitato "vai nord"
  And il programma ha stampato"Sei in Buia"
  When ho digitato "guarda"
  And il programma ha stampato"qui c'è un buio pesto!"
  When ho digitato "fine"
  And la partita e finita
  Then la riga "1" ha stampato "N11"
  And la riga "2" ha stampato "Buia"
  And la riga "3" ha stampato "buio"
  And il programma ha stampato "Grazie di aver giocato!"