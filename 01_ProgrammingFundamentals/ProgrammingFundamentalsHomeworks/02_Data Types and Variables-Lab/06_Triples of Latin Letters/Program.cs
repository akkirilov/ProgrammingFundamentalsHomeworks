using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_Triples_of_Latin_Letters
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            char lastLetter = (char)('a' + n);

            for (char i = 'a'; i < lastLetter; i++)
            {
                for (int j = 'a'; j < lastLetter; j++)
                {
                    for (int k = 'a'; k < lastLetter; k++)
                    {
                        Console.WriteLine("{0}{1}{2}", (char)i, (char)j, (char)k);
                    }
                }
            }
        }
    }
}