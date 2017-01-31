using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20160601_02_Array_Modifier
{
    class Program
    {
        static void Main(string[] args)
        {
            long[] numbers = Console.ReadLine().Split().Select(long.Parse).ToArray();
            List<long> result = new List<long>();
            string command = Console.ReadLine();

            while (command != "end")
            {
                string[] commandEll = command.Split();

                if (commandEll[0] == "swap")
                {
                    long i1 = long.Parse(commandEll[1]);
                    long i2 = long.Parse(commandEll[2]);
                    long temp = numbers[i1];
                    numbers[i1] = numbers[i2];
                    numbers[i2] = temp;
                }
                else if (commandEll[0] == "multiply")
                {
                    long i1 = long.Parse(commandEll[1]);
                    long i2 = long.Parse(commandEll[2]);
                    numbers[i1] *= numbers[i2];
                }
                else if (commandEll[0] == "decrease")
                {
                    for (int i = 0; i < numbers.Length ; i++)
                    {
                        numbers[i]--;
                    }
                }
                command = Console.ReadLine();
            }

            Console.WriteLine(String.Join(", ",numbers));
        }
    }
}