package arrays;

import java.util.Scanner;
import java.util.Arrays;

public class ArraysExamples {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        //exerciseA();
        //exerciseB();
        //histogram();
        //dynamicHistogram();
        //frequency();
        //multiDimArray("Sean");// method call/invocation
        //studentGrades();
        statistics();
    }
    public static void statistics(){
        int []arr1 = {9, 3, 44, 17, 15};// sorted == 3,9,15,17,44
        double sum=0.0;
        
        // average
        for(int value:arr1){
            sum += value;
        }
        System.out.println("Average is "+sum/arr1.length);
        
        // calculate the median
        double median = calculateMedian(arr1);
        System.out.println("Median is "+median);
        
        // calculate the range
        int range = calculateRange(arr1);
        System.out.println("Range is "+range);
    }
    public static int calculateRange(int[] a){
        // a[0] [1] [2] [3] [4]
        // a{9,  3, 44, 17, 15}; // unsorted array; length==5

        // a[0] [1] [2] [3] [4]
        // a{3,  9, 15, 17, 44} // sorted array
        Arrays.sort(a);
        int range = a[a.length-1] - a[0];// 44-3==41
        return range;
    }
    public static double calculateMedian(int[] array){
        // median - if odd number of elements in the array,
        // sort the array and get the middle value;
        // if there are an even number of elements, then add
        // the 2 middle elements and divide by 2
        double median=0.0;
        Arrays.sort(array); // array == {3,9,15,17,44}
        if(array.length % 2 == 1){ // odd number of elements
            int middleIndex = array.length/2; // 5/2 == 2
            median = array[middleIndex]; // median is 15
        }else{
            // remainder is 0 => even number of elements
            // {3,8,10,5,6,4} initially (6 elements)
            // {3,4,5,6,8,10} after sorting the array
            int middleIndex = array.length/2; // 6/2 == 3
            double sumOfTwoMiddleValues = 
                    array[middleIndex] + // 6 +
                    array[middleIndex-1];// 5 
            median = sumOfTwoMiddleValues/2; // 11/2 = 5.5
        }
        return median;
    }
    public static void multiDimArray(String name){//method definition
        //int []n         = {9, 3, 5};
        int [][]a   = { {1,2,3}, 
                        {4,5,6} };
        
////        System.out.println(a[0]); 
//        System.out.println(a[0][0]); 
//        System.out.println(a[0][1]); 
//        System.out.println(a[0][2]); 
//        System.out.println(a[1][0]); 
//        System.out.println(a[1][1]); 
//        System.out.println(a[1][2]); 
//        printTheArray(a);
          
    }
    public static void studentGrades(){
        int studentsGrades[][] =
            {
                {77, 68, 86}, // first students grades
                {96, 76, 45}  // second students grades
            };
        
        for(int[] studentGrades : studentsGrades){
            double average = calcAverage(studentGrades);
            System.out.println("Average is "+average);
            
            int minGrade = calcMinimumGrade(studentGrades);
            System.out.println("Minimum is "+minGrade);
            
            int maxGrade = calcMaximumGrade(studentGrades);
            System.out.println("Maximum is "+maxGrade);
        }
    }
    public static int calcMinimumGrade(int[] studentGrades){
        // studentGrades = {77, 68, 86} the first time
        int lowGrade = 101;
        for(int grade:studentGrades){
            if(grade < lowGrade){
                lowGrade = grade;
            }
        }
        return lowGrade;
    }
    public static int calcMaximumGrade(int[] studentGrades){
        // studentGrades = {77, 68, 86} the first time
        int highGrade = -1;
        for(int grade:studentGrades){
            if(grade > highGrade){
                highGrade = grade;
            }
        }
        return highGrade;
    }
    
    public static double calcAverage(int[] studentGrades){
        // studentGrades = {77, 68, 86} the first time
        double sum=0.0;
        
        for(int grade:studentGrades){
            sum = sum + grade; // sum += grade;
        }
        return sum/studentGrades.length;
    }
    public static void printTheArray(int [][]a){
//        int [][]a   = { {1,2,3}, 
//                        {4,5,6} };
        // a.length is the # of rows
        System.out.println(a.length); // 2
        for(int row=0; row<a.length; row++){ // loop for the rows
            for(int col=0; col < a[row].length; col++){  // loop for the cols
                System.out.print(a[row][col] + " ");
            }
            System.out.println(); // goto next line/row
        }
    }
    public static void frequency(){
        int[] responses = {1,2,1,4,8,8,2,2}; // values 1..10
        //    responses[0]   == 1
        //    responses[1]   == 2
        //    responses[2]   == 1
        int frequency[] = {0,0,0,0,0,0,0,0,0,0,0};// 11 entries
        
        // after the for loop executes AND based on my responses[]
        // frequency should be as follows:
        //    frequency[0]   == 0
        //    frequency[1]   == 2
        //    frequency[2]   == 3
        //    frequency[3]   == 0
        //    frequency[4]   == 1
        //    frequency[5]   == 0
        //    frequency[6]   == 1
        //    frequency[7]   == 0
        //    frequency[8]   == 2
        //    frequency[9]   == 0
        //    frequency[10]  == 0
        for(int answer=0; answer<responses.length; answer++){
            int freqIndex = responses[answer];
            frequency[freqIndex]++;
            
            // frequency[responses[answer]]++;
        }
        
        // output the frequency array
        for(int rating=0; rating<frequency.length; rating++){
            System.out.println(rating + "\t" + frequency[rating]);
        }
    }
    public static void dynamicHistogram(){
        System.out.print("Enter the size --> ");
        int size = sc.nextInt();
        int []n = new int[size];
        
        // this array is initialised by the user
        for(int i=0; i<n.length; i++){
            System.out.print("Enter a value --> ");
            n[i] = sc.nextInt();
        }
        
        
        System.out.println("Index\tValue\tHistogram");
        // loop for each element in 'n' i.e. 9,3,5
        for(int i=0; i<n.length; i++){
            System.out.print(i + "\t" + n[i] + "\t"); 
            // write out e.g. 9 stars
            for(int j=0; j<n[i]; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static void histogram(){
        int []n = {9, 3, 5};
        
        System.out.println("Index\tValue\tHistogram");
        // loop for each element in 'n' i.e. 9,3,5
        for(int i=0; i<n.length; i++){
            System.out.print(i + "\t" + n[i] + "\t"); 
            // write out e.g. 9 stars
            for(int j=0; j<n[i]; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void exerciseB(){
        int[] b = new int[5]; // an array is an object!
        
        // this array is initialised by the user
        for(int i=0; i<b.length; i++){
            System.out.print("Enter a value --> ");
            b[i] = sc.nextInt();
        }
        // normal 'for' loop
        for(int i=0; i<b.length; i++){
            System.out.println(b[i]);
        }

        // 'enhanced' for loop
        for(int element:b){
            System.out.println(element);
        }

    }
    public static void exerciseA(){
        int[] a = {10, 20, 30, 40, 50};
        
        // normal 'for' loop
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }

        // 'enhanced' for loop
        for(int element:a){
            System.out.println(element);
        }
    }
}
