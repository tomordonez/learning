package com.tom.conditionarray.cucumber;

import com.tom.conditionarray.ConditionArrayList;
import com.tom.conditionarray.RandomNumberList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

public class CreateNumbersListSteps {

    ConditionArrayList numberList;
    ArrayList<Integer> filteredNumberList;

    @Given("I have a list of positive numbers")
    public void iHaveAListOfPositiveNumbers() {
        numberList = new ConditionArrayList(RandomNumberList.createList(5, 10, 10));
    }

    @When("I filter by odd numbers")
    public void i_filter_by_odd_numbers() {
        filteredNumberList = numberList.filterByPredicate(listElement -> (listElement % 2 == 1));
    }

    @Then("A list of positive odd numbers is created")
    public void a_list_of_positive_odd_numbers_is_created() {
        System.out.println(filteredNumberList);
    }
}
