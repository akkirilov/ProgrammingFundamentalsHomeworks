using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_Boolean_Variable
{
    class Program
    {
        static void Main(string[] args)
        {
            bool a = bool.Parse(Console.ReadLine());
            if (a)
            {
                Console.WriteLine("Yes");
            }
            else
            {
                Console.WriteLine("No");
            }
        }
    }
}