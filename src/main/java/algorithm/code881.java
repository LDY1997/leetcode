package algorithm;

import java.util.Arrays;

public class code881 {
    public class ListNode {
        int val;	//结点值
        ListNode next;	//用来指向下一个结点的ListNode对象
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    //给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。
    //
    //每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
    //
    //返回 承载所有人所需的最小船数 。
    //
    //
    //
    //示例 1：
    //
    //输入：people = [1,2], limit = 3
    //输出：1
    //解释：1 艘船载 (1, 2)
    //示例 2：
    //
    //输入：people = [3,2,2,1], limit = 3
    //输出：3
    //解释：3 艘船分别载 (1, 2), (2) 和 (3)
    //示例 3：
    //
    //输入：people = [3,5,3,4], limit = 5
    //输出：4
    //解释：4 艘船分别载 (3), (3), (4), (5)
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int minIndex = 0;
        int maxIndex = people.length-1;
        while (minIndex <= maxIndex){
            if (people[minIndex] + people[maxIndex]<=limit){
                minIndex ++;
            }
            ans ++;
            maxIndex --;
        }
        return ans;
    }
    //给你一个链表的头节点 head ，判断链表中是否有环。
    //
    //如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
    //
    //如果链表中存在环 ，则返回 true 。 否则，返回 false 。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：head = [3,2,0,-4], pos = 1
    //输出：true
    //解释：链表中有一个环，其尾部连接到第二个节点。
    //示例 2：
    //
    //
    //
    //输入：head = [1,2], pos = 0
    //输出：true
    //解释：链表中有一个环，其尾部连接到第一个节点。
    //示例 3：
    //
    //
    //
    //输入：head = [1], pos = -1
    //输出：false
    //解释：链表中没有环。
    public boolean hasCycle(ListNode head) {
        ListNode slowIndex = head;
        ListNode fastIndex = head;
        if (head == null){
            return false;
        }
        while (fastIndex.next != null){
            fastIndex = fastIndex.next.next;
            slowIndex = slowIndex.next;
            if (fastIndex == null){
                return false;
            }
            if (slowIndex == fastIndex){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
