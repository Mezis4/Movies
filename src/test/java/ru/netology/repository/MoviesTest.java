package ru.netology.repository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.data.Poster;

public class MoviesTest {
    MoviesRepository repo = new MoviesRepository();
    Poster poster1 = new Poster("Бладшот",  3024, "Боевик", "????");
    Poster poster2 = new Poster("Вперёд",  7302, "Мультфильм", "????");
    Poster poster3 = new Poster("Отель Белград", 5629, "Комедия", "????");
    Poster poster4 = new Poster("Джентельмены", 2480, "Боевик", "????");
    Poster poster5 = new Poster("Человек-Неведимка", 1937, "Ужасы", "????");
    Poster poster6 = new Poster("Тролли.  Мировой тур", 4881, "Мультфильмы", "????");
    Poster poster7 = new Poster("Номер один", 6140, "Комедия", "????");
    Poster poster8 = new Poster("Рыцари справедливости", 1963, "Драма", "????");
    Poster poster9 = new Poster("Момент истины", 3836, "Триллер", "????");
    Poster poster10 = new Poster("Довод", 5491, "Боевик", "????");

    @Test
    public void shouldAddNewMovies() {
        repo.save(poster1);
        repo.save(poster2);
        repo.save(poster3);
        repo.save(poster4);

        Poster[] expected = new Poster[] { poster1, poster2, poster3, poster4 };
        Poster[] actual = repo.getPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAddedMoviesUnderLimit() {
        repo.save(poster1);
        repo.save(poster2);
        repo.save(poster3);
        repo.save(poster4);

        Poster[] expected = new Poster[] { poster4, poster3, poster2, poster1 };
        Poster[] actual = repo.findLast(5);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdAddedMovies() {
        repo.save(poster1);
        repo.save(poster2);
        repo.save(poster3);
        repo.save(poster4);

        repo.removeById(poster3.getId());

        Poster[] expected = new Poster[] { poster1, poster2, poster4 };
        Poster[] actual = repo.getPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMovieById() {
        repo.save(poster1);
        repo.save(poster2);
        repo.save(poster3);
        repo.save(poster4);

        repo.findById(poster2.getId());

        Poster[] expected = new Poster[] { poster2 };
        Poster[] actual = repo.getPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMovieByNonexistentId() {
        repo.save(poster1);
        repo.save(poster2);
        repo.save(poster3);
        repo.save(poster4);

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
    public void shouldShowAddedMoviesInAddingOrderDefaultMoviesAmount() {
        repo.save(poster1);
        repo.save(poster2);
        repo.save(poster3);
        repo.save(poster4);
        repo.save(poster5);
        repo.save(poster6);
        repo.save(poster7);
        repo.save(poster8);
        repo.save(poster9);
        repo.save(poster10);

        Poster[] expected = new Poster[] {
                poster1,
                poster2,
                poster3,
                poster4,
                poster5,
                poster6,
                poster7,
                poster8,
                poster9,
                poster10
        };
        Poster[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllAddedMoviesDefaultMoviesAmount() {

        repo.save(poster1);
        repo.save(poster2);
        repo.save(poster3);
        repo.save(poster4);
        repo.save(poster6);
        repo.save(poster7);
        repo.save(poster8);
        repo.save(poster9);
        repo.save(poster10);
        repo.removeAll();

        Poster[] expected = new Poster[0];
        Poster[] actual = repo.getPosters();

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

    @Test
    public void shouldNotFindLastWhen0moviesAdded() {

        Poster[] expected = new Poster[]{ };
        Poster[] actual = repo.findLast(4);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWhen1MovieAdded() {
        repo.save(poster1);

        Poster[] expected = new Poster[]{ poster1 };
        Poster[] actual = repo.findLast(4);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAddedMoviesAboveLimit() {
        repo.save(poster1);
        repo.save(poster2);
        repo.save(poster3);
        repo.save(poster4);
        repo.save(poster5);

        Poster[] expected = new Poster[]{
                poster5,
                poster4,
                poster3,
                poster2
        };
        Poster[] actual = repo.findLast(4);

        Assertions.assertArrayEquals(expected, actual);
    }
}
