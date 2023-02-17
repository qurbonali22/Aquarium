package animals;

import aquarium.Aquarium;

public class Shark extends Animal {

    public Shark() {
    }

    public Shark(int x, int y, int z, int life, Aquarium aquarium) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.life = life;
        this.aquarium = aquarium;
    }

    @Override
    public void run() {
        while (life > 0){
            move();
            try {
                Thread.sleep(1000);
                life--;
                aquarium.checkWithShark(this);
//                System.out.println(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shark died because life = 0 : " + this);
    }

    @Override
    public String toString() {
        return "Shark{" +
                "name=" + getName() +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", life=" + life +
                '}';
    }

    public boolean checkWithShark(Fish fish) {
        return x == fish.x && y == fish.y && z == fish.z;
    }

    public void addLife(int life){
        this.life +=life;
    }
}
