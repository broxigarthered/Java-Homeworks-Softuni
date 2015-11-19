


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Map;

public class DragonArmy {
    public static final int BASE_HEALTH = 250;
    public static final int BASE_DAMAGE = 45;
    public static final int BASE_ARMOR = 10;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        ///       color , dragonName statsListInteger
        LinkedHashMap<String,TreeMap<String,List<Integer>>> typeAndDragon = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            int damage = 0;
            int health = 0;
            int armor = 0;

            String[] tokens = input.nextLine().split(" ");
            String type  = tokens[0];
            String name = tokens[1];
            if(tokens[2].equals("null")){
                damage = BASE_DAMAGE;
            }
            else{damage = Integer.parseInt(tokens[2]);}

            if(tokens[3].equals("null")){
                health = BASE_HEALTH;
            }
            else{health = Integer.parseInt(tokens[3]);}
            if(tokens[4].equals("null")){
                armor = BASE_ARMOR;
            }
            else{armor = Integer.parseInt(tokens[4]);}

            if(!typeAndDragon.containsKey(type)){
                typeAndDragon.put(type,new TreeMap<>());
            }
            typeAndDragon.get(type).put(name,new ArrayList<>());
            typeAndDragon.get(type).get(name).add(damage);
            typeAndDragon.get(type).get(name).add(health);
            typeAndDragon.get(type).get(name).add(armor);

        }


        for (Map.Entry<String, TreeMap<String, List<Integer>>> entry : typeAndDragon.entrySet()) {
            List<Double> currentAvg = getAverage(typeAndDragon, entry.getKey());
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n",
                    entry.getKey(),
                    currentAvg.get(0),
                    currentAvg.get(1),
                    currentAvg.get(2));

            TreeMap<String,List<Integer>> secondaryMap = entry.getValue();

            for (Map.Entry<String, List<Integer>> secondEntry : secondaryMap.entrySet()) {
                System.out.print("-"+secondEntry.getKey()+" -> "+
                                "damage: "+secondEntry.getValue().get(0)+", "+
                                "health: "+secondEntry.getValue().get(1)+", "+
                                "armor: "+secondEntry.getValue().get(2)+"\n"
                );

            }
        }

    }
    public static List<Double> getAverage(LinkedHashMap<String,TreeMap<String,List<Integer>>> map,String key){
        double avgDamage = 0;
        double avgHealth = 0;
        double avgArmor = 0;
        int cnt = 0;
        List<Double> omg = new ArrayList<>();

        for (Map.Entry<String, TreeMap<String, List<Integer>>> entry : map.entrySet()) {
            if(entry.getKey().equals(key)) {


                TreeMap<String, List<Integer>> secondaryMap = entry.getValue();

                for (Map.Entry<String, List<Integer>> secondEntry : secondaryMap.entrySet()) {
                    avgDamage += secondEntry.getValue().get(0);
                    avgHealth += secondEntry.getValue().get(1);
                    avgArmor += secondEntry.getValue().get(2);
                    cnt++;
                }
                omg.add(avgDamage/cnt);
                omg.add(avgHealth/cnt);
                omg.add(avgArmor/cnt);
                return omg;

            }
            else{continue;}

        }
        return null;

    }
}