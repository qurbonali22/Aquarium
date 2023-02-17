package animals;

import aquarium.Aquarium;
import utils.AquariumUtil;

public abstract class Animal extends Thread{

    public int x;
    public int y;
    public int z;
    public int life;
    public Aquarium aquarium;

    public abstract void run();
    public abstract String toString();
    public void move() {
        int direction = AquariumUtil.getRandom(6);
//         0-up, 1-down, 2-right, 3-left, 4-front, 5-back
        switch (direction) {
            case 0 -> {
                if (z < AquariumUtil.coordinateZ) z++;
            }
            case 1 -> {
                if (z > 0) z--;
            }
            case 2 -> {
                if (x < AquariumUtil.coordinateX) x++;
            }
            case 3 -> {
                if (x > 0) x--;
            }
            case 4 -> {
                if (y < AquariumUtil.coordinateY) y++;
            }
            case 5 -> {
                if (y > 0) y--;
            }
        }
    }
}
