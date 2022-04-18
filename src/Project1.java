import java.util.*;

public class Project1 {
    static int[] input(){   //method for taking input for array from the user
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int n = scan.nextInt();

        while(n < 1){   //checking for valid array length
            System.out.print("Array length can't be less than 1. Input it again: ");
            n = scan.nextInt();
        }

        System.out.println();

        int[] array = new int[n];

        for(int i = 0; i < n; i++){
            try{    //using try catch to handle errors such as invalid input or integer overflow
                System.out.print("Enter " + (i+1) + ". element of array: ");
                array[i] = scan.nextInt();
            }catch(Exception e){
                System.out.println("Not a valid input!");
                System.exit(0);
            }
        }

        System.out.println();
        return array;
    }

    static void numberOfElements(int[] array){
        System.out.println("There are " + array.length + " elements in the array.");
    }

    static int numberOfDifferentElements(int[] array) { //will call this method later in numbers with max occurrence method so no need to call it in main
        int counter = 1;

        for(int i = 0; i < array.length; i++){
            if(i+1 == array.length){ //checking if next one is out of bounds
                break;
            }
            if(array[i] == array[i+1]){ //checking if next one is the same as current one
                continue;
            }
            counter++;
        }

        return counter;
    }

    static void numberOfEvenNumbers(int[] array){
        int counter = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] == 0){
                continue;       //zero is neither even or odd
            }
            if(array[i] % 2 == 0) {
                counter++;
            }
        }

        System.out.println("There are " + counter + " even numbers in the array.");
    }

    static void numberOfOddNumbers(int[] array){
        int counter = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] == 0){
                continue;       //zero is neither even or odd
            }
            if(array[i] % 2 != 0) {
                counter++;
            }
        }

        System.out.println("There are " + counter + " odd numbers in the array.");
    }

    static void frequencyOfRepetition(int[] array){
        double percentage = (double)100 / array.length;  //calculating what percentage each element will take up
        double currentPercentage = percentage;

        for(int i = 0; i < array.length; i++){
            if(i+1 == array.length){ //checking if next one is out of bounds
                System.out.println("The number " + array[i] + " is " + currentPercentage + "% of the array."); //if it is then i print out the current results
                break;
            }
            if(array[i] == array[i+1]){ //checking if next one is the same as current one
                currentPercentage += percentage;
                continue;
            }
            System.out.println("The number " + array[i] + " is " + currentPercentage + "% of the array."); //print out results of current number repetitions
            currentPercentage = percentage; //reset percentage counter
        }
    }

    static void numberWithMaximumOccurrence(int[] array){   //making 2 arrays, 1 will hold different elements, 2 will hold numbers of repetitions
        int length = numberOfDifferentElements(array);  //using this to get number of different elements

        int[] differentElements = new int[length];
        int differentElementsCounter = 0;   //variable for passing through our 2 new arrays

        int[] counterOfRepetitions = new int[length];
        int counterOfRepetitionsCounter = 1;    //variable for counting repetitions

        for(int i = 0; i < array.length; i++){  //loop for filling out the arrays
            if(i+1 == array.length){    //if to stop the for loop to go out of bounds
                differentElements[differentElementsCounter] = array[i];
                counterOfRepetitions[differentElementsCounter] = counterOfRepetitionsCounter;
                break;
            }
            if(array[i] == array[i+1]){ //if to check if elements repeat and if yes increase the counter they repeat and go to next i
                counterOfRepetitionsCounter++;
                continue;
            }
            differentElements[differentElementsCounter] = array[i];
            counterOfRepetitions[differentElementsCounter] = counterOfRepetitionsCounter;   //filling out the arrays
            differentElementsCounter++; //increasing passing variable
            counterOfRepetitionsCounter = 1;    //resetting counter variable
        }

        int max = counterOfRepetitions[0];  //declaring max

        for(int i = 1; i < length; i++){    //finding actual max
            if(counterOfRepetitions[i] > max){
                max = counterOfRepetitions[i];
            }
        }

        System.out.println("Numbers with maximum occurrence are:");
        for(int i = 0; i < length; i++){    //printing out all max values
            if(max == counterOfRepetitions[i]){
                System.out.println("Element " + differentElements[i] + " - " + counterOfRepetitions[i] + " times");
            }
        }
    }

    static int max(int[] array){
        int max = array[0];

        for(int i = 1; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }

        return max;
    }

    static void secondSmallestNumber(int[] array){
        int counterOfElement = 0;

        if(numberOfDifferentElements(array) == 1){
            System.out.println("All elements are the same, so no second smallest element.");
        }
        else{
            for(int i = 0; i < array.length; i++){
                if(array[i] == array[i+1]){
                    continue;
                }
                counterOfElement = i+1;
                break;
            }
            System.out.println("The second smallest element in the array is " + array[counterOfElement]);
        }
    }

    static double averageOfAllNumbers(int[] array){ //declaring as double type because I use the method later
        double sum = 0;

        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }

        return sum / array.length;
    }

    static void standardDeviation(int[] array){ //followed a formula from google
        double average = averageOfAllNumbers(array);
        double mi = 0;

        for(int i = 0; i < array.length; i++){
            mi += (array[i] - average) * (array[i] - average);
        }

        double variance = mi / array.length;

        System.out.println("The standard deviation in this array is " + Math.sqrt(variance));

    }

    static void median(int[] array){    //according to google the median of an even set is the average of the two middle elements
        //for the median the array

        System.out.print("The median of the array is ");
        if(array.length % 2 == 0) {     //median for even numbers
            System.out.println((double)(array[array.length/2-1] + array[array.length/2]) / 2);
        }
        else{       //median for odd numbers
            System.out.println(array[array.length/2]);
        }
    }

    static void sum(int[] array){
        long sum = 0;

        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }

        System.out.println("The sum of all elements in the array is " + sum);
    }

    static boolean checkPalindrome(int k){
        String n = String.valueOf(k);   //convert number into string
        boolean check = true;   //declare boolean var

        for(int i = 0; i < n.length(); i++){
            if(n.charAt(i) != n.charAt(n.length()-i-1)){    //checking for non-palindrome condition
                check = false;  //if true, set variable to false and return it
                return check;
            }
        }

        return check;   //this only returns if the non-palindrome condition fails which means it is a palindrome
    }

    static int numberOfPalindromes(int[] array){
        int counter = 0;

        for(int i = 0; i < array.length; i++){
            if(checkPalindrome(array[i])){  //if an element is a palindrome increase counter
                counter++;
            }
        }

        return counter;
    }

    static void largestPalindromeSmallerThanMax(int[] array){
        if(numberOfPalindromes(array) == 0){
            System.out.println("There is no largest palindrome smaller than the largest elements because there are no palindromes in the array");
            return;
        }

        int max = array[0];

        if(checkPalindrome(array[array.length-1]) && numberOfPalindromes(array) == 1){
            System.out.println("The only palindrome in the array is the biggest element.");
            return;
        }

        for(int i = 0; i < array.length; i++){
            if(checkPalindrome(array[i]) && array[i] < max(array)){  //if an element is a palindrome increase counter
                max = array[i];
            }
        }

        System.out.println("Largest palindrome that is smaller than the largest element in the array is " + max);
    }

    static void reversePrint(int[] array){
        System.out.print("Received numbers in reverse order: ");

        for(int i = array.length-1; i >= 0; i--){   //going through array backwards
            if(i == 0){ //removing the last comma
                System.out.print(array[i]);
                return;
            }
            System.out.print(array[i] + ", ");  //printing element and the comma delimiter
        }
    }

    public static void main(String[] args) {
        int[] array = input();

        int[] arrayCopy = Arrays.copyOf(array, array.length); //making a copy of the array for later use

        Arrays.sort(array); //sorting the array to make life easier

        numberOfElements(array);
        System.out.println();
        numberOfEvenNumbers(array);
        System.out.println();
        numberOfOddNumbers(array);
        System.out.println();
        System.out.println("There are " + numberOfDifferentElements(array) + " different elements in the array.");
        System.out.println();
        frequencyOfRepetition(array);
        System.out.println();
        System.out.println("The maximum value in the array is " + max(array));
        System.out.println();
        numberWithMaximumOccurrence(array);
        System.out.println();
        secondSmallestNumber(array);
        System.out.println();
        System.out.println("The average of all numbers is " + averageOfAllNumbers(array));
        System.out.println();
        standardDeviation(array);
        System.out.println();
        median(array);
        System.out.println();
        sum(array);
        System.out.println();
        System.out.println("There are " + numberOfPalindromes(array) + " palindromes in the array.");
        System.out.println();
        largestPalindromeSmallerThanMax(array);
        System.out.println();
        reversePrint(arrayCopy);
        System.out.println();
    }
}