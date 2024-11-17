package older.topics;


import java.util.*;

public class OverridingObjectMethods {

    public static void main(String ...args) {

        TreeMap<Person, String> people = new TreeMap<>();
        people.put(new Person("3456", "David"), "Testing1");
        people.put(new Person("5678", "David"), "Testing2");
        people.put(new Person("1234", "David"), "Testing3");
        people.put(new Person("4567", "David"), "Testing4");
        people.put(new Person("1234", "David"), "Testing5");

        for (Person p: people.keySet()) {
            System.out.println(p.getName() + " " + people.get(p));
        }

    }




}

class Person implements Comparable<Person>{
    private String documentID;
    private String name;

    public Person(String documentID, String name) {
        this.documentID = documentID;
        this.name = name;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person)obj;
        return name.equalsIgnoreCase(person.getName()) && documentID.equalsIgnoreCase(person.getDocumentID());
    }

    // The hashCode is necessary so the map can compare the instances of the object and classify it as already added or not
    @Override
    public int hashCode() {
        int result = name.hashCode();
        int documentId = documentID.hashCode();
        result = 31 * result + documentId;
        return result;
    }

    //This method from the interface comparable<T> is implemented if the instances of the class are made to be stored
    // in a treeSet or any kind of sortedList
    @Override
    public int compareTo(Person o) {
        return documentID.compareToIgnoreCase(o.getDocumentID());
    }
}