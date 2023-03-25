package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FindNum {
    public static void main(String[] args) {
        int[] a = {272,238,996,406,763,164,102,948,217,760,609,700,848,637,748,718,469,449,502,703,292,86,91,551,699,293,244,406,22,968,434,805,910,927,623,79,108,541,411};
        int[] b = secondGreaterElement_Stack(a);
        System.out.println(Arrays.toString(b));
    }

    // 两个单调递增栈，可是为什么速度比用数组模拟的栈要慢捏？但是相比于用数组，内存大大节约了，开心！
    public static int[] secondGreaterElement_Stack(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<Integer> s = new Stack<>();
        Stack<Integer> t = new Stack<>();
        s.push(0);
        for(int i = 1; i < nums.length; i++) {

            while (!t.isEmpty() && nums[i] > nums[t.peek()]) {  // 当前元素大于t的栈顶，该元素就是栈t的第二大整数
                ans[t.pop()] = nums[i];
                if(t.isEmpty()) break;
            }
            Stack<Integer> temp = new Stack<>();
            while(nums[i] > nums[s.peek()]) {  // 如果当前元素大于s栈的栈顶，将s栈的栈顶弹出到栈t中
                temp.push(s.pop());
                if(s.isEmpty()) break;
            }
            while (!temp.isEmpty()) {
                t.push(temp.pop());
            }
            s.push(i);   // 小的直接压入栈

        }
        return ans;
    }

    // 暴力法，两层for循环
    public static int[] secondGreaterElement(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int sec_max = -1;
            int max_count = 0;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] > nums[i]) {
                    if(max_count++ == 2) {
                        sec_max = j;
                        break;
                    }
                }
            }
            ans[i] = sec_max;
        }
        return ans;
    }

}
