using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_Special_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = 1; i <= n; i++)
            {
                int temp = i;
                int result = 0;

                while (temp > 0)
                {
                    result += (temp % 10);
                    temp /= 10; 
                }

                if (result == 5 || result == 7 || result == 11)
                {
                    Console.WriteLine("{0} -> True", i);
                }

                else
                {
                    Console.WriteLine("{0} -> False", i);
                }
            }
        }
    }
}