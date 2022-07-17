package leetcode;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers/">2. 两数相加</a>
 */
class LeetCode002 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 链表游标l1, l2
        ListNode cursor1 = l1, cursor2 = l2;
        // 虚拟链表头结点
        ListNode dummy = new ListNode(-1);
        // 虚拟链表游标
        ListNode cursourD = dummy;

        // 记录相加后的进位值
        int carry = 0;

        // 因为数值逆序存储，所以直接从头开始遍历2个链表
        while (cursor1 != null || cursor2 != null || carry > 0) {
            int val = carry;

            if (cursor1 != null) {
                val += cursor1.val;
                cursor1 = cursor1.next;
            }

            if (cursor2 != null) {
                val += cursor2.val;
                cursor2 = cursor2.next;
            }

            // 计算进位
            carry = val / 10;
            // 计算当前位的值
            val = val % 10;

            cursourD.next = new ListNode(val);
            cursourD = cursourD.next;

        }

        return dummy.next;
    }

    private static ListNode toListNode(String val) {
        ListNode listNode = new ListNode();
        ListNode cursorNode = listNode;
        for (int i = 0; i < val.length(); i++) {
            cursorNode.val = Integer.parseInt(String.valueOf(val.charAt(i)));
            if (i != val.length() - 1) {
                cursorNode.next = new ListNode();
                cursorNode = cursorNode.next;
            }
        }
        return listNode;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // 在两条链表上的指针
        ListNode p1 = l1, p2 = l2;
        // 虚拟头结点（构建新链表时的常用技巧）
        ListNode dummy = new ListNode(-1);
        // 指针 p 负责构建新链表
        ListNode p = dummy;
        // 记录进位
        int carry = 0;
        // 开始执行加法，两条链表走完且没有进位时才能结束循环
        while (p1 != null || p2 != null || carry > 0) {
            // 先加上上次的进位
            int val = carry;
            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }
            // 处理进位情况
            carry = val / 10;
            val = val % 10;
            // 构建新节点
            p.next = new ListNode(val);
            p = p.next;
        }
        // 返回结果链表的头结点（去除虚拟头结点）
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new LeetCode002().addTwoNumbers(toListNode("243"), toListNode("564"));
        System.out.println(listNode);
    }
}