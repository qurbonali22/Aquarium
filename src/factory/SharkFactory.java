package factory;

import animals.Shark;
import aquarium.Aquarium;
import utils.AquariumUtil;

public class SharkFactory {

    public static Shark createShark(Aquarium aquarium){
        int x = AquariumUtil.getRandom(AquariumUtil.coordinateX+1);
        int y = AquariumUtil.getRandom(AquariumUtil.coordinateY+1);
        int z = AquariumUtil.getRandom(AquariumUtil.coordinateZ+1);
        int life = AquariumUtil.getRandomBetween(5,20);

        return new  Shark(x, y, z, life, aquarium);
    }
}
