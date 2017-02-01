using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_Sum_Reversed_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> input = Console.ReadLine().Split(new char[] { ' '}, StringSplitOptions.RemoveEmptyEntries).ToList();
            int result = 0;

            for (int i = 0; i < input.Count; i++)
            {
                char[] temp = input[i].ToCharArray();
                Array.Reverse(temp);
                result += int.Parse(string.Format(String.Join("", temp)));
            }
            Console.WriteLine(result);
        }
    }
}