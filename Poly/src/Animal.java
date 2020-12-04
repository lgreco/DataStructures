public class Animal {

    private String species;
    private String sound;

    public Animal() {
        species = "unspecified animal";
        sound = "default sound";
    }

    public Animal(String species) {
        this.species = species;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void animalSound() {
        System.out.printf("\n\n The %s makes this sound: %s.\n",species,sound);
    }
}