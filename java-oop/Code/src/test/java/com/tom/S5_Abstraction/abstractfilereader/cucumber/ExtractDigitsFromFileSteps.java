package com.tom.S5_Abstraction.abstractfilereader.cucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExtractDigitsFromFileSteps {
    @Given("I have a text file")
    public void i_have_a_text_file(DataTable dataTable) {
        throw new io.cucumber.java.PendingException();
    }

    @When("I extract the digits from the file")
    public void i_extract_the_digits_from_the_file() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("A list of digits is extracted")
    public void a_list_of_digits_is_extracted(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }
}
