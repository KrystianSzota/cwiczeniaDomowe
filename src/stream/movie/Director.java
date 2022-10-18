package stream.movie;

class Director {
    private final String name;
    private final int age;

    Director(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
