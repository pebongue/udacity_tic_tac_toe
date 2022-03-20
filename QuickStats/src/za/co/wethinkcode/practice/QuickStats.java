package za.co.wethinkcode.practice;

import java.util.Arrays;

public class QuickStats {

    public static void main(String[] args){

        int argsSize = args.length;
        if(argsSize == 0) {
            System.out.print("There are no numbers in the list of arguments.");
            return;
        }

        double[] totalArgsSize = getTotal(args);
        double argsTotal = totalArgsSize[0];
        double intCountArgs = totalArgsSize[1];

        System.out.println(Arrays.toString(args));
        System.out.println("Count:" + argsSize);
        System.out.println("Total: " + argsTotal);
        System.out.println("Average: " + Math.round(argsTotal / argsSize));
    }

    private static double[] getTotal(String[] input){
        double total = 0;
        int countArgsSize = 0;
        for (int x=0; x < input.length; x++){
            if (isNumeric(input[x])){
                total += Integer.parseInt(input[x]);
                countArgsSize++;
            } else {
                input[x] += " (ignored)";
            }
        }
        return new double[]{total, countArgsSize};
    }


    public static boolean isNumeric(String string) {

        int intValue;
        //System.out.println(String.format("Parsing string: \"%s\"", string));

        if(string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
}
