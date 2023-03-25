package first;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] a = {2, 3, 3, 114, 1 ,4 , 2, 1};
        int[] b = {2, 3, 4, 114, 1, 2, 1,33, 11 ,4 , 2, 1};
        int[] c = nextGreaterElement_Stack(a, b);
        System.out.println(Arrays.toString(c));
    }

    public static int[] nextGreaterElement_Stack(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> sub = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        st.push(nums2[0]);
        for(int i = 1; i < nums2.length; i++) {
//            if(nums2[i] <= st.peek()) st.push(nums2[i]); // 如果比栈顶元素小，压入栈
            while (nums2[i] > st.peek()) {    // 如果比栈顶元素大，先记录栈顶元素的第一个大数，再弹出栈顶元素
                sub.put(st.pop(), nums2[i]);
                if(st.isEmpty()) break;  // 如果栈空了，把当前元素压入栈
            }
            st.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++) {
            ans[i] = sub.containsKey(nums1[i]) ? sub.get(nums1[i]) : -1;
        }
        System.out.println(sub.keySet());
        return ans;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums2.length; i++) {
            int nextGreater = -1;  // 初始设置为-1
            boolean flag = false;  // 标志是否找到相同元素
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums1[j]) {
                    flag = true;
                }
                if(nums1[i] < nums2[j] && flag == true) {
                    nextGreater = nums2[j];
                    break;
                }
            }
            ans[i] = nextGreater;
        }
        return ans;
    }
}
