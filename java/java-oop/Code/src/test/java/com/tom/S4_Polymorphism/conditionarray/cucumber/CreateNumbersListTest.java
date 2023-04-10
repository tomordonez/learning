package com.tom.S4_Polymorphism.conditionarray.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/S4_Polymorphism/conditionarray/CreateNumbersList.feature"},
        glue = {"com.tom.S4_Polymorphism.conditionarray.cucumber"})
public class CreateNumbersListTest {
}
