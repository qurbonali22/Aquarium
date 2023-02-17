package animals;

import aquarium.Aquarium;
import enums.Gender;
import enums.Type;

public class Fish extends Animal {
    private Gender gender;
    private Type type;

    public Fish() {
    }

    public Fish(int x, int y, int z, int life, Gender gender, Type type, Aquarium aquarium) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.life = life;
        this.gender = gender;
        this.type = type;
        this.aquarium = aquarium;
    }

    @Override
    public void run() {
        while (life > 0){
            move();
            try {
                Thread.sleep(1000);
                life--;
                aquarium.checkForCollision(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        aquarium.removeFish(this);
    }

    public Gender getGender() {
        return gender;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "name=" + getName() +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", life=" + life +
                ", gender=" + gender +
                ", type=" + type +
                '}';
    }

    public boolean collision(Fish fish) {
        return this.x == fish.x && this.y == fish.y && this.z == fish.z && !this.gender.equals(fish.gender);
    }
}
