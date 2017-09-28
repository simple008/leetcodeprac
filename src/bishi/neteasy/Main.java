/*
package bishi.neteasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

*/
/*

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){

        }
    }
    public List<List<Integer>> permuteUnique(int des) {
        int num = des;
        int bit = 1;
        while(num >= 10){
            num /= 10;
            bit++;
        }
        int [] nums = new int[bit];
        num =des;
        for(int i = 0; i < bit; i++){
            nums[bit] = num % 10;
            num /=10;
        }

        */
/*while(num != 0){

        }*//*


        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            res.add
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}



*/
/*
import itertools

        def isChange(n):
        nums = [k for k in str(n)]
        permutation = [int(''.join(k)) for k in set(itertools.permutations(nums, len(nums)))]
        for k in all:
        if k>n and k % n == 0:
        return 'Possible'
        return 'Impossible'

        n = int(raw_input())
        res = []
        while n > 0:
        n -= 1
        res.append(int(raw_input()))

        for n in input:
        print is_possible(n)*/

//Ë³Ê±Õë´òÓ¡´íÎó´úÂë

/*
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while(true){
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            if(top > bottom) break;

            for(int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(right < left)
                break;

            for(int i = right; i >= left; i++){
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if(bottom < top)
                break;

            for(int i = bottom; i >= top; i++){
                res.add(matrix[i][left]);
            }
            left++;
            if(left > right)
                break;
        }
        return res;
    }
}*/
package bishi.neteasy;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        int []num = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
         ArrayList<Integer> list = FindNumbersWithSum(num,21);
        for(int l: list)
            System.out.println(l);
    }
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        int min = Integer.MAX_VALUE;
        int a =0;
        int b=0;
        int i = 0;
        int j = array.length-1;
        while(i<j){
            if(array[i] + array[j] == sum){
                if(array[i] * array[j] < min){
                    min = array[i] * array[j];
                    a = array[i];
                    b = array[j];
                }
                i++;
                j--;
            }else if(array[i] + array[j] < sum)
                i++;
            else j--;
        }
        if(a ==b) return res;
        res.add(a);
        res.add(b);
        return res;

    }
}