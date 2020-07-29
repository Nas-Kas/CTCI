import java.util.*;
/*

Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
that type). They cannot select which specific animal they would like. Create the data structures to
maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
and dequeueCat. You may use the built-in Linked list data structure.


- animal object
    - String type
    - int arrival time
- 
- two queues 
    - dog queue
    - cat queue

-enqueue 
    - if cat add to cat queue
    - if dog add to dog queue

-dequeueAny
    - compare the front of both queues to see which value is lower
    - dequeue the lower value
-dequeueCat
    - same process remove from cat queue
-dequeueDog
    - same process remove from dog queue
*/

class Animal{
    String type;
    int timeStamp;
    Animal(String ty){
        type = ty;
    }
}

class animalShelter{
    int count = 0;
    Queue<Animal> cats = new LinkedList<>();
    Queue<Animal> dogs = new LinkedList<>();

    void enqueue(Animal pet){
        pet.timeStamp = count;
        count++;
        if(pet.type.equals("cat")){
            cats.add(pet);
        }else{
            dogs.add(pet);
        }
    }

    void dequeueAny(){
        if(cats.isEmpty() && dogs.isEmpty()){
            System.out.println("Sorry were out of pets");
        }else if(cats.isEmpty()){
            dogs.poll();
        }else if(dogs.isEmpty()){
            cats.poll();
        }else{
            if(cats.peek().timeStamp > dogs.peek().timeStamp){
                dogs.poll();
            }else{
                cats.poll();
            }
        }
    }

    void dequeueCat(){
        if(!cats.isEmpty()){
            cats.poll();
        }else{
            System.out.println("no more cats");
        }
    }

    void dequeueDog(){
        if(!dogs.isEmpty()){
            dogs.poll();
        }else{
            System.out.println("no more dogs");
        }
    }

    void printQueue(Queue<Animal> q){
        Queue<Animal> test = new LinkedList<Animal>(q);
        while(!test.isEmpty()){
            Animal temp = test.poll();
            System.out.print("[" + temp.type + ":" + temp.timeStamp + "]");
        }
        System.out.println();
    }   

    public static void main (String [] args){
        animalShelter test = new animalShelter();
        test.enqueue(new Animal("dog"));
        test.enqueue(new Animal("dog"));
        test.enqueue(new Animal("dog"));
        test.printQueue(test.dogs);
        test.enqueue(new Animal("cat"));
        test.printQueue(test.cats);
        test.dequeueDog();
        test.printQueue(test.dogs);
        test.dequeueCat();
        test.printQueue(test.dogs);
        test.dequeueAny();
        test.printQueue(test.dogs);
        test.printQueue(test.cats);
        test.printQueue(test.dogs);
    }
}
