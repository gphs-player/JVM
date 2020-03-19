package stack;

import java.util.HashSet;

class Dog {
    String color;

    public Dog(String s) {
        color = s;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dog))return false;
        if (this == o) return true;
        Dog dog = (Dog) o;
        return color != null ? color.equals(dog.color) : dog.color == null;
    }
    public int hashCode(){
        return color.length();//for simplicity reason
    }

}

public class SetAndHashCode {
    public static void main(String[] args) {
        HashSet<Dog> dogSet = new HashSet<Dog>();
        Dog white = new Dog("white");
        dogSet.add(white);
        white.setColor("red");
        System.out.println("We have " + dogSet.size() + " white dogs!");

        if (dogSet.contains(white)) {
            System.out.println("We have a white dog!");
        } else {
            System.out.println("No white dog!");
        }
    }
}