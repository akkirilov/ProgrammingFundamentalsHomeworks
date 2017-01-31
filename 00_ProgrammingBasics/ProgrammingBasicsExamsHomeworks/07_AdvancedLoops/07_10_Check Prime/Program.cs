using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_10_Check_Prime
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            bool prime = true;

            for (int i = 1; i <= n; i++)
            {
                for (int ii = 2; ii < n; ii++)
                {
                    if (i != ii)
                    {
                        if (i % ii == 0)
                        {
                        
                        }
                    }
                if (prime == true)
                {
                    Console.WriteLine(i);
                }
                }
            }


        }
    }
}
