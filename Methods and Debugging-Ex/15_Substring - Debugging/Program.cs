using System;

public class Substring_broken
{
    public static void Main()
    {
        string text = Console.ReadLine();
        int jump = int.Parse(Console.ReadLine()) + 1;
        const char search = 'p';
        bool hasMatch = false;
       

        for (int i = 0; i < text.Length; i++)
        {
            if (text[i] == search)
            {
                hasMatch = true;

                string matchedString = "";
                if (jump + i < text.Length)
                {
                    matchedString = text.Substring(i, jump);
                }
                else
                {
                    matchedString = text.Substring(i);
                }

                Console.WriteLine(matchedString);
                i += jump - 1;
            }
        }

        if (!hasMatch)
        {
            Console.WriteLine("no");
        }
    }
}