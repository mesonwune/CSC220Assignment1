import java.util.ArrayList;
import java.util.Scanner;

/*
* This file holds the main method so I can test/run the code
* and the two methods that count the # of occurrences and turns the string
* into tokens.
*/
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner reader = new Scanner(System.in);

        //Where to write your string so it can be stored.
        System.out.print("Please write: ");
        String line = reader.nextLine();
        StrToTokens(line);
        getLettrFreq(line);
    }

    //converting string into tokens
    public static void StrToTokens(String s)
    {
        //ArrayList for storing each word.
        ArrayList <String> tokens = new ArrayList<String>();
        int length = s.length();
        String token = "";
        //Going through each character in the String
        for (int i = 0; i < length; i++)
        {
            //Taking a character
            char character = s.charAt(i);

            /*Comparing it to either a space, comma, or period
            * i+1 == length was added in case the string didn't end in a period, whitespace, or comma
            * that it would include the last token
            */
            if (character == ' '|| character == ',' || character == '.' || i+1 == length)
            {
                //if it's one of those, then add the String to the ArrayList and reset token String
                tokens.add(token);
                token = "";
                continue;
            }
            //add the character to token String
            else {token += character;}
        }

        /*
        * I had an issue where blank tokens were being created
        * and added to the ArrayList
        * This is to get rid of them.
        */
        for (int i = 0; i < tokens.size(); i++)
        {
            if (tokens.get(i) == "")
            {
                tokens.remove(i);
                i--;
            }
        }

        //This is to print each token
        for (int i = 0; i < tokens.size(); i++)
        {
            if (i + 1 != tokens.size())
            {
                System.out.print("'" + tokens.get(i) + "', ");
            }
            else
            {
                System.out.print("'" + tokens.get(i) + "'");
            }
        }
        //Start next method on a new line
        System.out.println();
    }

    //Printing how many occurrences of each letter there are
    public static void getLettrFreq(String s)
    {
        //changes string to all uppercase letters
        String upperCase = s.toUpperCase();
        //Have an array that has the alphabet
        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K',
        'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        //same size array as alphabet to count
        int[] alphaCount = new int[alphabet.length];

        /*
        * Going through the alphabet to check each char in the string is equal to the letter
        */
        for (int i = 0; i < alphabet.length; i++)
        {
            char alpha = alphabet[i];
            int count = 0;
            for (int j = 0; j < upperCase.length(); j++)
            {
                char letter = upperCase.charAt(j);
                //if letter is equal to the alphabet, add it to count
                if (alpha == letter)
                {
                    count++;
                }
            }
            //then put value in array to represent # of occurrences
            alphaCount[i] = count;
        }

        //This is to print out the # of occurrences
        for (int i = 0; i < alphabet.length; i++)
        {
            if (i + 1 != alphabet.length)
            {
                System.out.print("'" + alphabet[i] + "': " + alphaCount[i] + ", ");
            }
            else
            {
                System.out.print("'" + alphabet[i] + "': " + alphaCount[i]);
            }
        }
        System.out.println();
    }
}
