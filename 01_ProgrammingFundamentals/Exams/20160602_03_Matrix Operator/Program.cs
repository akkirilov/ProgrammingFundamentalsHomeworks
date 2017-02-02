using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20160602_03_Matrix_Operator
{
    class Program
    {
        static void Main(string[] args)
        {
            List<List<int>> matrix = new List<List<int>>();
            int n = int.Parse(Console.ReadLine());
            for (int r = 0; r < n; r++)
            {
                matrix.Add(Console.ReadLine().Split().Select(int.Parse).ToList());
            }

            string[] command = Console.ReadLine().Split().ToArray();
            while (command[0] != "end")
            {
                if (command[0] == "swap")
                {
                    int rowA = int.Parse(command[1]);
                    int rowB = int.Parse(command[2]);

                    List<int> temp = new List<int>(matrix[rowA]);
                    matrix[rowA] = matrix[rowB];
                    matrix[rowB] = temp;
                }
                else if (command[0] == "insert")
                {
                    int row = int.Parse(command[1]);
                    int num = int.Parse(command[2]);

                    matrix[row].Insert(0, num);
                }
                else if(command[0] == "remove")
                {
                    string operation = command[1];
                    string direction = command[2];

                    if (direction == "row")
                    {
                        int row = int.Parse(command[3]);
                        switch (operation)
                        {
                            case "positive": matrix[row] = matrix[row].Where(x => x < 0).ToList();
                                break;
                            case "negative": matrix[row] = matrix[row].Where(x => x >= 0).ToList();
                                break;
                            case "odd": matrix[row] = matrix[row].Where(x => x % 2 == 0).ToList();
                                break;
                            case "even": matrix[row] = matrix[row].Where(x => x % 2 != 0).ToList();
                                break;
                        }
                    }
                    else
                    {
                        int col = int.Parse(command[3]);
                        switch (operation)
                        {
                            case "positive":
                                for (int row = 0; row < matrix.Count; row++)
                                {
                                    if (matrix[row].Count > col && matrix[row][col] >= 0)
                                    {
                                        matrix[row].RemoveAt(col);
                                    }
                                }
                                break;
                            case "negative":
                                for (int row = 0; row < matrix.Count; row++)
                                {
                                    if (matrix[row].Count > col && matrix[row][col] < 0)
                                    {
                                        matrix[row].RemoveAt(col);
                                    }
                                }
                                break;
                            case "odd":
                                for (int row = 0; row < matrix.Count; row++)
                                {
                                    if (matrix[row].Count > col && matrix[row][col] % 2 != 0)
                                    {
                                        matrix[row].RemoveAt(col);
                                    }
                                }
                                break;
                            case "even":
                                for (int row = 0; row < matrix.Count; row++)
                                {
                                    if (matrix[row].Count > col && matrix[row][col] % 2 == 0)
                                    {
                                        matrix[row].RemoveAt(col);
                                    }
                                }
                                break;
                        }
                    }
                }
                
                command = Console.ReadLine().ToLower().Split().ToArray();
            }

            foreach (var row in matrix)
            {
                Console.WriteLine(String.Join(" ", row));
            }
        }
    }
}