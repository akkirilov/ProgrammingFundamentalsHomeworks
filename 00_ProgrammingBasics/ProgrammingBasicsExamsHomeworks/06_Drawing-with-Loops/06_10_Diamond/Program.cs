using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_10_Diamond
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int firstPartLength = (n + 1) / 2;
            int secondPartLength = n - firstPartLength;
            int dash = (n - 1) / 2;
            int lastDash = 0;
            int midDash = 0;
            int firstLastStar = 1;

            if (n % 2 == 0)
            {
                midDash += 1;
                firstLastStar = 2;
            }

            if (n == 1)
            {
                Console.Write(new string('*', firstLastStar));
                Console.WriteLine();
            }
            if (n == 2)
            {
                Console.Write(new string('*', firstLastStar));
                Console.WriteLine();
            }
            if (n >= 3)
            {
                Console.Write(new string('-', dash));
                Console.Write(new string('*', firstLastStar));
                Console.Write(new string('-', dash));
                Console.WriteLine();
                midDash = 1;
                lastDash = dash;
            }

            if (n % 2 != 0)
            {
                for (int i = 0; i < firstPartLength - 1; i++)
                {
                    dash -= 1;

                    Console.Write(new string('-', dash));
                    Console.Write(new string('*', 1));
                    Console.Write(new string('-', midDash));
                    Console.Write(new string('*', 1));
                    Console.Write(new string('-', dash));
                    Console.WriteLine();

                    midDash += 2;
                }
            }

            if ((n % 2 == 0) && (n >= 3))
            {
                midDash += 1;
                for (int i = 0; i < firstPartLength - 1; i++)
                {
                    dash -= 1;

                    Console.Write(new string('-', dash));
                    Console.Write(new string('*', 1));
                    Console.Write(new string('-', midDash));
                    Console.Write(new string('*', 1));
                    Console.Write(new string('-', dash));
                    Console.WriteLine();

                    midDash += 2;
                }
            }

            if (n >= 5)
            {
            midDash -= 2;
            }
            if (n < 5)
            {
                midDash = 2;
            }

            for (int i = 0; i < secondPartLength - 1; i++)
            {
                dash += 1;
                midDash -= 2;
                Console.Write(new string('-', dash));
                Console.Write(new string('*', 1));
                Console.Write(new string('-', midDash));
                Console.Write(new string('*', 1));
                Console.Write(new string('-', dash));
                Console.WriteLine();
            }

            if ((n >= 3) && (n % 2 != 0))
            {
                Console.Write(new string('-', lastDash));
                Console.Write(new string('*', firstLastStar));
                Console.Write(new string('-', lastDash));
                Console.WriteLine();
            }
        }
    }
}
