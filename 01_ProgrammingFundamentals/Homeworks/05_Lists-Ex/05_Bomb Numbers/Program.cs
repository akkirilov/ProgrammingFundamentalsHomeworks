using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_Bomb_Numbers
{
    class Program
    {
        static void Main()
        {
            List<long> numbers = Console.ReadLine().Split().Select(long.Parse).ToList();
            List<long> parameters = Console.ReadLine().Split().Select(long.Parse).ToList();

            long bomb = parameters[0];
            int power = (int)parameters[1];

            for (int i = 0; i < numbers.Count; i++)
            {
                if (numbers[i] == bomb)
                {
                    int startIndex = (i - power <= 0 ? 0 : i - power);
                    int endIndex = (i + power >= numbers.Count ? numbers.Count - i - 1 : power) + i;

                    for (int j = startIndex; j <= endIndex; j++)
                    {
                        numbers.RemoveAt(startIndex);
                    }

                    i = startIndex - 1;
                }
            }

            Console.WriteLine(numbers.Sum());
        }
    }
}