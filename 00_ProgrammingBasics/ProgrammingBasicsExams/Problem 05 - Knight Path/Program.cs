using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_05___Knight_Path
{
    class Program
    {
        static void Main(string[] args)
        {
            //75 min.

            int vertical = 0;
            int temp = 0;
            int horizontal = 0;
            int[] board = new int[8];
            string line = Console.ReadLine().ToLower();
            for (int i = 1; i < board.Length; i++)
            {
                board[i] = 0;
            }
            board[0] = 1;

            while (line != "stop")
            {
                string[] lineEll = line.Split(' ');
                string line1 = lineEll[0];
                string line2 = lineEll[1];

                if (line1 == "left")
                {
                    if (horizontal+2<=7)
                    {
                        if (line2 == "up" && vertical-1>=0)
                        {
                            horizontal += 2;
                            vertical--;
                            if ((board[vertical]>>horizontal & 1) == 1)
                            {
                                board[vertical] = 0;
                            }
                            else
                            {
                                board[vertical] = board[vertical] | (1 << horizontal);
                            }
                        }
                        else if (line2 == "down" && vertical + 1 <= 7)
                        {
                            horizontal += 2;
                            vertical++;
                            if ((board[vertical] >> horizontal & 1) == 1)
                            {
                                board[vertical] = 0;
                            }
                            else
                            {
                                board[vertical] = board[vertical] | (1 << horizontal);
                            }
                        }
                    }
                }
                else if (line1 == "right")
                {
                    if (horizontal-2>=0)
                    {
                        if (line2 == "up" && vertical - 1 >= 0)
                        {
                            horizontal -= 2;
                            vertical--;
                            if ((board[vertical] >> horizontal & 1) == 1)
                            {
                                board[vertical] = 0;
                            }
                            else
                            {
                                board[vertical] = board[vertical] | (1 << horizontal);
                            }
                        }
                        else if (line2 == "down" && vertical + 1 <= 7)
                        {
                            horizontal -= 2;
                            vertical++;
                            if ((board[vertical] >> horizontal & 1) == 1)
                            {
                                board[vertical] = 0;
                            }
                            else
                            {
                                board[vertical] = board[vertical] | (1 << horizontal);
                            }
                        }
                    }
                }
                else if (line1 == "up")
                {
                    if (vertical-2 >=0)
                    {
                        if (line2 == "left")
                        {
                            vertical -= 2;
                            horizontal++;
                            if ((board[vertical] >> horizontal & 1) == 1)
                            {
                                board[vertical] = 0;
                            }
                            else
                            {
                                board[vertical] = board[vertical] | (1 << horizontal);
                            }
                        }
                        else if (line2 == "right")
                        {
                            vertical -= 2;
                            horizontal--;
                            if ((board[vertical] >> horizontal & 1) == 1)
                            {
                                board[vertical] = 0;
                            }
                            else
                            {
                                board[vertical] = board[vertical] | (1 << horizontal);
                            }
                        }
                    }
                }
                else if (line1 == "down")
                {
                    if (vertical+2<=7)
                    {
                        if (line2 == "left")
                        {
                            vertical += 2;
                            horizontal++;
                            if ((board[vertical] >> horizontal & 1) == 1)
                            {
                                board[vertical] = 0;
                            }
                            else
                            {
                                board[vertical] = board[vertical] | (1 << horizontal);
                            }
                        }
                        else if (line2 == "right")
                        {
                            vertical += 2;
                            horizontal--;
                            if ((board[vertical] >> horizontal & 1) == 1)
                            {
                                board[vertical] = 0;
                            }
                            else
                            {
                                board[vertical] = board[vertical] | (1 << horizontal);
                            }
                        }
                    }
                }
                line = Console.ReadLine().ToLower();
            }
            for (int i = 0; i < board.Length; i++)
            {
                if (board[i] != 0)
                {
                    temp++;
                }
            }
            if (temp>0)
            {
                for (int i = 0; i < board.Length; i++)
                {
                    if (board[i] != 0)
                    {
                        Console.WriteLine(board[i] + " ");
                    }
                }
            }
            else
            {
                Console.WriteLine("[Board is empty]");
            }
        }
    }
}