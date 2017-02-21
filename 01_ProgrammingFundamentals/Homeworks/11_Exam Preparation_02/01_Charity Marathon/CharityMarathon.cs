using System;

namespace _01_Charity_Marathon
{
    public class CharityMarathon
    {
        public static void Main()
        {
            int marathonLength = int.Parse(Console.ReadLine());
            long runners = long.Parse(Console.ReadLine());
            int averageLapsPerRunner = int.Parse(Console.ReadLine());
            int trackLength = int.Parse(Console.ReadLine());
            int trackCapacity = int.Parse(Console.ReadLine());
            decimal moneyPerKilometer = decimal.Parse(Console.ReadLine());

            if (trackCapacity * marathonLength < runners)
            {
                runners = trackCapacity * marathonLength;
            }

            long kilometers = (runners * averageLapsPerRunner * trackLength) / 1000;
            Console.WriteLine($"Money raised: {kilometers * moneyPerKilometer:f2}");
        }
    }
}