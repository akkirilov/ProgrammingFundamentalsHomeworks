using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01_NumeralTypesAndTypeConversion
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine();
            byte centuries = byte.Parse(Console.ReadLine());
            uint years = centuries * 100u;
            uint days = (uint)(years * 365.2422);
            ulong hours = days * 24;
            ulong minutes = hours * 60;

            Console.WriteLine("{0} centuries = {1} years = {2} days = {3} hours = {4} minutes", 
                centuries,years,days,hours,minutes);
        }
    }
}