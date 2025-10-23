// LeetCode题目链接: https://leetcode.cn/problems/container-with-most-water/
public class problem5 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = solution5.maxArea(height);
        System.out.println(result);
    }
}



class Solution5 {
    public int maxArea(int[] height) {
        int maxheight = 0;
        int left = 0;
        int right = height.length - 1;
        while (left <right){
            maxheight = Math.max(maxheight, Math.min(height[left], height[right]) * (right - left));
            // 移动高度较小的一侧，因为只有这样才有可能找到更大的面积
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxheight;
    }
}