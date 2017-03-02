using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_09_house
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int roofLength = n / 2;
            int firstStars = 2;
            int dash = (n - firstStars) / 2;
            int bodyLength = (n / 2);

            if (n % 2 != 0)
            {
                firstStars = 1;
                roofLength += 1;
                dash = (n - firstStars) / 2;
            }

            Console.Write(new string('-', dash));
            Console.Write(new string ('*', firstStars));
            Console.Write(new string('-', dash));
            Console.WriteLine();

            int midStars = firstStars;
            for (int i = 1; i < roofLength; i++)
            {
                dash -= 1;
                midStars += 2;
                Console.Write(new string('-', dash));
                Console.Write(new string('*', midStars));
                Console.Write(new string('-', dash));
                Console.WriteLine();
            }

            midStars -= 2;
            for (int i = 0; i < bodyLength; i++)
            {
                Console.Write(new string('|', 1));
                Console.Write(new string('*', midStars));
                Console.Write(new string('|', 1));
                Console.WriteLine();
            }
        }
    }
}
