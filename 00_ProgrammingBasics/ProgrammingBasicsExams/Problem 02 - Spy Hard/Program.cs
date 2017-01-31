using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_02___Spy_Hard
{
    class Program
    {
        static void Main(string[] args)
        {
            //40 min.
            int system = int.Parse(Console.ReadLine());
            string message = Console.ReadLine().ToLower();

            int number = 0;
            int length = message.Length;

            for (int i = 0; i < length; i++)
            {
                int currentChar = message[i];
                if (currentChar >= 'a' && currentChar <= 'z')
                {
                    number += (currentChar - 'a') + 1;
                }
                else
                {
                    number += currentChar;
                }
            }

            StringBuilder medium = new StringBuilder();

            while (number > 0)
            {
                medium.Insert(0,number % system);
                number /= system;
            }

            Console.WriteLine("{0}{1}{2}", system, length, medium);
        }
    }
}