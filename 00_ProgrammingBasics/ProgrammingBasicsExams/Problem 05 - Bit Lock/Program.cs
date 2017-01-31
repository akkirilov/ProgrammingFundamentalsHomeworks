using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_05___Bit_Lock
{
    class Program
    {
        static void Main(string[] args)
        {
            //220 min.
            string theNumbersFromString = Console.ReadLine();

            string[] theNumbersEll = theNumbersFromString.Split(' ');

            int[] nums = new int[theNumbersEll.Length];
            for (int i = 0; i < theNumbersEll.Length; i++)
            {
                nums[i] = int.Parse(theNumbersEll[i]);
            }
            
            string command = Console.ReadLine();

            while (command != "end")
            {
                string[] commandEll = command.Split(' ');

                if (commandEll[0] == "check")
                {
                    int colForCheck = int.Parse(commandEll[1]);
                    int countCols = 0;
                    for (int i = 0; i < 8; i++)
                    {
                        if ((nums[i] >> colForCheck & 1) == 1)
                        {
                            countCols++;
                        }
                    }
                    Console.WriteLine(countCols);
                }

                else 
                {
                    int row = int.Parse(commandEll[0]);
                    int rotation = int.Parse(commandEll[2]);

                    if (commandEll[1] == "left")
                    {
                        for (int i = 0; i < rotation % 12; i++)
                        {
                            int copyRow = nums[row];
                            nums[row] <<= 1;

                            if ((copyRow >> 11 & 1) == 1)
                            {
                                nums[row] &= ~(1 << 12);
                                nums[row] |= (1);
                            }
                        }
                    }

                    else if (commandEll[1] == "right")
                    {
                        for (int i = 0; i < rotation; i++)
                        {
                            int copyRow = nums[row];
                            nums[row] >>= 1;
                            if ((copyRow & 1) == 1)
                            {
                                nums[row] |= (1 << 11);
                            }
                        }
                    }
                }

                command = Console.ReadLine();
            }
            
            foreach (var item in nums)
            {
                Console.Write(item + " ");
            }
            Console.WriteLine();
        }
    }
}