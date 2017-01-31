using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_02___Harvest
{
    class Program
    {
        static void Main(string[] args)
        {
            //12 min.
            double loze = double.Parse(Console.ReadLine()) * 0.4d;
            double litri = (double.Parse(Console.ReadLine()) * loze) / 2.5d;
            int nuzhno = int.Parse(Console.ReadLine());
            int rabotnici = int.Parse(Console.ReadLine());

            if (litri < nuzhno)
            {
                Console.WriteLine("It will be a tough winter! More {0} liters wine needed.", 
                    Math.Floor(nuzhno - litri));
            }
            else
            {
                Console.WriteLine("Good harvest this year! Total wine: {0} liters.", Math.Floor(litri));
                Console.WriteLine("{0} liters left -> {1} liters per person.", 
                    Math.Ceiling(litri - nuzhno), Math.Ceiling((litri - nuzhno) / rabotnici));
            }
        }
    }
}