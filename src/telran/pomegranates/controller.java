package telran.pomegranates;

import telran.pomegranates.model.Box;
import telran.pomegranates.model.Pomegranate;
import telran.pomegranates.model.Seed;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class controller {
    static Random random = new Random();
    public static void main(String[] args) {
        int BOX_AMOUNT = random.nextInt(201-100) + 100;
        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < BOX_AMOUNT; i++) {
            boxes.add(generateRandomBox(Integer.toString(i)));
        }
        System.out.println("============TotalSeeds===========");
        long res =  boxes.stream()
                .flatMap((box) -> StreamSupport.stream(box.spliterator(),false))
                .flatMap((pomegranate) -> StreamSupport.stream(pomegranate.spliterator(),false))
                .count();
        System.out.println(res);
        System.out.println("=========MaxSeeds================");
        long max = boxes.stream()
                .map(box -> {
                    long count = StreamSupport.stream(box.spliterator(),false)
                            .flatMap(granate ->StreamSupport.stream(granate.spliterator(),false))
                            .count();
                    return count;
                })
                .reduce(0l,(acc,seeds)-> acc > seeds? acc : seeds);
        System.out.println(max);
        System.out.println("=========MaxNames================");
        List<String> names = boxes.stream()
                .filter(box ->{
                    long count = StreamSupport.stream(box.spliterator(),false)
                            .flatMap(granate ->StreamSupport.stream(granate.spliterator(),false))
                            .count();
                    return count == max;
                })
                .map(box -> box.getName())
                .collect(Collectors.toList());
        names.forEach(System.out::println);
    }

    private static Box generateRandomBox(String name){
        List<Pomegranate> granates = new ArrayList<>();
        int GRANATES_AMOUNT = random.nextInt(21-10)+10;
        for (int i = 0; i < GRANATES_AMOUNT; i++) {
            granates.add(generateRandomPomegranate());
        }
        return new Box(granates,name);
    }

    private static Pomegranate generateRandomPomegranate(){
        List<Seed> seeds = new ArrayList<>();
        int SEEDS_AMOUNT = random.nextInt(701-400) + 400;
        for (int i = 0; i < SEEDS_AMOUNT; i++) {
            seeds.add(new Seed(2));
        }
        return new Pomegranate(seeds);
    }
}
