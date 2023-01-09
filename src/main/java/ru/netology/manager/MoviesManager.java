package ru.netology.manager;

import ru.netology.data.Poster;

public class MoviesManager {
    private Poster[] posters = new Poster[0];
    private int postersAmount;

    public MoviesManager() {
        this.postersAmount = 10;
    }

    public MoviesManager(int postersAmount) {
        this.postersAmount = postersAmount;
    }

    public Poster[] getPosters() {
        return posters;
    }

    public void addMovie(Poster poster) {
        Poster[] movies = new Poster[posters.length + 1];
        for (int i = 0; i < posters.length; i++) {
            movies[i] = posters[i];
        }
        movies[movies.length - 1] = poster;
        posters = movies;
    }

    public Poster[] findAll() {
        Poster[] all = new Poster[posters.length];
        for (int i = 0; i < all.length; i++) {
            all[i] = posters[i];
        }
        return all;
    }

    public Poster[] findLast() {
        int resultLength;
        if (posters.length >= postersAmount) {
            resultLength = postersAmount;
        } else {
            resultLength = posters.length;
        }
        Poster[] result = new Poster[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = posters[posters.length - 1 - i];
        }
        return result;
    }
}
