using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10_Debug_Price_Change_Alert
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            double thershold = double.Parse(Console.ReadLine());

            double lastPrice = double.Parse(Console.ReadLine());

            for (int i = 0; i < n - 1; i++)
            {
                double currentPrice = double.Parse(Console.ReadLine());
                double percentOfDifference = PercentOfDifference(lastPrice, currentPrice);
                bool isSignificantDifference = IsSignificantDifference(percentOfDifference, thershold);
                string message = Get(currentPrice, lastPrice, percentOfDifference, isSignificantDifference);

                Console.WriteLine(message);

                lastPrice = currentPrice;
            }
        }

        private static string Get(double currentPrice, double lastPrice, double percentOfDifference, bool isSignificantDifference)
        {
            percentOfDifference *= 100;
            string massage = "";
            if (percentOfDifference == 0)
            {
                massage = string.Format("NO CHANGE: {0}", currentPrice);
            }
            else if (!isSignificantDifference)
            {
                massage = string.Format("MINOR CHANGE: {0} to {1} ({2:F2}%)", lastPrice, currentPrice, percentOfDifference);
            }
            else if (isSignificantDifference && (percentOfDifference > 0))
            {
                massage = string.Format("PRICE UP: {0} to {1} ({2:F2}%)", lastPrice, currentPrice, percentOfDifference);
            }
            else if (isSignificantDifference && (percentOfDifference < 0))
            {
                massage = string.Format("PRICE DOWN: {0} to {1} ({2:F2}%)", lastPrice, currentPrice, percentOfDifference);
            }

            return massage;
        }
        private static bool IsSignificantDifference(double threshold, double difference)
        {
            if (Math.Abs(threshold) >= difference)
            {
                return true;
            }
            return false;
        }

        private static double PercentOfDifference(double lastPrice, double currentPrice)
        {
            double result = (currentPrice - lastPrice) / lastPrice;
            return result;
        }
    }
}