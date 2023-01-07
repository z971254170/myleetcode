//设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。 
//
// 实现 FreqStack 类: 
//
// 
// 
// FreqStack() 构造一个空的堆栈。 
// 
// void push(int val) 将一个整数 val 压入栈顶。 
// 
// int pop() 删除并返回堆栈中出现频率最高的元素。 
// 
// 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。 
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["FreqStack","push","push","push","push","push","push","pop","pop","pop",
//"pop"],
//[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
//输出：[null,null,null,null,null,null,null,5,7,5,4]
//解释：
//FreqStack = new FreqStack();
//freqStack.push (5);//堆栈为 [5]
//freqStack.push (7);//堆栈是 [5,7]
//freqStack.push (5);//堆栈是 [5,7,5]
//freqStack.push (7);//堆栈是 [5,7,5,7]
//freqStack.push (4);//堆栈是 [5,7,5,7,4]
//freqStack.push (5);//堆栈是 [5,7,5,7,4,5]
//freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
//freqStack.pop ();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
//freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
//freqStack.pop ();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。 
//
// 
//
// 提示： 
//
// 
// 0 <= val <= 10⁹ 
// push 和 pop 的操作数不大于 2 * 10⁴。 
// 输入保证在调用 pop 之前堆栈中至少有一个元素。 
// 
//
// Related Topics 栈 设计 哈希表 有序集合 👍 340 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 最大频率栈
 *
 * @author ZSW
 * @date 2022-11-30 21:54:28
 */
public class P895_MaximumFrequencyStack {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P895_MaximumFrequencyStack().new Solution();
    }

    class Solution {

    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class FreqStack {
        // 代表数字与对应出现次数的键值对
        private final Map<Integer, Integer> count = new HashMap<>();
        // 代表出现次数对应的栈，0号为对应出现1次的的数字的栈
        private final List<Deque<Integer>> stacks = new ArrayList<>();

        public FreqStack() {

        }

        public void push(int val) {
            int c = count.getOrDefault(val, 0);
            if (c == stacks.size()) {
                // c代表的是当前这个数出现的次数
                // 如果c为0，且与stacks长度相同，那么说明次数stacks中啥也没有
                // 如果c不为0，且与stacks长度相同，那么说明stacks中的代表数字
                // 出现频率的队列少了，要多加一个
                stacks.add(new ArrayDeque<>());
            }
            stacks.get(c).push(val);
            count.put(val, c + 1);
        }

        public int pop() {
            int back = stacks.size() - 1;
            int val = stacks.get(back).pop();
            if (stacks.get(back).isEmpty()) {
                stacks.remove(back);
            }
            count.put(val, count.get(val) - 1);
            return val;
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
//leetcode submit region end(Prohibit modification and deletion)

}