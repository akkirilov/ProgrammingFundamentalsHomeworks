using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _18_Different_Integers_Size
{
    class Program
    {
        static void Main(string[] args)
        {
            long number = long.Parse(Console.ReadLine());
            if (number>long.MaxValue)
            {
                Console.WriteLine(number + " can't fit in any type");
                return;
            }

            Console.WriteLine(number + " can fit in:");
            if (number >= sbyte.MinValue && number<= sbyte.MaxValue)
            {
                Console.WriteLine("* sbyte");
            }
            else if (number >= byte.MinValue && number <= byte.MaxValue)
            {
                Console.WriteLine("* byte");
            }
            else if (number >= short.MinValue && number <= short.MaxValue)
            {
                Console.WriteLine("* short");
            }
            else if (number >= ushort.MinValue && number <= ushort.MaxValue)
            {
                Console.WriteLine("* ushort");
            }
            else if (number >= int.MinValue && number <= int.MaxValue)
            {
                Console.WriteLine("* int");
            }
            else if (number >= uint.MinValue && number <= uint.MaxValue)
            {
                Console.WriteLine("* uint");
            }
            else if (number >= long.MinValue && number <= long.MaxValue)
            {
                Console.WriteLine("* long");
            }
        }
    }
}