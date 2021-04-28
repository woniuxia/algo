package cn.weihuachao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Code {
    class CombinationSumIii {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            aa(ans, cur, 0, 0, n, k);
            return ans;
        }

        public void aa(List<List<Integer>> ans, List<Integer> cur, int sum, int num, int n, int k) {
            if (cur.size() >= k) {
                if (sum == n) {
                    ans.add(new ArrayList<>(cur));
                }
                return;
            }
            for (int i = num + 1; i <= 9; ++i) {
                if (sum + i <= n) {
                    cur.add(i);
                    aa(ans, cur, sum + i, i, n, k);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }

    class CombinationSum {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            dfs(ans, cur, 0, 0, candidates, target);
            return ans;
        }

        public void dfs(List<List<Integer>> ans, List<Integer> cur, int sum, int pos, int[] candidates, int target) {
            if (sum > target) {
                return;
            }
            if (sum == target) {
                ans.add(new ArrayList<>(cur));
            }
            for (int i = pos; i < candidates.length; ++i) {
                int tmp = candidates[i];
                cur.add(tmp);
                dfs(ans, cur, sum + tmp, i, candidates, target);
                cur.remove(cur.size() - 1);
            }
        }
    }

    class Combinations {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            dfs(ans, cur, 0, n, k);
            return ans;
        }

        public void dfs(List<List<Integer>> ans, List<Integer> cur, int num, int n, int k) {
            if (cur.size() == k) {
                ans.add(new ArrayList<>(cur));
                return;
            }
            for (int i = num + 1; i <= n; ++i) {
                cur.add(i);
                dfs(ans, cur, i, n, k);
                cur.remove(cur.size() - 1);
            }
        }
    }

    class SwapNodesInPairs {
        public ListNode swapPairs(ListNode head) {
            ListNode nil = new ListNode(0);
            nil.next = head;
            head = nil;
            while (head != null) {
                if (head.next != null && head.next.next != null) {
                    ListNode a = head.next;
                    ListNode b = head.next.next;
                    head.next = b;
                    a.next = b.next;
                    b.next = a;
                }else {
                    break;
                }
                head = head.next.next;
            }
            return nil.next;
        }
    }

    public static void main(String[] args) {

    }
}
