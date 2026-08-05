class BinarySearchClass {
    public Integer binarySearch(int[] list, int target) {
        int low = 0;
        int high = list.length-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if(list[mid]==target){
                return mid;
            }
            System.out.println(mid);
            if(list[mid]>=target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchClass BSC = new BinarySearchClass();
        System.out.println("Hello");
        int[] list = {1, 3, 4, 7, 9, 11, 23};
        System.out.println(BSC.binarySearch(list,25));
    }
}