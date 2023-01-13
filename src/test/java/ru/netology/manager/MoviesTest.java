package ru.netology.manager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.data.Poster;

public class MoviesTest {

    Poster poster1 = new Poster("Бладшот", "3024", "Боевик", "????");
    Poster poster2 = new Poster("Вперёд", "7302", "Мультфильм", "????");
    Poster poster3 = new Poster("Отель Белград", "5629", "Комедия", "????");
    Poster poster4 = new Poster("Джентельмены", "2480", "Боевик", "????");
    Poster poster5 = new Poster("Человек-Неведимка", "1937", "Ужасы", "????");
    Poster poster6 = new Poster("Тролли.  Мировой тур", "4881", "Мультфильмы", "????");
    Poster poster7 = new Poster("Номер один", "6140", "Комедия", "????");
    Poster poster8 = new Poster("Рыцари справедливости", "1963", "Драма", "????");
    Poster poster9 = new Poster("Момент истины", "3836", "Триллер", "????");
    Poster poster10 = new Poster("Довод", "5491", "Боевик", "????");
    Poster poster11 = new Poster("Не смотрите наверх", "2801", "Драма", "????");

    MoviesManager manager = new MoviesManager();

    @Test
    public void shouldAddNewMovies() {

        manager.addMovie(poster1);
        manager.addMovie(poster2);
        manager.addMovie(poster3);
        manager.addMovie(poster4);
        manager.addMovie(poster5);
        manager.addMovie(poster6);
        manager.addMovie(poster7);

        Poster[] expected = new Poster[] { poster1, poster2, poster3, poster4, poster5, poster6, poster7 };
        Poster[] actual = manager.getPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAddedMoviesInAddingOrder() {

        manager.addMovie(poster1);
        manager.addMovie(poster2);
        manager.addMovie(poster3);
        manager.addMovie(poster4);
        manager.findAll();

        Poster[] expected = new Poster[] { poster1, poster2, poster3, poster4 };
        Poster[] actual = manager.getPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAddedMoviesLimit() {

        manager.addMovie(poster1);
        manager.addMovie(poster2);
        manager.addMovie(poster3);
        manager.addMovie(poster4);
        manager.addMovie(poster5);
        manager.addMovie(poster6);
        manager.addMovie(poster7);
        manager.addMovie(poster8);
        manager.addMovie(poster9);
        manager.addMovie(poster10);

        Poster[] expected = new Poster[] {
                poster10,
                poster9,
                poster8,
                poster7,
                poster6,
                poster5,
                poster4,
                poster3,
                poster2,
                poster1
        };

        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAddedMoviesUnderLimit() {

        manager.addMovie(poster1);
        manager.addMovie(poster2);
        manager.addMovie(poster3);
        manager.addMovie(poster4);
        manager.addMovie(poster5);
        manager.addMovie(poster6);


        Poster[] expected = new Poster[] { poster6, poster5, poster4, poster3, poster2, poster1 };
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAddedMoviesAboveLimit() {

        manager.addMovie(poster1);
        manager.addMovie(poster2);
        manager.addMovie(poster3);
        manager.addMovie(poster4);
        manager.addMovie(poster5);
        manager.addMovie(poster6);
        manager.addMovie(poster7);
        manager.addMovie(poster8);
        manager.addMovie(poster9);
        manager.addMovie(poster10);
        manager.addMovie(poster11);

        Poster[] expected = new Poster[] {
                poster11,
                poster10,
                poster9,
                poster8,
                poster7,
                poster6,
                poster5,
                poster4,
                poster3,
                poster2
        };
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindLastWhen0MoviesAdded() {

        Poster[] expected = new Poster[] { };
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
