package com.tom.S5_Abstraction.abstractfilereader.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = {"classpath:features/S5_Abstraction/abstractfilereader/ExtractDigitsFromFile.feature"},
        glue = {"com.tom.S5_Abstraction.abstractfilereader.cucumber"})
public class ExtractDigitsFromFileTest {
}
