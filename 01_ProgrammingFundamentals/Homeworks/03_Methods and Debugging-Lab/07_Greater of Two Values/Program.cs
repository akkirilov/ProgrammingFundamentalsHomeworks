using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_Greater_of_Two_Values
{
    class Program
    {
        static void Main(string[] args)
        {
            string type = Console.ReadLine();
            string first = Console.ReadLine();
            string second = Console.ReadLine();

            if (type == "string")
            {
                string result = GetMax(first, second);
                Console.WriteLine(result);
            }
            else if (type == "char")
            {
                char a = char.Parse(first);
                char b = char.Parse(second);
                char result = GetMax(a, b);
                Console.WriteLine(result);
            }
            else if (type == "int")
            {
                int a = int.Parse(first);
                int b = int.Parse(second);
                int result = GetMax(a, b);
                Console.WriteLine(result);
            }
        }

        private static int GetMax(int first, int second)
        {
            return Math.Max(first, second);
        }

        private static string GetMax(string first, string second)
        {
            if (first.CompareTo(second) >= 0)
            {
                return first;
            }
            else
            {
                return second;
            }
        }
        private static char GetMax(char first, char second)
        {
            return (char)GetMax((int)first, (int)second);
        }
    }
}