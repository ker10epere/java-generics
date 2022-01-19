package com.company;

import com.company.models.Animal;
import com.company.models.cat.Cat;
import com.company.models.cat.impl.Manx;
import com.company.models.dog.Dog;
import com.company.models.dog.impl.Terrier;

import java.util.ArrayList;
import java.util.List;

public class Polymorphism {
    public static void addAnimal(Animal[] animals){
        animals[0] = new Dog();
        animals[1] = new Cat();
    }
    public static void addAnimal(List<Animal> animals){
        animals.add(new Dog());
    }

    public static void main(String[] args) {
        // polymorphism okay for the base type; List -> Arraylist
        List<Cat> cat = new ArrayList<Cat>();
        // polymorphism not okay for the generic type; Animal -> Cat
//        List<Animal> animals = new ArrayList<Cat>();
        List<Cat> cat2 = new ArrayList<Cat>(); // generics on both sides must match
        List<Cat> cat3 = new ArrayList<>();    // or use type inference
        // As the JVM does not know the types (stripped out during type erasure), the
        // compiler has to step in.
//        addAnimal(cats2);



        // inherits from top to bottom
        //         Object
        //         Animal
        //     Dog    -   Cat
        //   Terrier  -   Manx


        // reads from current type parameter to bottom
        // 1b. 'extends' - polymorphic assignments
        // Note: extends is read-only
        List<? extends Animal> animals1 = new ArrayList<Animal>();
//        animals1.add(new Animal()); // read-only
        List<? extends Animal> animals2 = new ArrayList<Dog>();
        List<? extends Animal> animals3 = new ArrayList<Terrier>();
        List<? extends Animal> animals4 = new ArrayList<Cat>();
        List<? extends Animal> animals5 = new ArrayList<Manx>();
//        List<? extends Animal> animals6 = new ArrayList<Object>();
        // error, current type Animal is the most top of the hierarchy
        // cant read above Animal


        // from current type parameter to above
        // 1c. 'super' - polymorphic assignments
        List<? super Dog> dogs1 = new ArrayList<Dog>();
        dogs1.add(new Dog());
        List<? super Dog> dogs2 = new ArrayList<Animal>();
        List<? super Dog> dogs3 = new ArrayList<Object>();
//        List<? super Dog> dogs4 = new ArrayList<Terrier>();


        // 2. declarations for 'extends' and 'super' examples
        List<Animal> animals   = new ArrayList<>(); animals.add(new Animal());
        List<Cat> cats         = new ArrayList<>(); cats.add(new Cat());
        List<Manx> manxCats    = new ArrayList<>(); manxCats.add(new Manx());
        List<Dog> dogs         = new ArrayList<>(); dogs.add(new Dog());
        List<Terrier> terriers = new ArrayList<>(); terriers.add(new Terrier());


        // 3. extends
        // ext(List<? extends Animal> list) => readonly
        ext(animals);
        // Animal is-an Animal      - OK
        ext(cats);
        // Cat is-an Animal      - OK
        ext(manxCats);
        // Manx is-an Animal      - OK
        ext(dogs);
        // Dog is-an Animal      - OK
        ext(terriers);
        // Terrier is-an Animal      - OKl is-an Animal      - OK

    }

    public static void ext(List<? extends Animal> list){

    }

}
