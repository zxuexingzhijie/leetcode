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
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1;j<height.length;j++){
                maxheight = Math.max(maxheight,Math.min(height[i],height[j])*(j-i));
            }
        }
        return maxheight;
    }
}