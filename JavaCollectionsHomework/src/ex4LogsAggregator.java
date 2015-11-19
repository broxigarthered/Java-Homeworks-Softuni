/**
 * Created by adelinadutskinova on 10/25/15.
 */


import java.util.*;

public class ex4LogsAggregator {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        TreeMap<String, Integer> durations = new TreeMap<>(); // i tva ima user
        HashMap<String, TreeSet<String>> ipAddresses = new HashMap<>(); // i tova ima user

        int n = Integer.parseInt(input.nextLine());

        int cnt = 0;
        String line = input.nextLine();

        while(cnt<n){
            String[] tokens = line.split(" ");
            //User: duration, IPs
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            Integer oldDuration = durations.get(user); // vzimame value-to na user-a
            if(oldDuration == null){                   // ako e null da stane 0 da ne dava gre6ka
                oldDuration = 0;
            }
            durations.put(user,oldDuration+duration);   // adddvame durationa

            TreeSet<String> ipSet = ipAddresses.get(user); // vzimame value-to sprqmo user-a
            if(ipSet == null){                  //
                ipSet = new TreeSet<>();
            }
            ipSet.add(ip);
            ipAddresses.put(user,ipSet);

            line = input.nextLine();
            cnt++;
        }

        for (Map.Entry<String, Integer> userAndDuration : durations.entrySet()) {
            String user = userAndDuration.getKey();
            int duration = userAndDuration.getValue();
            TreeSet<String> ipSet = ipAddresses.get(user); // da vzemem value-to za vseki user
            System.out.printf("%s: %d %s\n",user,duration,ipSet);
        }




    }
}
