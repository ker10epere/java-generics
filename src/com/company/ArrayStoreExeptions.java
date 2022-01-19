package com.company;

import com.company.models.Animal;
import com.company.models.cat.Cat;
import com.company.models.dog.Dog;

public class ArrayStoreExeptions {
    public static void main(String[] args) {
        Dog[] dogs = {new Dog(), new Dog()};
        addAnimal(dogs);
        // java.lang.ArrayStoreException
        // JVM knows the type of parameter animals in addAnimal
    }

    public static void addAnimal(Animal[] animals){
        animals[0] = new Dog();
        animals[1] = new Cat();
    }

}
