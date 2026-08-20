  class Person {
            String name;
            int age;

            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            void introduce() {
                System.out.println(name + " is " + age + " years old.");
            }
        }
public class Oop {
    public static void main(String[] args) {
       Person[] people = {
        new Person("Ben", 10),
        new Person("Mary", 6),
        new Person("Leo", 8),
    };

    for (Person person : people) {
        person.introduce();
    }
    }
}

