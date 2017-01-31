using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_06___SpecialNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            //17 min.
            int n = int.Parse(Console.ReadLine());
            int cur = 0;
            int n1 = 0;
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            
            for (int i = 1111; i <= 9999; i++)
            {
                cur = i;
                n1 = cur % 10;
                cur /= 10;
                n2 = cur % 10;
                cur /= 10;
                n3 = cur % 10;
                cur /= 10;
                n4 = cur;
                if (n1 == 0 || n2 == 0 || n3 == 0 || n4 == 0)
                {
                    continue;
                }
                else if (n % n1 == 0)
                {
                    if (n % n2 == 0)
                    {
                        if (n % n3 == 0)
                        {
                            if (n % n4 == 0)
                            {
                                Console.Write(i + " ");
                            }
                        }
                    }
                }
            }
        }
    }
}