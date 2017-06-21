package findfriendsofa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.Set;

/*
INPUT : 
A - B C D E F
C - F H
D - G I J
H - I K 
X - Y Z
S - T U V
U - M N
*/

public class FindFriendsOfA {

    public static void main(String[] args) {

        HashMap<String, ArrayList<String>> map = getInput();
        //firendsOfA(map);
        numberOfGroups(map);
    }

    private static void firendsOfA(HashMap<String, ArrayList<String>> map) {
        Queue<String> queue = new ArrayDeque<>();
        ArrayList al = new ArrayList();
        Set<String> set = new LinkedHashSet<>();
        queue.addAll(map.get("a"));

        while (!queue.isEmpty()) {
            String s = queue.poll();
            set.add(s);
            if (map.containsKey(s)) {
                queue.addAll(map.get(s));
            }
        }
        System.out.println(set);
    }

    private static void numberOfGroups(HashMap<String, ArrayList<String>> map) {

        Set<String> flagset = new HashSet<>();
        ArrayList<Set> al = new ArrayList<>();
        Set<String> set = map.keySet();
        for (String s : set) {
            if (flagset.contains(s)) {

            } else {
                flagset.add(s);
                Queue<String> queue = new ArrayDeque<>();
                Set<String> queuesave = new HashSet<>();
                queue.addAll(map.get(s));
                while (!queue.isEmpty()) {
                    String s1 = queue.poll();
                    queuesave.add(s1);
                    flagset.add(s1);
                    if (map.containsKey(s1)) {
                        queue.addAll(map.get(s1));
                    }
                }
                al.add(queuesave);
            }
        }
        for(int i=0;i<al.size();i++)
        System.out.println(al.get(i));

    }

    private static HashMap<String, ArrayList<String>> getInput() {

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        ArrayList<String> al = new ArrayList<>();

        al.add("b");
        al.add("c");
        al.add("d");
        al.add("e");
        map.put("a", al);
        al = new ArrayList<>();
        al.add("f");
        al.add("h");
        map.put("c", al);
        al = new ArrayList<>();
        al.add("g");
        al.add("i");
        al.add("j");
        map.put("d", al);
        al = new ArrayList<>();
        al.add("i");
        al.add("k");
        map.put("h", al);
        al = new ArrayList<>();
        al.add("y");
        al.add("z");
        map.put("x", al);
        al = new ArrayList<>();
        al.add("t");
        al.add("u");
        al.add("v");
        map.put("s", al);
        al = new ArrayList<>();
        al.add("m");
        al.add("n");
        map.put("u", al);
        
        return map;
    }

}
