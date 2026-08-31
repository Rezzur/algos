import java.net.ContentHandler;

public class ContainerWithMostWater {
    public int maxArea(int[] height){
        // 1, 8, 6, 2
        int[] dp = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max((Math.min(height[i], height[j]) * (i - j)), dp[i]);
            }
        }
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return  result;
    }
    public int maxAreaV2(int[] height){
        int area = 0;
        int pointerLeft = 0;
        int pointerRight = height.length-1;
        while(pointerLeft!=pointerRight){
            area = Math.max(Math.min(height[pointerLeft], height[pointerRight])*(pointerRight-pointerLeft), area);
            if(height[pointerLeft]>height[pointerRight]){
                pointerRight--;
            }else{
                pointerLeft++;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        System.out.println(c.maxAreaV2(new int[]{1,8,6,2,5,4,8,3,1}));
    }
}
