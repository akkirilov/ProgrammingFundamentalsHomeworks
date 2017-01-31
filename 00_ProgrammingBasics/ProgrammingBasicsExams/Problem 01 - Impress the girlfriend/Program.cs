using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_01___Impress_the_girlfriend
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal rubles = decimal.Parse(Console.ReadLine());
            decimal dollars = decimal.Parse(Console.ReadLine());
            decimal euro = decimal.Parse(Console.ReadLine());
            decimal leva = decimal.Parse(Console.ReadLine());
            decimal leva1 = decimal.Parse(Console.ReadLine());

            rubles = ((rubles / 100m) * 3.50m);
            dollars *= 1.50m;
            euro *= 1.95m;
            leva /= 2;

            decimal a = Math.Max(Math.Max((Math.Max(rubles, dollars)), (Math.Max(euro, leva))), leva1);
            Console.WriteLine("{0:f2}", Math.Ceiling(a));
        }
    }
}
