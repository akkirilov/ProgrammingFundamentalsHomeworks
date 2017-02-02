using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01_Count_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<decimal> numbers = Console.ReadLine().Split().Select(decimal.Parse).ToList();
            Dictionary<decimal, int> countNumbers = new Dictionary<decimal, int>();

            for (int i = 0; i < numbers.Count; i++)
            {
                if (countNumbers.ContainsKey(numbers[i]))
                {
                    countNumbers[numbers[i]]++;
                    continue;
                }
                
                countNumbers.Add(numbers[i], 1);
            }

            foreach (var number in countNumbers.OrderBy(x => x.Key))
            {
                Console.WriteLine($"{number.Key} -> {number.Value}");
            }
        }
    }
}