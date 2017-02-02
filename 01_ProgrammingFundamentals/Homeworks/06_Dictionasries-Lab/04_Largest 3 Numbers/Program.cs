using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_Largest_3_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<decimal> numbers = Console.ReadLine().Split().Select(decimal.Parse).ToList();

            numbers = numbers.OrderByDescending(x => x).Take(3).ToList();

            numbers.ForEach(x => Console.Write(x + " "));
        }
    }
}