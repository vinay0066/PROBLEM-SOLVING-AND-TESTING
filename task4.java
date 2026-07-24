import java.util.Arrays;
class task4{
    public static void main(String[] args){
        int arr[] = {3,5,7,2,9};
        int k=2;
        Arrays.sort(arr);
        System.out.println("Kth smallest= " +arr[k-1]);
    }
}