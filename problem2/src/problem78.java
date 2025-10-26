//https://leetcode.cn/problems/trapping-rain-water/?
public class problem78 {
    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        int[] trap = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = solution78.trap(trap);
        System.out.println(res);
    }
}


class Solution78 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;                     // 左指针
        int right = height.length - 1;    // 右指针
        int leftMax = 0;                  // 左边最高柱子
        int rightMax = 0;                 // 右边最高柱子
        int sum = 0;                      // 总水量

        while (left < right) {
            if (height[left] < height[right]) {
                // 左边较矮，水量取决于左边最高
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // 更新左边最高柱子
                } else {
                    sum += leftMax - height[left]; // 当前能接的水
                }
                left++; // 左指针右移
            } else {
                // 右边较矮，水量取决于右边最高
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // 更新右边最高柱子
                } else {
                    sum += rightMax - height[right]; // 当前能接的水
                }
                right--; // 右指针左移
            }
        }

        return sum;
    }
}

