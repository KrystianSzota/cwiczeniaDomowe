package stream.movie;

class Movie {
    private final String name;
    private final Category category;
    private final AgeRestriction ageRestriction;
    private final long duration;
    private final Director director;

    Movie(String name, Category category, AgeRestriction ageRestriction, long duration, Director director) {
        this.name = name;
        this.category = category;
        this.ageRestriction = ageRestriction;
        this.duration = duration;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public Director getDirector() {
        return director;
    }

    public long getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Film {" +
                "Tytul: '" + name + '\'' +
                ", Kategoria: " + category +
                ", Ograniczenia wiekowe: " + ageRestriction +
                ", Czas trwania: " + duration +
                ", Rezyser: " + director +
                '}';
    }
}
