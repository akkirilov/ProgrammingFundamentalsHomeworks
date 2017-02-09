using System.Collections.Generic;
using System.IO;

namespace _02_Line_Numbers
{
    class LineNumbers
    {
        static void Main()
        {
            string[] textLines = File.ReadAllLines("input.txt");
            List<string> numLines = new List<string>();

            for (int i = 0; i < textLines.Length; i++)
            {
                numLines.Add($"{i + 1}. {textLines[i]}");
            }

            File.WriteAllLines("result.txt", numLines);
        }
    }
}