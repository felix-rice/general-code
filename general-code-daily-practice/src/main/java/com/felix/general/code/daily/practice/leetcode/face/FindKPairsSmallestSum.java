package com.felix.general.code.daily.practice.leetcode.face;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-03-02
 */
public class FindKPairsSmallestSum {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>(k);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k, (o1, o2) -> {
            return nums1[o1[0]] + nums2[o1[1]] - nums2[o2[0]] - nums2[o2[1]];
        });
        int m = nums1.length;
        int n = nums2.length;
        // (0, 0) 最小  (nums1.length - 1, nums2.length - 1) 最大
        // 假如选择了(i, j) --> 则下一个小的值来自 (i, j + 1) (i + 1, j)
        for (int i = 0; i < Math.min(m, k); i++) {

            priorityQueue.add(new int[] {i, 0});
        }

        while (k-- > 0 && !priorityQueue.isEmpty()) {
            int[] pairIdx = priorityQueue.poll();
            List<Integer> pair = new ArrayList<>(2);
            pair.add(nums1[pairIdx[0]]);
            pair.add(nums1[pairIdx[1]]);
            ans.add(pair);
            if (pairIdx[1] + 1 < n) {
                priorityQueue.offer(new int[]{pairIdx[0], pairIdx[1] + 1});
            }
        }
        return ans;
    }

    private List<List<Integer>> useHeap(int[] nums1, int[] nums2, int k) {
        int[][] heap = new int[k][3];
        buildHeap(heap, nums1, nums2, k);
        int ignore = 0;
        for (int i = 0; i < nums1.length; ++i) {
            for (int j = 0; j < nums2.length; ++j) {
                ignore++;
                if (ignore <= k) continue;
                int top = heap[0][2];
                int cur = nums1[i] + nums2[j];
                if (cur < top) {
                    heap[0][0] = nums1[i];
                    heap[0][1] = nums2[j];
                    heap[0][2] = cur;
                    adjustDown(heap, k);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(k);
        for (int[] pair : heap) {
            List<Integer> listPair = new ArrayList<>(2);
            listPair.add(pair[0]);
            listPair.add(pair[1]);
            ans.add(listPair);
        }
        return ans;
    }

    // 大顶堆
    void buildHeap(int[][] heap, int[] nums1, int[] nums2, int k) {
        int point = 0;
        for (int i = 0; i < nums1.length; ++i) {
            for (int j = 0; j < nums2.length; j++) {
                heap[point][0] = nums1[i];
                heap[point][1] = nums2[j];
                heap[point][2] = nums1[i] + nums2[j];
                adjustUp(heap, point);
                point++;
                if (point == k) break;
            }
            if (point == k) break;
        }
    }

    /**
     parent * 2 + 1 = leftPoint;
     parent * 2 + 2 = rightPoint;
     (idx - 1) / 2 = parent
     */
    void adjustUp(int[][] heap, int point) {
        if (point == 0) return;
        while(point > 0) {
            int parentPoint = (point - 1) >> 1;
            if (heap[parentPoint][2] >= heap[point][2]) {
                break;
            }
            int[] temp = heap[point];
            heap[point] = heap[parentPoint];
            heap[parentPoint] = temp;
            point = parentPoint;
        }
    }

    void adjustDown(int[][] heap, int k) {
        int parent = 0;
        while (true) {
            int leftPoint = (parent << 1) + 1;
            int rightPoint = (parent << 1) + 2;
            if (leftPoint > k) break;
            int bigger = heap[leftPoint][2];
            int biggerPoint = leftPoint;
            if (rightPoint < k) {
                if (heap[rightPoint][2] > bigger) {
                    biggerPoint = rightPoint;
                    bigger = heap[rightPoint][2];
                }
            }
            if (heap[parent][2] >= bigger) break;
            int[] temp = heap[parent];
            heap[parent] = heap[biggerPoint];
            heap[biggerPoint] = temp;
            parent = biggerPoint;

        }
    }


    public static void main(String[] args) {
        int[] nums1 = new int[] {1,23,45,6,6,7};
        int[] nums2 = new int[] {3,5,6,7,8,100};
        int k = 10;
        FindKPairsSmallestSum findKPairsSmallestSum = new FindKPairsSmallestSum();
        List<List<Integer>> ans = findKPairsSmallestSum.kSmallestPairs(nums1, nums2, k);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
