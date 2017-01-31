using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_Square_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).OrderByDescending(x => x).ToList();
            List<int> squareNumbers = new List<int>();

            for (int i = 0; i < numbers.Count; i++)
            {
                if (Math.Sqrt(numbers[i]) % 1 == 0)
                {
                    squareNumbers.Add(numbers[i]);
                }
            }

            Console.WriteLine(String.Join(" ", squareNumbers));
        }
    }
}