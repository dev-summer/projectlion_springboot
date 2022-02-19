package basic;

public abstract class AbstractPerson implements Person {
    private String name;
    private int age;

    public AbstractPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void speak() {
        System.out.println(name + "의 나이는 " + age + "세 입니다.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AbstractPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
