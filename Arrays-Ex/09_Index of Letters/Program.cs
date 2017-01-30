using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09_Index_of_Letters
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            for (int i = 0; i < input.Length; i++)
            {
                int index = input[i] - 'a';
                Console.WriteLine(input[i] + " -> " + index);
            }
        }
    }
}