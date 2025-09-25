import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class problem2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    }
}


class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        return map.values().stream().collect(Collectors.toList());
    }
}