package it.uniroma3;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/prova.feature",glue="it.uniroma3",plugin= {"junit:target/html-response.txt"},tags = "@Hw2")
public class runTest {

}
