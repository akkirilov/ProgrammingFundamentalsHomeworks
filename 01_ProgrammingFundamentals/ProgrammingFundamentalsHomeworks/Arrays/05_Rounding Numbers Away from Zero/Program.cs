using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_Rounding_Numbers_Away_from_Zero
{
    class Program
    {
        static void Main(string[] args)
        {
            double[] array = Console.ReadLine().Split().Select(double.Parse).ToArray();

            for (int i = 0; i < array.Length; i++)
            {
                double afterRound = Math.Abs(array[i]);
                if (afterRound >= (int)afterRound + 0.5)
                {
                    afterRound = (int)afterRound + 1;
                }
                else
                {
                    afterRound = (int)afterRound;
                }

                if (array[i] < 0)
                {
                    afterRound *= -1;
                }
                
                Console.WriteLine($"{array[i]} => {(int)afterRound}");
            }
        }
    }
}