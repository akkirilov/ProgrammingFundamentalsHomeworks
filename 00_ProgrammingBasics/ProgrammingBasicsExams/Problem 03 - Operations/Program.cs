using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_03___Operations
{
    class Program
    {
        static void Main(string[] args)
        {
            //17 min.
            int n1 = int.Parse(Console.ReadLine());
            int n2 = int.Parse(Console.ReadLine());
            char c = char.Parse(Console.ReadLine());
            int r = 0;
            string oe = "odd";

            if (c == '+')
            {
                r = n1 + n2;
                if (r%2 == 0)
                {
                    oe = "even";
                }
                Console.WriteLine("{0} {1} {2} = {3} - {4}",n1,c,n2,(n1+n2), oe);
            }
            else if (c == '-')
            {
                r = n1 - n2;
                if (r % 2 == 0)
                {
                    oe = "even";
                }
                Console.WriteLine("{0} {1} {2} = {3} - {4}", n1, c, n2, (n1 - n2), oe);
            }
            else if (c == '*')
            {
                r = n1 * n2;
                if (r % 2 == 0)
                {
                    oe = "even";
                }
                Console.WriteLine("{0} {1} {2} = {3} - {4}", n1, c, n2, (n1 * n2), oe);
            }
            else if (c == '/')
            {
                if (n2 == 0)
                {
                    Console.WriteLine("Cannot divide {0} by zero", n1);
                    return;
                }
                double nn1 = n1;
                double nn2 = n2;
                double rr = r;
                rr = nn1 / nn2;
                Console.WriteLine("{0} {1} {2} = {3:f2}", n1, c, n2, (nn1 / nn2));
            }
            else if (c == '%')
            {
                if (n2 == 0)
                {
                    Console.WriteLine("Cannot divide {0} by zero", n1);
                    return;
                }
                r = n1 % n2;
                Console.WriteLine("{0} {1} {2} = {3}", n1, c, n2, (n1 % n2));
            }
        }
    }
}