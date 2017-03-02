using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_13_EqualWords
{
    class Program
    {
        static void Main(string[] args)
        {
            string word0 = Console.ReadLine().ToLower();
            string word1 = Console.ReadLine().ToLower();

            if (word0 == word1)
            {
                Console.WriteLine("yes");
            }
            else
            {
                Console.WriteLine("no");
            }
        }
    }
}
