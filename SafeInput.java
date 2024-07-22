import java.util.Scanner;


public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt) // for PROGRAM 1
    {
        String retString = ""; // set this to zero length.loop runs until it isn't
        do
        {
            System.out.println ("\n" + prompt + ":"); // show prompt add space
            retString = pipe.nextLine();

        }
        while (retString.length()==0);
        return retString;
    }


    public static String getRegExString(Scanner pipe, String prompt, String regExPattern) // for PROGRAM 5
    {
        String value = "";
        boolean gotAValue = false;

        do
        {
            // show the prompt
            System.out.print(prompt + ": ");
            // input the data
            value = pipe.nextLine();
            // test to see if it is correct
            if(value.matches(regExPattern))
            {
                // We have a match this String passes!
                gotAValue = true;
            }
            else
            {
                System.out.println("\nInvalid input: " + value);
            }

        }while(!gotAValue);

        return value;
    }


    /**
     * returns an integer value
     * @param pipe a Scanner to use for input from the user
     * @param prompt tells the user what they have to enter
     * @return an int
     */
    public static int getInt(Scanner pipe, String prompt) //  for PROGRAM 2
    {
        boolean gotBValue = false;
        int value = 0;
        String trash = "";

        do
        {
            System.out.print(prompt + ": ");
            if(pipe.hasNextInt())
            {
                value = pipe.nextInt();
                gotBValue = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("\nDo not enter an incorrect value like: " + trash + "Please eter an integer value"  );
            }
        }
        while(!gotBValue);
        return value;
    }



    public static double getDouble(Scanner pipe, String prompt) // For PROGRAM 2
    {
        boolean gotBValue = false;
        double value = 0;
        String trash = "";

        do
        {
            System.out.print(prompt + ": ");
            if(pipe.hasNextDouble())
            {
                value = pipe.nextDouble();
                gotBValue = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("\nDo not enter an incorrect value like: " + trash + "Please enter a double value");
            }
        }
        while(!gotBValue);
        return value;
    }



    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) // for PROGRAM 3
    {
        boolean gotBValue = false;
        int values = 0;
        String trash = "";

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");

            if (pipe.hasNextInt()) {
                values = pipe.nextInt();
                pipe.nextLine();
                if (values >= low && values <= high)
                    gotBValue = true;
                else {
                    System.out.println("\nThe value must be in range [" + low + " - " + high + "]: " +values);
                    System.out.println("Please try doing it again.");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("\nDo not enter an incorrect value like: " + trash + "Please enter an integer value");
            }

        }
        while (!gotBValue);
        return values;
    }


    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) //for PROGRAM 4
    {
        boolean gotBValue = false;
        double value = 0;

        String trash = "";

        do
        {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");

            if(pipe.hasNextDouble())
            {
                value = pipe.nextDouble();
                pipe.nextLine();
                if(value >= low && value <= high)
                    gotBValue = true;
                else
                {
                    System.out.println("\nThe value must be in range [" + low + " - " + high + "]: " + value);
                    System.out.println(" Please try it again.");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("\nDo not enter the incorrect value: " + trash + "Please enter double value");
            }

        }while(!gotBValue);
        return value;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) // For PROGRAM 4
    {
        String YNConfirm = "";
        boolean done = false;
        boolean value = false;
        do
        {
            System.out.println(prompt +": ");
            YNConfirm = pipe.nextLine();
            YNConfirm = YNConfirm.toUpperCase();
            if(YNConfirm.equals("Y"))
            {
                value = true;
                done = true;

            }
            else if(YNConfirm.equals("N"))
            {
                value = false;
                done = true;
            }
            else
            {
                System.out.println("Please enter a valid value either Yes(y/Y) or No(N/n)");

            }

        }while(!done);
        return value;
    }



}















