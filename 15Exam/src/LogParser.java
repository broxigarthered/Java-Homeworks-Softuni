/**
 * Created by adelinadutskinova on 11/15/15.
 */
import apple.laf.JRSUIUtils;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogParser {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //we take the input
        String line = input.nextLine();
        String pat = "\\{\\\"Project\\\"\\:\\s+\\[\\\"([A-Za-z0-9]+)\\\"\\]\\,\\s\\\"Type\\\":\\s\\[\\\"([A-Za-z]+)\\\"\\],\\s\\\"Message\\\":\\s\\[\\\"(.*?)\\\"\\]}";
        Pattern pattern = Pattern.compile(pat);
        LinkedHashMap<String,TreeMap<String,List<String>>> map = new LinkedHashMap<>();
        Map<String,Integer> errorsCounter = new LinkedHashMap<>();

        while(!line.equals("END")){
            Matcher match = pattern.matcher(line);

            while(match.find()) {
                //{"Project": ["ProjectName"], "Type": ["ErrorType"], "Message": ["ErrorMessage"]}
                String projectName = match.group(1);
                String errorType = match.group(2);
                String message = match.group(3);

                //main logic
                if (!map.containsKey(projectName)){
                    map.put(projectName,new TreeMap<>());
                }
                List<String> oldMessages = map.get(projectName).put(errorType,
                        map.get(projectName).get(errorType));
                if(oldMessages == null){
                    map.get(projectName).put(errorType,new ArrayList<>());
                }
                if(!map.get(projectName).containsKey(errorType)){
                    map.get(projectName).get(errorType).add(message);
                }

                //filling the second map
                Integer oldValue = errorsCounter.get(projectName);
                if(oldValue == null){
                    oldValue=0;
                }
                errorsCounter.put(projectName,oldValue+map.get(projectName).get(errorType).size());


                map.get(projectName).get(errorType).add(message);
            }


            line = input.nextLine();
        }
        LinkedHashMap<String,TreeMap<String,List<String>>> finalMap = new LinkedHashMap<>();
        List<Map.Entry<String,Integer>> countingMap = entriesSortedByValues(errorsCounter);
        for (Map.Entry<String, Integer> entry : countingMap) {

            for (Map.Entry<String, TreeMap<String, List<String>>> mapEntry : map.entrySet()) {
                String result = entry.getKey() + ":\n";

                String currentKey= entry.getKey();

                if(!finalMap.containsKey(currentKey)){
                    finalMap.put(currentKey,new TreeMap<>());
                }

                finalMap.put(currentKey,map.get(currentKey));
            }
        }

        //FINALY outputing
        for (Map.Entry<String, TreeMap<String, List<String>>> entry : finalMap.entrySet()) {
            int warnings = 0;
            int critical = 0;

            TreeMap<String,List<String>> innerMap = new TreeMap<>();
            TreeMap<String,List<String>> newInnerMap = new TreeMap<>();

            String result = entry.getKey()+":\n";


            List<String> currentc = finalMap.get(entry.getKey()).get("Critical");
            List<String> currentw = finalMap.get(entry.getKey()).get("Warning");

            int totalErrors = 0;
            if(currentc == null){
                totalErrors+=0;
                critical= 0;
            }
            else{totalErrors += currentc.size();
            critical += currentc.size();}

            if(currentw == null){
                totalErrors+=0;
                warnings = 0;
            }
            else{totalErrors += currentw.size();
            warnings += currentw.size();}




            result +="Total Errors: "+ totalErrors + "\n";
            result +="Critical: "+ critical + "\n";
            result +="Warnings: " + warnings+"\n";

                TreeMap<String,List<String>> omgkur = sorthTheMap(finalMap.get(entry.getKey()));

                List<String> curretCritical = finalMap.get(entry.getKey()).get("Critical");
                List<String>  currentCritical = omgkur.get("Critical");
                result+= "Critical Messages:\n";
                //TODO sort the list
                if(currentCritical == null){
                    result+="--->None\n";
                }
                else{
                    for (int i = 0; i < currentCritical.size(); i++) {
                        result+="--->"+currentCritical.get(i)+"\n";
                    }}

                //WARNINGS
                List<String> currentWarrnings = finalMap.get(entry.getValue().keySet());
                result+= "Warning Messages:\n";
                //TODO sort the list
                if(currentWarrnings!=null) {
                    StringLengthListSort ss = new StringLengthListSort();
                    Collections.sort(currentWarrnings, ss);
                }

                if(currentWarrnings == null){
                    result += "--->None\n";
                }
                else {
                    for (int i = 0; i < currentWarrnings.size(); i++) {
                        result += "--->" + currentWarrnings.get(i) + "\n";
                    }
                }

                result+="\n";
            System.out.println(result.substring(0,result.length()-1));



        }



    }
    public static TreeMap<String,List<String>> sorthTheMap(TreeMap<String,List<String>> sortMap){
        TreeMap<String,List<String>> sortingTheMap = new TreeMap<>();
        for (Map.Entry<String, List<String>> entry : sortMap.entrySet()) {
            List<String> currentList = entry.getValue();

            Comparator<String> x = new Comparator<String>()
            {
                @Override
                public int compare(String o1, String o2)
                {
                    if(o1.length() > o2.length())
                        return 1;

                    if(o2.length() > o1.length())
                        return -1;

                    return 0;
                }
            };
            Collections.sort(currentList,  x);
            sortingTheMap.put(entry.getKey(),currentList);
            return sortingTheMap;
        }
        return null;

    }

    static class StringLengthListSort implements Comparator<String>{
        @Override
        public int compare(String s1, String s2) {
            return s2.length() - s1.length();
        }
    }

    static <K,V extends Comparable<? super V>>
    List<Map.Entry<K, V>> entriesSortedByValues(Map<K,V> map) {

        List<Map.Entry<K,V>> sortedEntries = new ArrayList<Map.Entry<K,V>>(map.entrySet());

        Collections.sort(sortedEntries, new Comparator<Map.Entry<K,V>>() {
            @Override
            public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });
        return sortedEntries;
    }




}
