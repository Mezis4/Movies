package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.data.Poster;
import ru.netology.repository.MoviesRepository;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MovieTestMockito {

    MoviesRepository repo = Mockito.mock(MoviesRepository.class);
    MoviesManager manager = new MoviesManager(repo);

    Poster poster1 = new Poster("Бладшот", 3024, "Боевик", "????");
    Poster poster2 = new Poster("Вперёд", 7302, "Мультфильм", "????");
    Poster poster3 = new Poster("Отель Белград", 5629, "Комедия", "????");
    Poster poster4 = new Poster("Джентельмены", 2480, "Боевик", "????");

    @Test
    public void shouldFindLastAddedMovies() {
        Poster[] posters = { poster1, poster2, poster3, poster4 };
        doReturn(posters).when(repo).getPosters();

        Poster[] expected = new Poster[] { poster4, poster3, poster2, poster1 };
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAddedMoviesInAddingOrder() {
        Poster[] posters = { poster1, poster2, poster3, poster4 };
        doReturn(posters).when(repo).getPosters();

        Poster[] expected = new Poster[] { poster1, poster2, poster3, poster4 };
        Poster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
