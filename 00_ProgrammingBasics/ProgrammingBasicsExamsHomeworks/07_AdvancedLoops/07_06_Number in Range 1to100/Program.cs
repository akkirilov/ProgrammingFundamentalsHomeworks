using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_06_Number_in_Range_1to100
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = 0;
            for (; n == 0;)
            {
                Console.Write("Еnter a number in the range [1...100]: ");
                int.TryParse(Console.ReadLine(), out n);

                if ((n <= 100) && (n > 0))
                {
                    Console.WriteLine("The number is: " + n);
                }
                else
                {
                    Console.WriteLine("Invalid number!");
                    n = 0;
                }
            }
        }
    }
}
