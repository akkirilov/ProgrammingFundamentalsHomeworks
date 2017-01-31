using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_01___Cake_Tycoon
{
    class Program
    {
        static void Main(string[] args)
        {
            int numberCackes = int.Parse(Console.ReadLine());
            double flourNeeded = double.Parse(Console.ReadLine());
            int flourAvailable = int.Parse(Console.ReadLine());
            int trufflesAvailable = int.Parse(Console.ReadLine());
            double trufflesPrice = double.Parse(Console.ReadLine());
            double count = 0;
            double oneAmount = 0;

            if ((flourAvailable / flourNeeded) >= numberCackes)
            {
                trufflesPrice *= trufflesAvailable;
                oneAmount = (trufflesPrice / numberCackes) * 1.25;
                Console.WriteLine("All products available, price of a cake: {0:f2}", oneAmount);

            }
            if ((flourAvailable / flourNeeded) < numberCackes)
            {
                trufflesPrice *= trufflesAvailable;
                count = Math.Floor(flourAvailable / flourNeeded);
                oneAmount = (trufflesPrice / count ) * 1.25;
                double unavailableFlour = (numberCackes * flourNeeded) - flourAvailable;

                Console.WriteLine("Can make only {0} cakes, need {1:f2} kg more flour", count, unavailableFlour);
            }
        }
    }
}
