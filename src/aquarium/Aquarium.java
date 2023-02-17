package aquarium;

import animals.Fish;
import animals.Shark;
import enums.Gender;
import enums.Type;
import factory.FishFactory;
import factory.SharkFactory;
import utils.AquariumUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Aquarium {
    private List<Fish> fishList = new LinkedList<>();
    private Shark shark;
    public void start(){
        int count = 20;/* AquariumUtil.getRandom(20);*/

        for (int i = 0; i < count; i++) {
            fishList.add(FishFactory.createFish(this));
        }
        shark = SharkFactory.createShark(this);

        fishList.forEach(Thread::start);
        shark.start();

//        System.out.println(shark);
//        fishList.forEach(System.out::println);
    }

    public void checkForCollision(Fish fish){
        synchronized (fishList) {
            if (fishList.size() < AquariumUtil.totalAmount) {
                ListIterator<Fish> iterator = fishList.listIterator();
                Fish f;
                while (iterator.hasNext()) {
                    f = iterator.next();
                    if (fish.collision(f)) {
                        int child = fish.getType().equals(Type.PEDIGREED) || f.getType().equals(Type.PEDIGREED)?AquariumUtil.getRandomBetween(2,4):1;
                        for (int i = 0; i < child; i++) {
                            Fish babyFish = FishFactory.createFish(this);
                            String str = String.format("Collision: Fish1 - {%s}, Fish2 - {%s}, baby - {%s}", fish.getName(), f.getName(), babyFish.getName());
                            iterator.add(babyFish);
                            babyFish.start();
                            System.out.println(str);
                            if (fishList.size() + i + 1 >= AquariumUtil.totalAmount) break;
                        }
                    }
                }
            }
            printDetail();
        }
    }

    public void checkWithShark(Shark shark){
        synchronized (fishList){
            ListIterator<Fish> listIterator = fishList.listIterator();
            Fish fish ;
            while (listIterator.hasNext()){
                fish = listIterator.next();
                if (shark.checkWithShark(fish)){
                    listIterator.remove();
                    shark.addLife(fish.life);
                    System.out.println("---------------------");
                    System.out.println("Fish dead reason{Fish killed by Shark} : " + fish );
                    System.out.println("---------------------");
                }
            }
        }
    }

    public void printDetail(){
        int male = 0;
        int pedigreed = 0;

        for (Fish fish : fishList) {
            if(fish.getGender().equals(Gender.MALE)) male++;
            if (fish.getType().equals(Type.PEDIGREED)) pedigreed++;
        }

        System.out.println("======================");
        System.out.println("Total fish count : " + fishList.size());
        System.out.println("Male fish : " + male);
        System.out.println("Female fish : " + (fishList.size()-male));
        System.out.println("Pedigreed : " + pedigreed);
        System.out.println("NotPedigreed : " + (fishList.size()-pedigreed));
        System.out.println("======================");
    }

    public void removeFish(Fish fish) {
        synchronized (fishList) {
            fishList.remove(fish);
            System.out.println("---------------------");
            System.out.println("Fish dead reason{lifeTime is over} : " + fish );
            System.out.println("---------------------");
        }
    }
}
