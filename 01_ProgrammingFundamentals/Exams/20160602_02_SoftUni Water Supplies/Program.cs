using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20160602_02_SoftUni_Water_Supplies
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal waterAmount = decimal.Parse(Console.ReadLine());
            decimal[] bottles = Console.ReadLine().Split().Select(decimal.Parse).ToArray();
            decimal bottlesCapacity = decimal.Parse(Console.ReadLine());
            decimal neededWater = 0;
            for (int i = 0; i < bottles.Length; i++)
            {
                neededWater += (bottlesCapacity - bottles[i]);
            }

            if (waterAmount >= neededWater)
            {
                for (int i = 0; i < bottles.Length; i++)
                {
                    waterAmount -= (bottlesCapacity - bottles[i]);
                }
                Console.WriteLine("Enough water!");
                Console.WriteLine("Water left: {0}l.", waterAmount);
                return;
            }

            List<int> emptyIndexes = new List<int>();
            neededWater = 0;
            if (waterAmount % 2 == 0)
            {
                for (int i = 0; i < bottles.Length; i++)
                {
                    if (waterAmount > 0)
                    {
                        if (waterAmount >= (bottlesCapacity - bottles[i]))
                        {
                            waterAmount -= (bottlesCapacity - bottles[i]);
                        }
                        else
                        {
                            bottles[i] += waterAmount;
                            neededWater += bottlesCapacity - bottles[i];
                            emptyIndexes.Add(i);
                            waterAmount = 0;
                        }
                    }
                    else
                    {
                        neededWater += bottlesCapacity - bottles[i];
                        emptyIndexes.Add(i);
                    }
                }
            }
            else
            {
                for (int i = bottles.Length - 1; i >= 0; i--)
                {
                    if (waterAmount > 0)
                    {
                        if (waterAmount>= (bottlesCapacity - bottles[i]))
                        {
                            waterAmount -= (bottlesCapacity - bottles[i]);
                        }
                        else
                        {
                            bottles[i] += waterAmount;
                            neededWater += bottlesCapacity - bottles[i];
                            emptyIndexes.Add(i);
                            waterAmount = 0;
                        }
                    }
                    else
                    {
                        neededWater += bottlesCapacity - bottles[i];
                        emptyIndexes.Add(i);
                    }
                }
            }

            Console.WriteLine("We need more water!");
            Console.WriteLine("Bottles left: {0}", emptyIndexes.Count);
            Console.WriteLine("With indexes: {0}", String.Join(", ", emptyIndexes));
            Console.WriteLine("We need {0} more liters!", neededWater);
        }
    }
}