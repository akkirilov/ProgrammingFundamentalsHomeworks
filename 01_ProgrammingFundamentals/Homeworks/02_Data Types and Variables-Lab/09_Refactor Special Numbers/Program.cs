using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09_Refactor_Special_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int lastNumber = int.Parse(Console.ReadLine());

            for (int firstNumber = 1; firstNumber <= lastNumber; firstNumber++)
            {
                int sum = 0;
                int checkNumber = firstNumber;

                while (checkNumber > 0)
                {
                    sum += checkNumber % 10;
                    checkNumber = checkNumber / 10;
                }

                bool isSpecial = false;
                isSpecial = (sum == 5) || (sum == 7) || (sum == 11);

                Console.WriteLine($"{firstNumber} -> {isSpecial}");
            }
        }
    }
}