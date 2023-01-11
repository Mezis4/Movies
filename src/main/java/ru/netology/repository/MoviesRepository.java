package ru.netology.repository;
import ru.netology.data.Poster;

public class MoviesRepository {
    private Poster[] posters = new Poster[0];
    private int postersAmount;
    private int index;

    public MoviesRepository() {
        this.postersAmount = 10;
    }

    public MoviesRepository(int postersAmount) {
        this.postersAmount = postersAmount;
    }

    public void save(Poster poster) {
        Poster[] movies = new Poster[posters.length + 1];
        for (int i = 0; i < posters.length; i++) {
            movies[i] = posters[i];
        }
        movies[movies.length - 1] = poster;
        posters = movies;
    }

    public void removeById(int id) {
        Poster[] movies = new Poster[posters.length - 1];
        int copyToIndex = 0;
        for (Poster poster : posters) {
            if (poster.getId() != id) {
                movies[copyToIndex] = poster;
                copyToIndex++;
            }
        }
        posters = movies;
    }

    public Poster[] getPosters() {
        return posters;
    }

    public Poster[] findLast(int postersAmount) {
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

    public Poster[] findAll() {
        Poster[] all = new Poster[posters.length];
        for (int i = 0; i < all.length; i++) {
            all[i] = posters[i];
        }
        return all;
    }

    public void findById(int id) {
        Poster[] movies = new Poster[posters.length - posters.length + 1];
        int copyToIndex = 0;
        for (Poster poster : posters) {
            if (poster.getId() == id) {
                movies[copyToIndex] = poster;
                copyToIndex++;
            }
        }
        posters = movies;
    }

    public void removeAll() {
        Poster[] empty = new Poster[0];
        posters = empty;
    }
}
