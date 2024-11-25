package collections.framework;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import static java.util.Comparator.comparingInt;

public class Queues {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("David", 69));
        students.add(new Student("Artemis", 68));
        students.add(new Student("Daniela", 76));
        students.add(new Student("Maritza", 45));
        students.add(new Student("Philip", 75));
        System.out.println(students);

        // In order to be able to add a set of objects to a priority queue we need to implement either a comparator or
        // comparable in the class we want to compare, that way the priorityQueue has an attribute to compare each object
        PriorityQueue<Student> pq = new PriorityQueue<>((a, b)-> b.getMaths() - a.getMaths());
        for (Student st : students) {
            pq.offer(st);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }


    }
}

class Student {
    private String name;
    private int maths;

    public Student(String name, int maths) {
        this.name = name;
        this.maths = maths;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        Student other = (Student) obj;
        return name.equalsIgnoreCase(other.getName()) && hashCode()== obj.hashCode();
    }

    @Override
    public String toString() {
        return name + ": " + maths;
    }
}
