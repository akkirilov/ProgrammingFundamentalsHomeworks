using System.Collections.Generic;
using System.IO;

namespace _01_Odd_Lines
{
    class OddLines
    {
        static void Main()
        {
            string[] textLines = File.ReadAllLines("input.txt");

            List<string> onlyOddLines = new List<string>();

            for (int i = 1; i < textLines.Length; i += 2)
            {
                onlyOddLines.Add(textLines[i]);
            }

            File.WriteAllLines("result.txt", onlyOddLines);
        }
    }
}