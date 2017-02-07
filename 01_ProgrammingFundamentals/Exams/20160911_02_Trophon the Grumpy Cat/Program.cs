using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20160911_02_Trophon_the_Grumpy_Cat
{
    class Program
    {
        private static int i;

        static void Main(string[] args)
        {
            int[] items = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int entryIndex = int.Parse(Console.ReadLine());
            int entryItem = items[entryIndex];
            string typeOfItems = Console.ReadLine();
            string pricePoinOfItem = Console.ReadLine();

            long left = 0;
            for (int i = 0; i < entryIndex; i++)
            {
                left += CountCosts(typeOfItems, pricePoinOfItem, items[i], entryItem);
            }

            long right = 0;
            for (int i = entryIndex + 1; i < items.Length; i++)
            {
                right += CountCosts(typeOfItems, pricePoinOfItem, items[i], entryItem);
            }

            if (left >= right)
            {
                Console.WriteLine("Left - " + left);
            }
            else
            {
                Console.WriteLine("Right - " + right);
            }
        }

        private static int CountCosts(string itemType, string pricePoint, int currentItem, int entryItem)
        {
            int costs = 0;
            if (itemType == "cheap")
            {
                if (pricePoint == "negative")
                {
                    if (currentItem < entryItem && currentItem < 0)
                    {
                        costs = currentItem;
                    }
                }
                else if (pricePoint == "positive")
                {
                    if (currentItem < entryItem && currentItem >= 0)
                    {
                        costs = currentItem;
                    }
                }
                else if (pricePoint == "all")
                {
                    if (currentItem < entryItem)
                    {
                        costs = currentItem;
                    }
                }
            }
            else
            {
                if (pricePoint == "negative")
                {
                    if (currentItem >= entryItem && currentItem < 0)
                    {
                        costs = currentItem;
                    }
                }
                else if (pricePoint == "positive")
                {
                    if (currentItem >= entryItem && currentItem >= 0)
                    {
                        costs = currentItem;
                    }
                }
                else if (pricePoint == "all")
                {
                    if (currentItem >= entryItem)
                    {
                        costs = currentItem;
                    }
                }
            }

            return costs;
        }
    }
}