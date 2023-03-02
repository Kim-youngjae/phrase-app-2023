package org.example;

public class Phrase {
    private long id;
    private String phrase;
    private String authorName;

    public Phrase(long id, String phrase, String authorName) {
        this.id = id;
        this.phrase = phrase;
        this.authorName = authorName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
