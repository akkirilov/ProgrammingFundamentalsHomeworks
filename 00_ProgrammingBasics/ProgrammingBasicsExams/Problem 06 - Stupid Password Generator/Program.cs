using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_06___Stupid_Password_Generator
{
    class Program
    {
        static void Main(string[] args)
        {
            //15 min.
            int n = int.Parse(Console.ReadLine());
            int c = int.Parse(Console.ReadLine());

            for (int i1 = 1; i1 < n; i1++)
            {
                for (int i2 = 1; i2 < n; i2++)
                {
                    for (char c1 = 'a'; c1 < 'a' + c; c1++)
                    {
                        for (char c2 = 'a'; c2 < 'a' + c; c2++)
                        {
                            for (int i3 = Math.Max(i1,i2)+1; i3 <= n; i3++)
                            {
                                Console.Write("{0}{1}{2}{3}{4} ", i1,i2,c1,c2,i3);
                            }
                        }
                    }
                }
            }
        }
    }
}