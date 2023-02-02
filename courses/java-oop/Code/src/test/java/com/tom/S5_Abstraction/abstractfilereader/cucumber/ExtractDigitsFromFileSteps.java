package com.tom.S5_Abstraction.abstractfilereader.cucumber;

import com.tom.S5_Abstraction.abstractfilereader.DigitFileReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtractDigitsFromFileSteps {

    List<List<String>> textFileData;
    DigitFileReader digitFileReader;
    ArrayList<Integer> digitsFromTextFile;

    @Given("I have a text file")
    public void i_have_a_text_file(DataTable dataTable) {
        textFileData = new ArrayList<>(dataTable.asLists());
    }

    @When("I extract the digits from the file")
    public void i_extract_the_digits_from_the_file() {
        digitFileReader = new DigitFileReader();
        digitsFromTextFile = digitFileReader.parseDigits(textFileData);
    }

    @Then("A list of digits is extracted")
    public void a_list_of_digits_is_extracted(DataTable dataTable) {
        List<Integer> expectedDigits = dataTable.asLists()
                .get(0)
                .stream()
                .map(Integer::parseInt)
                .toList();

        assertEquals(new ArrayList<>(expectedDigits), digitsFromTextFile);
    }
}
