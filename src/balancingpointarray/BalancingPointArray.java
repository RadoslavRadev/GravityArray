/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balancingpointarray;

/**
 *
 * @author radoslav
 */
public class BalancingPointArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array1 = {1,2,3,45,5};
        int[] array2 = {4,5,99,-1,5,6};
        //int[] balancedArray = {1, 2, 3, 9, 5, 2, -1};
        int result1 = Gravity(array1);
        int result2 = Gravity(array2);
        //System.out.println("Best balance point is index : "+Balance(balancedArray));
        System.out.println("Index: " + result1 + ". Value: " + array1[result1] + " for array{1,2,3,45,5}.");
        System.out.println("Index: " + result2 + ". Value: " + array2[result2] + " for array{4,5,99,-1,5,6}.");
    }
    
    public static int Gravity(int[] array) {
        int leftSum = 0;
        int rightSum = 0;
        int[] arrayResult = new int[array.length];
        int minValue = Integer.MAX_VALUE;
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                leftSum += array[j];
            }
            for (int j = i + 1; j < array.length; j++) {
                rightSum += array[j];
            }
            arrayResult[i] = Math.abs(leftSum - rightSum);
            leftSum = 0;
            rightSum = 0;
        }
        for (int i = 0; i < arrayResult.length; i++) {
            if (minValue > arrayResult[i]) {
                minValue = arrayResult[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    //can be used for used for arrays with balanced point , example for array: {1, 2, 3, 9, 5, 2, -1}
    public static int Balance(int[] array){
        int[] leftSum = new int[array.length];
        int[] rightSum = new int[array.length];
        leftSum[0] = array[0];
        for (int i=1; i<array.length; i++){
            leftSum[i]=leftSum[i-1]+array[i];
        }
        rightSum[array.length-1] = array[array.length-1];
        for(int i=array.length-2; i>=0; i--){
            rightSum[i] = rightSum[i+1]+array[i];
        }
        for(int i=0; i<leftSum.length; i++){
            if(leftSum[i]==rightSum[i])
                return i; //returns the balance point
        }
        return -1;// return - 1 if can't find perfect balance point
    }
}
