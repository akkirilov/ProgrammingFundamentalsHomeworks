using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_05_InvalidNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());

            if (num == 0)
            {
            }
            else if ((num < 100) || (num > 200))
            {
                Console.WriteLine("invalid");
            }
            
        }
    }
}
