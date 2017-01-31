using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_Reverse_an_Array_of_Strings
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] array = Console.ReadLine().Split().ToArray();

            for (int i = 0; i < array.Length / 2; i++)
            {
                string temp = array[array.Length - 1 - i];
                array[array.Length - 1 - i] = array[i];
                array[i] = temp;
            }
            Console.WriteLine(String.Join(" ", array));
        }
    }
}