using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_02___Encoded_Answers
{
    class Program
    {
        static void Main(string[] args)
        {
            uint n = uint.Parse(Console.ReadLine());
            string answer = "";
            uint cA = 0;
            uint cB = 0;
            uint cC = 0;
            uint cD = 0;

            for (int i = 1; i <= n; i++)
            {
                uint nn = uint.Parse(Console.ReadLine());
                if (nn%4 == 0)
                {
                    answer = answer + "a ";
                    cA += 1;
                }
                if (nn % 4 == 1)
                {
                    answer = answer + "b ";
                    cB += 1;
                }
                if (nn % 4 == 2)
                {
                    answer = answer + "c ";
                    cC += 1;
                }
                if (nn % 4 == 3)
                {
                    answer = answer + "d ";
                    cD += 1;
                }
            }
            Console.WriteLine(answer);
            Console.WriteLine("Answer A: {0}", cA);
            Console.WriteLine("Answer B: {0}", cB);
            Console.WriteLine("Answer C: {0}", cC);
            Console.WriteLine("Answer D: {0}", cD);
        }
    }
}
