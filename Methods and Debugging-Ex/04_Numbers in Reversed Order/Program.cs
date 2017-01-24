using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_Numbers_in_Reversed_Order
{
    class Program
    {
        static void Main(string[] args)
        {
            string textInString = Console.ReadLine();
            PrintStringInReverse(textInString);

        }

        private static void PrintStringInReverse(string someString)
        {
            char[] chars = someString.ToCharArray();
            Array.Reverse(chars);
            foreach (var item in chars)
            {
                Console.Write(item);
            }
            Console.WriteLine();
        }
    }
}