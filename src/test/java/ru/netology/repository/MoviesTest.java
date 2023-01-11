package ru.netology.repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.data.Poster;

public class MoviesTest {
    MoviesRepository repo = new MoviesRepository();
    Poster poster1 = new Poster("Бладшот", 3024, "Боевик", "????");
    Poster poster2 = new Poster("Вперёд", 7302, "Мультфильм", "????");
    Poster poster3 = new Poster("Отель Белград", 5629, "Комедия", "????");
    Poster poster4 = new Poster("Джентельмены", 2480, "Боевик", "????");
    Poster poster5 = new Poster("Человек-Неведимка", 1937, "Ужасы", "????");

    @BeforeEach
    public void setup() {
        repo.save(poster1);
        repo.save(poster2);
        repo.save(poster3);
        repo.save(poster4);
    }

    @Test
    public void shouldAddNewMoviesDefaultMoviesAmount() {

        Poster[] expected = new Poster[] { poster1, poster2, poster3, poster4 };
        Poster[] actual = repo.getPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAddedMoviesDefaultMoviesAmount() {

        Poster[] expected = new Poster[] { poster4, poster3, poster2, poster1 };
        Poster[] actual = repo.findLast(4);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdAddedMoviesDefaultMoviesAmount() {

        repo.removeById(poster3.getId());

        Poster[] expected = new Poster[] { poster1, poster2, poster4 };
        Poster[] actual = repo.getPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMovieByIdDefaultMoviesAmount() {

        repo.findById(poster2.getId());

        Poster[] expected = new Poster[] { poster2 };
        Poster[] actual = repo.getPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMovieByNonexistentIdDefaultMoviesAmount() {

        repo.findById(poster5.getId());

        Poster[] expected = new Poster[] { null };
        Poster[] actual = repo.getPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAddedMoviesInAddingOrderNotDefaultMoviesAmount() {
        MoviesRepository repo = new MoviesRepository(4);
        repo.save(poster1);
        repo.save(poster2);
        repo.save(poster3);
        repo.save(poster4);

        Poster[] expected = new Poster[] { poster1, poster2, poster3, poster4 };
        Poster[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllAddedMoviesNotDefaultMoviesAmount() {
        MoviesRepository repo = new MoviesRepository(4);
        repo.save(poster1);
        repo.save(poster2);
        repo.save(poster3);
        repo.save(poster4);
        repo.removeAll();

        Poster[] expected = new Poster[0];
        Poster[] actual = repo.getPosters();

        Assertions.assertArrayEquals(expected, actual);
    }
}
