using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_01___RepairingTheTiles
{
    class Program
    {
        static void Main(string[] args)
        {
            //8 min.
            int wPl = int.Parse(Console.ReadLine());
            double wPlochka = double.Parse(Console.ReadLine());
            double lPlochka = double.Parse(Console.ReadLine());
            int wPeika = int.Parse(Console.ReadLine());
            int lPeika = int.Parse(Console.ReadLine());

            double broi = ((wPl * wPl) - (wPeika * lPeika)) / (wPlochka * lPlochka);
            double vreme = broi * 0.2d;

            Console.WriteLine(broi);
            Console.WriteLine(vreme);
        }
    }
}
