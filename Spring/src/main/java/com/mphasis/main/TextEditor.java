package com.mphasis.main;

public class TextEditor {
    private SpellChecker spellChecker;

    public TextEditor(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public SpellChecker getSpellChecker(){
        return spellChecker;
    }
    public void setSpellChecker(SpellChecker spellChecker){
        this.spellChecker = spellChecker;
    }
}
