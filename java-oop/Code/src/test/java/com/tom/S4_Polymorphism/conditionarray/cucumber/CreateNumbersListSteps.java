package com.tom.S4_Polymorphism.conditionarray.cucumber;

import com.tom.S4_Polymorphism.conditionarray.ConditionArrayList;
import com.tom.S4_Polymorphism.conditionarray.RandomNumberList;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateNumbersListSteps {

    ConditionArrayList randomNumberList;
    ArrayList<Integer> filteredNumberList;
    List<Integer> numberList;
    ConditionArrayList numberArray;

    @Given("I have a list of random positive numbers")
    public void iHaveAListOfRandomPositiveNumbers() {
        randomNumberList = new ConditionArrayList(RandomNumberList.createList(5, 10, 10));
    }

    @When("I filter by odd numbers")
    public void i_filter_by_odd_numbers() {
        filteredNumberList = randomNumberList.filterByPredicate(listElement -> (listElement % 2 == 1));
    }

    @Then("A list of positive odd numbers is created")
    public void a_list_of_positive_odd_numbers_is_created() {
        System.out.println(filteredNumberList);
    }

    @When("I filter by even numbers")
    public void i_filter_by_even_numbers() {
        filteredNumberList = randomNumberList.filterByPredicate(listElement -> (listElement % 2 == 0));
    }

    @Then("A list of positive even numbers is created")
    public void a_list_of_positive_even_numbers_is_created() {
        System.out.println(filteredNumberList);
    }

    @Given("I have a list of positive numbers")
    public void iHaveAListOfPositiveNumbers(DataTable table) {
        numberList = table.row(0).stream()
                .map(Integer::parseInt)
                .toList();
        numberArray = new ConditionArrayList(numberList);
    }

    @When("I filter by prime numbers")
    public void iFilterByPrimeNumbers() {
        filteredNumberList = numberArray.filterByPredicate(ConditionArrayList::isPrime);
    }


    @Then("A list of positive prime numbers is created")
    public void aListOfPositivePrimeNumbersIsCreated(DataTable table) {
        List<Integer> primeNumberList = table.row(0).stream()
                .map(Integer::parseInt)
                .toList();
        assertEquals(new ArrayList<>(primeNumberList), filteredNumberList, "ArrayList of primes should be equal");
    }
}
