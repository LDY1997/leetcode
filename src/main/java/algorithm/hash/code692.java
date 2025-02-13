package algorithm.hash;

import java.util.*;

public class code692 {
//    给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
//
//    返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
//
//
//
//    示例 1：
//
//    输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//    输出: ["i", "love"]
//    解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
//    示例 2：
//
//    输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
//    输出: ["the", "is", "sunny", "day"]
//    解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> cnt = new HashMap<String, Integer>();
// 创建一个 HashMap，用于存储单词及其出现次数。
// 键 (Key) 是 String 类型，表示单词。
// 值 (Value) 是 Integer 类型，表示单词出现的次数。
// 变量名 'cnt' 可以理解为 'count' 的缩写。

        for (String word : words) {
            // 遍历输入的单词列表 'words'。
            // 'words' 应该是之前定义的，包含需要统计的单词集合。
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
            // 对于遍历到的每个单词 'word'，执行以下操作：
            // cnt.getOrDefault(word, 0)：尝试从 HashMap 'cnt' 中获取键为 'word' 的值 (即出现次数)。
            //                          如果 'word' 存在于 HashMap 中，则返回其对应的值。
            //                          如果 'word' 不存在于 HashMap 中，则返回默认值 0。
            // + 1：将获取到的值 (或默认值 0) 加 1，表示单词 'word' 出现次数增加了一次。
            // cnt.put(word, ... )：将计算后的新的出现次数放回 HashMap 'cnt' 中。
            //                      如果 'word' 原本不存在，则将其添加到 HashMap 中，并设置出现次数为 1。
            //                      如果 'word' 原本存在，则更新其在 HashMap 中存储的出现次数。
        }
// 循环结束后，HashMap 'cnt' 中会存储每个单词及其在 'words' 列表中出现的总次数。

        List<String> rec = new ArrayList<String>();
// 创建一个新的 ArrayList，用于存储需要排序的单词。
// 变量名 'rec' 可以理解为 'record' 或 'result' 的缩写，这里用来记录需要排序的单词列表。

        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            // 遍历 HashMap 'cnt' 的所有键值对 (entry)。
            // cnt.entrySet() 返回 HashMap 中所有键值对的 Set 集合。
            // Map.Entry<String, Integer> 表示每个键值对的类型，其中键是 String (单词)，值是 Integer (次数)。
            rec.add(entry.getKey());
            // 对于每个键值对 'entry'，执行以下操作：
            // entry.getKey()：获取当前键值对的键，即单词。
            // rec.add(...)：将获取到的单词添加到 ArrayList 'rec' 中。
        }
// 循环结束后，ArrayList 'rec' 中包含了 HashMap 'cnt' 中所有的单词 (作为字符串列表)。
// 注意，此时 'rec' 中的单词顺序是 HashMap 迭代器给出的顺序，并非按照任何特定规则排序。

        Collections.sort(rec, new Comparator<String>() {
            // 使用 Collections.sort 方法对 ArrayList 'rec' 进行自定义排序。
            // 第一个参数 'rec' 是要排序的 List。
            // 第二个参数是一个匿名内部类，实现了 Comparator<String> 接口，定义了排序规则。
            public int compare(String word1, String word2) {
                // 实现 Comparator 接口的 compare 方法，定义两个单词 'word1' 和 'word2' 的比较规则。
                // 这个方法需要返回一个 int 值：
                //  负整数：如果 word1 应该排在 word2 之前。
                //  零：如果 word1 和 word2 顺序无关紧要 (在本排序中被视为相等)。
                //  正整数：如果 word1 应该排在 word2 之后。
                return cnt.get(word1) == cnt.get(word2) ? // 首先比较两个单词在 HashMap 'cnt' 中的出现次数是否相等。
                        word1.compareTo(word2) :         // 如果出现次数相等，则按照单词的字典顺序 (自然顺序) 升序排列。
                        cnt.get(word2) - cnt.get(word1);
                // 如果出现次数不相等，则按照出现次数降序排列。
                //  cnt.get(word2) - cnt.get(word1) 的结果：
                //  如果 word2 的次数大于 word1 的次数，结果为正数，word1 排在 word2 之后 (次数大的排前面)。
                //  如果 word2 的次数小于 word1 的次数，结果为负数，word1 排在 word2 之前 (次数大的排前面)。
                //  如果 word2 的次数等于 word1 的次数，结果为零 (但实际上前面已经处理了次数相等的情况)。
            }
        });
// Collections.sort 方法会根据上面定义的 Comparator 规则对 ArrayList 'rec' 中的单词进行排序。
// 排序结果是：首先按照单词出现次数降序排列，如果出现次数相同，则按照单词的字典顺序升序排列。

        return rec.subList(0, k);
// 返回排序后的 ArrayList 'rec' 的前 k 个元素组成的新 List (子列表)。
// rec.subList(0, k) 方法返回 'rec' 列表中索引从 0 (包含) 到 k (不包含) 的部分视图 (View)。
// 也就是说，返回排序后频率最高的前 k 个单词（如果频率相同，则取字典序较小的）。
// 如果 'rec' 的长度小于 k，则返回 'rec' 的所有元素。

    }

    public static void main(String[] args) {
    }
}
