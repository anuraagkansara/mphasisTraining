package com.mphasis.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TextEditor {
    @Autowired
    @Qualifier("spellingCheck")
    private SpellChecker spellChecker;

    public TextEditor(SpellChecker spellChecker) {
        System.out.println("Constructor");
        this.spellChecker = spellChecker;
    }

    public SpellChecker getSpellChecker(){
        return spellChecker;
    }

//    @Autowired
//    public void setSpellChecker(SpellChecker spellChecker){
//        System.out.println("Setter");
//        this.spellChecker = spellChecker;
//    }
}
