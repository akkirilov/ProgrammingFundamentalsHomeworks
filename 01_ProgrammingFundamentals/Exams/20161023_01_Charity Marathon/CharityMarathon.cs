using System;

namespace _20161023_01_Charity_Marathon
{
    class CharityMarathon
    {
        static void Main()
        {
            Console.WriteLine(int.MaxValue);
            int days = int.Parse(Console.ReadLine());
            long runners = long.Parse(Console.ReadLine());
            int averageLaps = int.Parse(Console.ReadLine());
            int trackLength = int.Parse(Console.ReadLine());
            int trackCapacity = int.Parse(Console.ReadLine());
            decimal moneyPerKM = decimal.Parse(Console.ReadLine());

            if (trackCapacity * days < runners)
            {
                runners = trackCapacity * days;
            }

            long totalKM = (runners * averageLaps * trackLength) / 1000;

            decimal tottalMoney = totalKM * moneyPerKM;
            Console.WriteLine($"Money raised: {tottalMoney:f2}");
        }
    }
}