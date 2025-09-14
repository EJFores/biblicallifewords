package com.main.site;

public class VerseReference {
    private String book;
    private int chapter;
    private String verse;

    public VerseReference() {}

    public VerseReference(String book, int chapter, String verse) {
        this.book = book;
        this.chapter = chapter;
        this.verse = verse;
    }

    public String getBook() { return book; }
    public int getChapter() { return chapter; }
    public String getVerse() { return verse; }

    public void setBook(String book) { this.book = book; }
    public void setChapter(int chapter) { this.chapter = chapter; }
    public void setVerse(String verse) { this.verse = verse; }

    @Override
    public String toString() {
        return book + " " + chapter + ":" + verse;
    }
}