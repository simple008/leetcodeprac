package sort;

/**
 * Created by lpeiz on 2017/4/8.
 */
public class quickSort {
    public static void main(String []args){
        int i = 0;
        int a[] = {4,5,9,8,7,6,0,2,3,1};
        int len = a.length;
//        quickSort(a);
        bubbleSort(a);
        for( i = 0; i < len; i++){
            System.out.println(a[i]+" ");
        }
    }
    public static void quickSort(int []arr){
        sort(arr, 0 ,arr.length-1);
    }

    public static void bubbleSort(int arr[]){

        for(int i = 0; i < arr.length; i++){
            for(int j = arr.length-1; j > i;j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr [j];
                    arr [j] = arr[j-1];
                    arr [j-1] =temp;
                }
            }
        }
    }
    public static void sort(int []arr,int start,int end){
        if(start >=  end) return ;
        int i = start;
        int j = end;
        int index = arr[start];
        while(i < j){
            while(i < j && arr[j] >= index){
                j--;
            }
            if(i < j)
                arr[i++] = arr [j];
            while(i < j && arr[i] < index){
                i++;
            }
            if(i < j)
                arr[j--] = arr [i];
            arr[i] = index;
            sort(arr, start, i - 1);
            sort(arr, i + 1, end);
        }

    }
}
