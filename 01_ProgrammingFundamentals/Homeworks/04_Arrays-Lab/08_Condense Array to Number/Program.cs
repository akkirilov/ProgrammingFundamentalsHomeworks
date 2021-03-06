﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08_Condense_Array_to_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine().Split().Select(int.Parse).ToArray();
            if (nums.Length == 1)
            {
                Console.WriteLine($"{nums[0]} is already condensed to number");
                return;
            }

            int[] condensed = new int[nums.Length - 1];
            int length = nums.Length;

            while (length > 1)
            {
                for (int i = 0; i < length - 1; i++)
                {
                    condensed[i] = nums[i] + nums[i + 1];
                }

                nums = condensed.ToArray();

                length--;
            }
                Console.WriteLine(nums[0]);
        }
    }
}