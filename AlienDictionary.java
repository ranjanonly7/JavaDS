package LinkedInQuestions;

import java.util.*;

/**
 * Created by rmukherj on 8/5/16.
 * There is a new alien language which uses the latin alphabet. The order is unknown. You receieve a list
 * of words from the dictionary where words are sorted lexicographically by the rules of this new language.
 * Given the following words in the dictionary
 * [
 *      "wrt",
 *      "wrf",
 *      "er",
 *      "ett",
 *      "rftt"
 * ]
 *
 * the correct order is wertf
 */
public class AlienDictionary {
    public String alienWords(String[] words){
    Map<Character, Set<Character>> graph = new HashMap<>();
    for(int i=0;i<words.length;i++){
        String curr = words[i];
        for(int j=0;j<curr.length();j++){
            if(!graph.containsKey(curr.charAt(j))){
                graph.put(curr.charAt(j), new HashSet<Character>());
            }
        }

        if(i>0){
            connectGraph(graph, words[i-1],curr);
        }
    }
    //Step 2 Topological Sorting
        StringBuffer sb = new StringBuffer();
        Map<Character,Integer> visited = new HashMap<>();
        Iterator it = graph.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            char vertexId = (char)pair.getKey();
            if(topologicalSort(vertexId, graph, sb, visited)==false){
                return "";
            }
        }

        return sb.toString();


}

    private boolean topologicalSort(char vertexId, Map<Character, Set<Character>> graph, StringBuffer sb, Map<Character, Integer> visited) {
        if(visited.containsKey(vertexId)){
            if(visited.get(vertexId) == -1){
                return false;
            }

            if(visited.get(vertexId) == 1){
                return true;
            }


        }else {
            visited.put(vertexId,-1);
        }

        Set<Character> neighbors = graph.get(vertexId);
        for(char neighbor:neighbors){
            if(topologicalSort(neighbor,graph, sb,visited)== false){
                return false;
            }
        }

        sb.insert(0, vertexId);
        visited.put(vertexId,1);
        return true;

    }

    private void connectGraph(Map<Character, Set<Character>> graph, String prev, String curr) {
        if(prev == null || curr == null){
            return;
        }

        int len = Math.min(prev.length(), curr.length());

        for(int i=0;i<len;i++){
            char p = prev.charAt(i);
            char q = curr.charAt(i);
            if(p!=q){
                if(!graph.get(p).contains(q)){
                    graph.get(p).add(q);
                }
                break;
            }
        }
    }

    public static void main(String[] args){
        AlienDictionary al = new AlienDictionary();
        List<String> ls = new ArrayList<>();
        ls.add("wrt");
        ls.add("wrf");
        ls.add("er");
        ls.add("ett");
        ls.add("rftt");
        String[] arr = {"wrt", "wrf", "er", "ett", "rftt"};
        String arr1 = al.alienWords(arr);
        System.out.println(arr1);

    }
}
