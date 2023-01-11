package ru.netology.data;

public class Poster {
    private String name;
    private int id;
    private String genre;
    private String imageUrl;

    public Poster (String name, int id, String genre, String imageUrl) {
        this.name = name;
        this.id = id;
        this.genre = genre;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
