package structure.search;


// 无序，顺序查找
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1,9,10,-1,4};
        int target = 4;
        int index = seqSearch(arr, target);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("下标为"+ index);
        }
    }

    private static int seqSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;

    }

}
