package collections.framework;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

public class Sets {
    public static void main(String[] args) {
        // Sets will only allow unique elements, if a duplicated element is added to it, that element will not be taken
        // into account, sets don't keep the order in which objects are added
        Set<Student> set = new HashSet<>();
        set.add(new Student("Pedro", 50));
        set.add(new Student("Lucas", 45));
        set.add(new Student("Martín", 60));
        set.add(new Student("Juan", 30));
        System.out.println("First set: " + set);

        //
        Set<Student> set2 = new HashSet<>();
        set2.add(new Student("Pedro", 50));
        set2.add(new Student("Felipe", 45));
        set2.add(new Student("Martín", 60));
        set2.add(new Student("Juan", 30));
        set2.add(new Student("Andrés", 56));
        System.out.println("Second set: " + set2);

        // Retains only the elements in this set that are contained in the specified collection
        set2.retainAll(set);
        System.out.println("After retaining");
        System.out.println("First set: " + set);
        System.out.println("Second set: " + set2);


    }
}
