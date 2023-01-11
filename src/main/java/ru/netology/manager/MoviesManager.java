package ru.netology.manager;

import ru.netology.data.Poster;
import ru.netology.repository.MoviesRepository;

public class MoviesManager {
    private MoviesRepository repo;

    public MoviesManager(MoviesRepository repo) {
        this.repo = repo;
    }

    public void save(Poster posters) {
        repo.save(posters);
    }

    public void removeById(int id) {
        repo.removeById(id);
    }

    public Poster[] findLast() {
        Poster[] all = repo.getPosters();
        Poster[] last = new Poster[all.length];
        for (int i = 0; i < last.length; i++) {
            last[i] = all[all.length - 1 - i];
        }
        return last;
    }

    public Poster[] findAll() {
        Poster[] all = repo.getPosters();
        Poster[] amount = new Poster[all.length];
        for (int i = 0; i < amount.length; i++) {
            amount[i] = all[i];
        }
        return amount;
    }
}
