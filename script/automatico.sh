#!/bin/bash

mvn install -f ~/git/Tester/pom.xml;
mvn -e install:install-file -Dfile=.m2/repository/it/uniroma3/springBootwebAppdemo/0.0.1-SNAPSHOT/uploads/prova.jar -DgroupId=it.uniroma3 -DartifactId=Tester -Dversion=0.1 -Dpackaging=jar;
mvn install -f ~/git/Tester/pom.xml;
echo mancaLaCopiaDelRisultatoNelFileCorretto;
cp ~/Scrivania/reportRis.js ~/.m2/repository/it/uniroma3/springBootwebAppdemo/0.0.1-SNAPSHOT/static/js/report.js;
