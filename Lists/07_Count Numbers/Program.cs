using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_Count_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).OrderBy(x => x).ToList();

            Dictionary<int, int> countedNumbers = new Dictionary<int, int>();

            for (int i = 0; i < numbers.Count; i++)
            {
                if (countedNumbers.ContainsKey(numbers[i]))
                {
                    countedNumbers[numbers[i]]++;
                }
                else
                {
                    countedNumbers.Add(numbers[i], 1);
                }
            }

            foreach (var pair in countedNumbers)
            {
                Console.WriteLine($"{pair.Key} -> {pair.Value}");
            }
        }
    }
}