package hash.code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String a = "aed";
        System.out.println(sortString(a));

    }

//    1. 两数之和
//            简单
//    相关标签
//            相关企业
//    提示
//    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//
//    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
//    你可以按任意顺序返回答案。

    //暴力破解
    public int[] twoSum(int[] nums, int target) {
        //定义一个数组存结果
        int[] result = new int[2];

        //2个for循环寻找符合的条件
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target){
                    result = new int[]{i, j};
                    return result;
                }
            }
        }
        //返回结果
        return result;

    }

    //
    public int[] twoSum1(int[] nums, int target) {
        //定义一个数组存结果
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        //2个for循环寻找符合的条件
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                result= new int[]{i,map.get(nums[i])};
                return  result;
            }
            map.put(target-nums[i],i);
        }

        //返回结果
        return result;

    }

//    49. 字母异位词分组
//            中等
//    相关标签
//            相关企业
//    给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
//    字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
//
//    示例 1:
//
//    输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//    输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//    示例 2:
//
//    输入: strs = [""]
//    输出: [[""]]
//    示例 3:
//
//    输入: strs = ["a"]
//    输出: [["a"]]


    //暴力解
    public static List<List<String>> groupAnagrams(String[] strs) {
        //定义数组存放结果
        List<List<String>> lists = new ArrayList<List<String>>();
        HashMap<String,Integer> resMap = new HashMap<>();

        //定义一个strs的镜像
        String[] strsTmp = new String[strs.length];


        //对strs里面的元素排序
        for (int i = 0; i < strs.length; i++) {
            strsTmp[i] = sortString(strs[i]);
        }
        //记录数组个数
        int count = 0;

        //循环打印相同的元素
        for (int i = 0; i < strs.length; i++) {
            if (resMap.containsKey(strsTmp[i])){
                lists.get(resMap.get(strsTmp[i])).add(strs[i]);
            }else {
                resMap.put(strsTmp[i],count++);
                ArrayList<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                lists.add(strings);
            }

        }
         resMap.values().toArray();
        return lists;

    }

    public static String sortString(String s){
        int[] ints = new int[s.length()];
        char[] chars = s.toCharArray();
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            ints[i]=chars[i];
        }
        Arrays.sort(ints);
        for (int i = 0; i < s.length(); i++) {
            res += (char)ints[i];
        }
        return res;
    }
}
