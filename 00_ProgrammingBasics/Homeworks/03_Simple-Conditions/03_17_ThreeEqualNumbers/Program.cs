using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_17_ThreeEqualNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int num0 = int.Parse(Console.ReadLine());
            int num1 = int.Parse(Console.ReadLine());
            int num2 = int.Parse(Console.ReadLine());

            if ((num0==num1) && (num1 == num2))
            {
                Console.WriteLine("yes");
            }
            else
            {
                Console.WriteLine("no");
            }
        }
    }
}
