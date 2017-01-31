using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_04___Encrypted_matrix
{
    class Program
    {
        static void Main(string[] args)
        {
            //100 min. - 70t. ; 240 min. - 100 t.
            string line = Console.ReadLine();
            char direction = char.Parse(Console.ReadLine());

            string newLine = "";

            for (int i = 0; i < line.Length; i++)
            {
                if ((line[i] % 10) % 2 == 0)
                {
                    newLine += ((line[i] % 10) * (line[i] % 10));
                }
                else if (line.Length == 1 && ((line[i] % 10) % 2 == 1))
                {
                    newLine += (line[i] % 10);
                }
                else
                {
                    if (i == 0)
                    {
                        newLine += ((line[i] % 10) + (line[(i + 1)] % 10));
                    }
                    else if (i == line.Length - 1)
                    {
                        newLine += ((line[i] % 10) + (line[(i - 1)] % 10));
                    }
                    else
                    {
                        newLine += ((line[i] % 10) + (line[(i + 1)] % 10) + (line[(i - 1)] % 10));
                    }
                }
            }
            int cc = newLine.Length - 1;
            if (direction == '\\')
            {
                cc = 0;
            }
            for (int i = 0; i < newLine.Length; i++)
            {
                for (int j = 0; j < newLine.Length; j++)
                {
                    if (cc == j)
                    {
                        Console.Write(newLine[cc] + " ");
                    }
                    else
                    {
                        Console.Write("0 ");
                    }
                }
                if (direction == '\\')
                {
                    cc++;
                }
                else
                {
                    cc--;
                }
                Console.WriteLine();
            }
        }
    }
}