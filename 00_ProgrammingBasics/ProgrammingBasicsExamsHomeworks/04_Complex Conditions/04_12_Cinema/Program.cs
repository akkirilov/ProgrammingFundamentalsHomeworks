using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_12_Cinema
{
    class Program
    {
        static void Main(string[] args)
        {
            string type = Console.ReadLine().ToLower();
            int r = int.Parse(Console.ReadLine());
            int c = int.Parse(Console.ReadLine());

            switch (type)
            {
                case "premiere": Console.WriteLine("{0:f2}", c * r * 12.00d); break;
                case "normal": Console.WriteLine("{0:f2}", c * r * 7.50d); break;
                case "discount": Console.WriteLine("{0:f2}", c * r * 5.00d); break;
            }
        }
    }
}
