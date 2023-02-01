package com.tom.S3_Inheritance.modarray;

import com.tom.S3_Inheritance.modarray.ModArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ModArrayListTest {

    ModArrayList marvelCharacters = null;
    @BeforeEach
    void setUp() {
        marvelCharacters = new ModArrayList();
        marvelCharacters.add("Namor");
        marvelCharacters.add("TChalla");
        marvelCharacters.add("Killmonger");
        marvelCharacters.add("Shuri");
    }

    @Test
    void getUsingMod_PositiveIndexInRange_IndexedItem() {
        assertAll("Should return all marvel characters from the list",
                () -> assertEquals("Namor", marvelCharacters.getUsingMod(0)),
                () -> assertEquals("TChalla", marvelCharacters.getUsingMod(1)),
                () -> assertEquals("Killmonger", marvelCharacters.getUsingMod(2)),
                () -> assertEquals("Shuri", marvelCharacters.getUsingMod(3))
        );
    }

    @Test
    void getUsingMod_PositiveIndexOutOfRange_ModIndexedItem() {
        assertEquals("TChalla",
                marvelCharacters.getUsingMod(5),
                "It should return the item with mod index of 1 (argument % List length: 5 % 4)");
    }

    @Test
    void getUsingMod_NegativeIndex_ModIndexedItem() {
        assertEquals("Killmonger",
                marvelCharacters.getUsingMod(-2),
                "It should return the item with index of 2 (argument absolute value)");
    }

}