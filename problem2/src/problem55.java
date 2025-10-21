import java.util.ArrayList;
import java.util.List;

public class problem55 {
    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        int n = 3;
        List<String> res = solution55.generateParenthesis(n);
        res.stream().forEach(System.out::println);

    }
}

class Solution55 {
    public List<String> generateParenthesis(int n) {
        StringBuffer path1 = new StringBuffer();
        ArrayList<String> res = new ArrayList<>();
        backtrace(res,path1,n,0,0);
        return res;
    }

    private void backtrace(ArrayList<String> res, StringBuffer path1, int n, int left, int right) {

        if (path1.length()== n *2){
            res.add(new String(path1));
        }

        if(left<n){
            path1.append("(");
            backtrace(res,path1,n,left+1,right);
            path1.deleteCharAt(path1.length()-1);
        }

        if (right < left){
            path1.append(")");
            backtrace(res,path1,n,left,right+1);
            path1.deleteCharAt(path1.length()-1);
        }

    }
}
