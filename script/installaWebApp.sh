#!/bin/bash

mvn install -f ~/git/CaricatoreFileHtml/pom.xml;
cp -r ~/git/CaricatoreFileHtml/static ~/.m2/repository/it/uniroma3/springBootwebAppdemo/0.0.1-SNAPSHOT/;
cp -r ~/git/CaricatoreFileHtml/templates ~/.m2/repository/it/uniroma3/springBootwebAppdemo/0.0.1-SNAPSHOT/;
echo avvio applicazione;
cd ~/.m2/repository/it/uniroma3/springBootwebAppdemo/0.0.1-SNAPSHOT/;
java -jar springBootwebAppdemo-0.0.1-SNAPSHOT.jar;

