class Student {
    private int id;
    private String name;
    private int age;

    // Constructor
    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getter methods
    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    // Setter methods
    void setName(String name) {
        this.name = name;
    }

    void setAge(int age) {
        this.age = age;
    }

    // Display
    void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age);
    }
}