using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08_Multiply_Evens_by_Odds
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());
            int result = MultiplyEvensByOdds(number);
            Console.WriteLine(result);
        }

        private static int MultiplyEvensByOdds(int number)
        {
            return SumEvensOrOdds(number, 1) * SumEvensOrOdds(number , 0);
        }
        private static int SumEvensOrOdds(int number, int reminder)
        {
            int result = 0;
            foreach (char item in number.ToString())
            {
                if ((item - '0') % 2 == reminder)
                {
                    result += (item - '0');
                }
            }
            return result;
        }
    }
}