package ru.netology.manager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import ru.netology.data.Poster;

public class MovieTestNotDefault {
    MoviesManager manager = new MoviesManager(3);
    Poster poster1 = new Poster("Бладшот", "3024", "Боевик", "????");
    Poster poster2 = new Poster("Вперёд", "7302", "Мультфильм", "????");
    Poster poster3 = new Poster("Отель Белград", "5629", "Комедия", "????");

    @BeforeEach
    public void setup() {
        manager.addMovie(poster1);
        manager.addMovie(poster2);
        manager.addMovie(poster3);
    }

    @Test
    public void shouldAddNewMovies() {

        Poster[] expected = new Poster[] { poster1, poster2, poster3 };
        Poster[] actual = manager.getPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAddedMoviesInAddingOrder() {

        Poster[] expected = new Poster[] { poster1, poster2, poster3 };
        Poster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAddedMovies() {

        Poster[] expected = new Poster[]{ poster3, poster2, poster1 };
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
