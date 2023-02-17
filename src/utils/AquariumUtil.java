package utils;

import enums.Gender;
import enums.Type;

import java.util.Random;

public class AquariumUtil {

    public static final int coordinateX = 5;
    public static final int coordinateY = 5;
    public static int coordinateZ = 5;
    public static final int totalAmount = (coordinateX + 1) * (coordinateY + 1) * (coordinateZ + 1);

    public static Random random = new Random();

    public static int getRandom(int n){
        return random.nextInt(n);
    }

    public static int getRandomBetween(int a, int b){
        return random.nextInt(a, b);
    }

    public static Gender getGender(){
        return random.nextInt(2)==0?Gender.MALE:Gender.FEMALE;
    }

    public static Type getType(){
        return random.nextInt(10)>=8?Type.PEDIGREED:Type.NOT_PEDIGREED;
    }
}
