package com.tom.S4_Polymorphism.conditionarray.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:conditionarray/features/CreateNumbersList.feature"},
        glue = {"com.tom.conditionarray.cucumber"})
public class CreateNumbersListTest {
}
