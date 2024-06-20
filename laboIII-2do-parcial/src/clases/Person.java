package clases;

import java.util.Objects;

public class Person {
    private String fullName;
    private Integer age;
    private String neighbourhood;
    private String id;
    private String occupation;
    private Integer kit;

    public Person() {
    }

    public Person(String fullName, Integer age, String neighbourhood, String id, String occupation) {
        this.fullName = fullName;
        this.age = age;
        this.neighbourhood = neighbourhood;
        this.id = id;
        this.occupation = occupation;
    }

    public Person(String fullName, Integer age, String neighbourhood, String id, String occupation, Integer kit) {
        this.fullName = fullName;
        this.age = age;
        this.neighbourhood = neighbourhood;
        this.id = id;
        this.occupation = occupation;
        this.kit = kit;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getKit() {
        return kit;
    }

    public void setKit(Integer kit) {
        this.kit = kit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", neighbourhood='" + neighbourhood + '\'' +
                ", id='" + id + '\'' +
                ", occupation='" + occupation + '\'' +
                ", kit=" + kit +
                '}';
    }
}
