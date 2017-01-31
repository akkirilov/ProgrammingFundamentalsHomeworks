using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_01___Money.docx
{
    class Program
    {
        static void Main(string[] args)
        {
            //9 min.
            double bit = double.Parse(Console.ReadLine()) * 1168;
            double china = (double.Parse(Console.ReadLine()) * 0.15)*1.76;
            double com = double.Parse(Console.ReadLine())/100;

            Console.WriteLine(((bit + china) / 1.95) - (((bit + china) / 1.95) * com));
        }
    }
}