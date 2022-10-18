package stream.movie;

import java.util.*;
import java.util.stream.Collectors;

public class MovieManager {
    private Set<Movie> movies = new HashSet<>();

    public MovieManager addMovie(Movie movie) {
        movies.add(movie);
        return this;
    }

    public List<Movie> findMoviesWithCategory(Category category) {
        return movies.stream()
                .filter((movie) -> movie.getCategory() == category)
                .collect(Collectors.toList());
    }

    public List<Movie> getMovieByAgeRestriction(AgeRestriction ageRestriction) {
        return movies.stream()
                .filter((movie) -> movie.getAgeRestriction() == ageRestriction)
                .collect(Collectors.toList());
    }

    public List<Movie> getAllMoviesSortedByDuration() {
        return movies.stream()
                .sorted((movie1, movie2) -> compareMoviesByDuration(movie1, movie2))
                .collect(Collectors.toList());
    }

    public String getAllDirectors() {
        return movies.stream()
                .map(movie -> movie.getDirector().getName())
                .distinct()
                .collect(Collectors.joining(", "));
    }

    public Set<String> getAllDirectorsSet() {
        return movies.stream()
                .map(movie -> movie.getDirector().getName())
                .collect(Collectors.toSet());
    }

    public List<Movie> getAllMoviesSortedByDurationDesc() {
        return movies.stream()
                .sorted(Comparator.comparingLong(Movie::getDuration).reversed())
                .collect(Collectors.toList());
    }

    public Optional<Movie> findLongestMovie() {
        return movies.stream()
                .max((movie1, movie2) -> Long.compare(movie1.getDuration(), movie2.getDuration()));
    }

    public Optional<Movie> findShortestMovie() {
        return movies.stream()
                .min(Comparator.comparingLong(Movie::getDuration));
    }

    public boolean existMovieDirectedBy(String directorName) {
        return movies.stream()
                .anyMatch(movie -> movie.getDirector().getName().equalsIgnoreCase(directorName));
    }

    private int compareMoviesByDuration(Movie movie1, Movie movie2) {
//        return movie1.getDuration() > movie2.getDuration()
//                ? 1
//                : (movie1.getDuration() == movie2.getDuration() ? 0 : -1);

        return Long.compare(movie1.getDuration(), movie2.getDuration());
    }
}
