package factory;

import animals.Fish;
import aquarium.Aquarium;
import enums.Gender;
import enums.Type;
import utils.AquariumUtil;

public class FishFactory {

    public static Fish createFish(Aquarium aquarium){
        int x = AquariumUtil.getRandom(AquariumUtil.coordinateX+1);
        int y = AquariumUtil.getRandom(AquariumUtil.coordinateY+1);
        int z = AquariumUtil.getRandom(AquariumUtil.coordinateZ+1);
        int life = AquariumUtil.getRandomBetween(5,20);
        Gender gender = AquariumUtil.getGender();
        Type type = AquariumUtil.getType();

        return new Fish(x, y, z, life, gender, type, aquarium);
    }

}
