﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _17_Be_Positive___Debugging
{
    class Program
    {
        public static void Main()
        {
            int countSequences = int.Parse(Console.ReadLine());

            for (int i = 0; i < countSequences; i++)
            {
                string[] input = Console.ReadLine().Trim().Split();
                var numbers = new List<int>();
                for (int j = 0; j < input.Length; j++)
                {
                    if (!input[j].Equals(string.Empty))
                    {
                        int num = int.Parse(input[j]);
                        numbers.Add(num);
                    }
                }
                List<int> newNumberList = new List<int>();
                bool found = false;
                for (int j = 0; j < numbers.Count; j++)
                {
                    int currentNum = numbers[j];
                    if (currentNum >= 0)
                    {
                        newNumberList.Add(currentNum);
                        found = true;
                        continue;
                    }
                    else if(currentNum < 0 && j < numbers.Count - 1)
                    {
                        currentNum += numbers[j + 1];
                        if (currentNum >= 0)
                        {
                            newNumberList.Add(currentNum);
                            found = true;
                            j++;
                            continue;
                        }
                        else
                        {
                            j++;
                        }
                    }
                }
                if (!found)
                {
                    Console.WriteLine("(empty)");
                }
                else
                {
                    Console.WriteLine(String.Join(" ", newNumberList));
                }
            }
        }
    }
}