package com.codurance.streetplanning.validator.rules;

import java.util.List;
import com.codurance.streetplanning.housenumbers.HouseNumbers;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NumbersAreUniqueRuleShould {

    private UniqueNumbersRule uniqueNumbersRule;

    @Before
    public void setUp() {
        uniqueNumbersRule = new UniqueNumbersRule();
    }

    @Test
    public void returnFalseIfNumbersAreNotUnique() {
        List<Integer> listWithDuplicateNumbers = asList(1, 3, 3, 2, 4, 5);

        assertThat(uniqueNumbersRule.validate(new HouseNumbers(listWithDuplicateNumbers)), is(false));
    }

    @Test
    public void returnTrueIfNumbersAreUnique() {
        List<Integer> listWithUniqueNumbers = asList(1, 2, 3, 4, 5);

        assertThat(uniqueNumbersRule.validate(new HouseNumbers(listWithUniqueNumbers)), is(true));
    }
}