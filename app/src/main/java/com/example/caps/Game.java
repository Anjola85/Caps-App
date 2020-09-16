//MUHAMMED ADEYEMI
//THIS LAB WAS DONE INDIVIDUALLY
package com.example.caps;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game {
    private CountryDB db;

    public Game() {
        this.db = new CountryDB();
    }

    public String qa() {
        List<String> capitals = db.getCapitals();
        int n = capitals.size();
        int index = (int) (Math.random() * (n + 1));
        String c = capitals.get(index);

        Map<String, Country> data = db.getData();
        Country ref = data.get(c);

        String question;
        if (Math.random() < 0.5) {
            question = "What is the capital of " + ref.getName() + "?";
            question += "\n" + ref.getCapital();
            return question;
        } else {
            question = ref.getCapital() + " is the capital of?";
            question += "\n" + ref.getName();
            return question;
        }
    }
}
