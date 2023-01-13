package ru.netology.manager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.data.Poster;

public class MovieTestNotDefault {
    MoviesManager manager = new MoviesManager(3);
    Poster poster1 = new Poster("Бладшот", "3024", "Боевик", "????");
    Poster poster2 = new Poster("Вперёд", "7302", "Мультфильм", "????");
    Poster poster3 = new Poster("Отель Белград", "5629", "Комедия", "????");
    Poster poster4 = new Poster("Джентельмены", "2480", "Боевик", "????");

    @Test
    public void shouldAddNewMovies() {
        manager.addMovie(poster1);
        manager.addMovie(poster2);
        manager.addMovie(poster3);

        Poster[] expected = new Poster[] { poster1, poster2, poster3 };
        Poster[] actual = manager.getPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAddedMoviesInAddingOrder() {
        manager.addMovie(poster1);
        manager.addMovie(poster2);
        manager.addMovie(poster3);

        Poster[] expected = new Poster[] { poster1, poster2, poster3 };
        Poster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAddedMoviesLimit() {
        manager.addMovie(poster1);
        manager.addMovie(poster2);
        manager.addMovie(poster3);

        Poster[] expected = new Poster[] { poster3, poster2, poster1 };
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAddedMoviesAboveLimit() {
        manager.addMovie(poster1);
        manager.addMovie(poster2);
        manager.addMovie(poster3);
        manager.addMovie(poster4);

        Poster[] expected = new Poster[] { poster4, poster3, poster2 };
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAddedMoviesUnderLimit() {
        manager.addMovie(poster1);
        manager.addMovie(poster2);

        Poster[] expected = new Poster[] { poster2, poster1 };
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindLastWhen0moviesAdded() {

        Poster[] expected = new Poster[]{ };
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWhen1MoviesAdded() {
        manager.addMovie(poster1);

        Poster[] expected = new Poster[] { poster1 };
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
