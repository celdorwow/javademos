public class Person {
    private final String name;
    private final int age;
    private final Sex gender;

    public enum Sex {
        FEMALE,
        MALE
    }

    public Person(String name, int age, Person.Sex gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return name + " (" + age + "), " + gender;
    }
}
