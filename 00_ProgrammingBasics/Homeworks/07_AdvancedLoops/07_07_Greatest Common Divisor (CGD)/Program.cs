using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_07_Greatest_Common_Divisor__CGD_
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());

            int t = 0;
            int res = 1;

            if (a == b)
            {
                res = a;
            }
            else
            {
                if (a > b)
                {
                    for (;;)
                    {
                        t = a % b;
                        a = b;
                        if (t == 0)
                        {
                            res = a;
                            break;
                        }
                        b = t;
                    }
                }
                if (a < b)
                {
                    for (;;)
                    {
                        t = b % a;
                        b = a;
                        if (t == 0)
                        {
                            res = b;
                            break;
                        }
                        a = t;
                    }
                }
            }
            Console.WriteLine(res);
        }
    }
}