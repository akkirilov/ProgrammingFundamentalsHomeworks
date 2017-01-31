using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_02___Grand_Theft_Examo
{
    class Program
    {
        static void Main(string[] args)
        {
            //32 min
            int n = int.Parse(Console.ReadLine());
            long slapedThieves = 0;
            long drinkedBeers = 0;
            long esckapedThieves = 0;

            for (int i = 0; i < n; i++)
            {
                uint thieves = uint.Parse(Console.ReadLine());
                uint beers = uint.Parse(Console.ReadLine());

                if (thieves >= 5)
                {
                    slapedThieves += 5;
                    esckapedThieves += (thieves - 5);
                }
                else
                {
                    slapedThieves += thieves;
                }

                drinkedBeers += beers;
            }

            long sixPacks = drinkedBeers / 6;
            long beersOff = drinkedBeers % 6;

            Console.WriteLine("{0} thieves slapped.", slapedThieves);
            Console.WriteLine("{0} thieves escaped.", esckapedThieves);
            Console.WriteLine("{0} packs, {1} bottles.", sixPacks, beersOff);
        }
    }
}