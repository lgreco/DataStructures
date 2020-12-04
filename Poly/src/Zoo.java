public class Zoo {
    public static void main(String[] args) {

        Animal[] myZoo = new Animal[5];

        myZoo[0] = new Dog("plot hound");
        myZoo[1] = new Cat("persian");
        myZoo[2] = new Dog("boxer");
        myZoo[3] = new Animal();
        myZoo[4] = new Fish("parrot fish");

        for (Animal a: myZoo) {
            a.animalSound();
        }
    }
}
