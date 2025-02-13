package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {
    public boolean checckchar(char[] current){
        int flag = 0;
        for (char c : current) {
            if (c == '(') {
                flag++;
            } else if (c == ')') {
                flag--;
            }
            if (flag < 0) {
                return false;
            }
        }
        return flag == 0;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length){
            if (checckchar(current)){
                result.add(new String(current));
            }
        }else {
            current[pos] = '(';
            generateAll(current,pos+1,result);
            current[pos] = ')';
            generateAll(current,pos+1,result);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateAll(new char[2 * n],0,res);
        return res;
    }

    public static void generateAns(int[] num,ArrayList<Integer> ans,int pos,List<List<Integer>> res){
        ArrayList<Integer> tAns = new ArrayList<>(ans);
        for (int i = pos; i < num.length; i++) {
            ans = new ArrayList<>(tAns);
            ans.add(num[i]);
            res.add(ans);
            generateAns(num,ans,i+1,res);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> ans = new ArrayList<>();
        res.add(ans);
        generateAns(nums,ans,0,res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
