using System;
using System.Collections.Generic;
using System.Linq;

namespace _20170106_04_Winning_Ticket
{
    public class WinningTicket
    {
        public static void Main()
        {
            List<string> tickets = Console.ReadLine()
                .Split(new char[] { ',', ' ', '\n', '\r', '\t' }, StringSplitOptions.RemoveEmptyEntries)
                .ToList();

            List<char> winningSymbols = new List<char>()
            {
                '$',
                '@',
                '^',
                '#'
            };

            for (int i = 0; i < tickets.Count; i++)
            {
                if (tickets[i].Length != 20)
                {
                    Console.WriteLine("invalid ticket");
                    continue;
                }

                string leftSide = tickets[i].Substring(0, 10);
                string rightSide = tickets[i].Substring(10);

                bool isWin = false;
                for (int s = 0; s < winningSymbols.Count; s++)
                {
                    if (!leftSide.Contains(winningSymbols[s]) || !rightSide.Contains(winningSymbols[s]))
                    {
                        continue;
                    }

                    int left = 0;
                    int leftCount = 0;
                    for (int l = 0; l < leftSide.Length; l++)
                    {
                        if (leftSide[l].Equals(winningSymbols[s]))
                        {
                            left++;
                        }
                        else
                        {
                            if (left > leftCount)
                            {
                                leftCount = left;
                            }
                            left = 0;
                        }
                    }
                    if (left > leftCount)
                    {
                        leftCount = left;
                    }

                    int right = 0;
                    int rightCount = 0;
                    for (int r = 0; r < rightSide.Length; r++)
                    {
                        if (rightSide[r].Equals(winningSymbols[s]))
                        {
                            right++;
                        }
                        else
                        {
                            if (right > rightCount)
                            {
                                rightCount = right;
                            }
                            right = 0;
                        }
                    }
                    if (right > rightCount)
                    {
                        rightCount = right;
                    }

                    if (leftCount > 5 && rightCount > 5)
                    {
                        if (leftCount < 10 || rightCount < 10)
                        {
                            Console.WriteLine($"ticket \"{tickets[i]}\" - {(leftCount < rightCount ? leftCount : rightCount)}{winningSymbols[s]}");
                            isWin = true;
                            break;
                        }
                        else if (leftCount == 10 && rightCount == 10)
                        {
                            Console.WriteLine($"ticket \"{tickets[i]}\" - {leftCount}{winningSymbols[s]} Jackpot!");
                            isWin = true;
                            break;
                        }
                    }
                }

                if (!isWin)
                {
                    Console.WriteLine($"ticket \"{tickets[i]}\" - no match");
                }
            }
        }
    }
}