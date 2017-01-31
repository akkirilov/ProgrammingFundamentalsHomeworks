using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_03___Illuminati_Lock
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int outD = n-2;
            int inD = n-2;
            int ininD = 0;

            Console.Write(new string('.', n));
            Console.Write(new string('#', n));
            Console.Write(new string('.', n));
            Console.WriteLine();

            for (int i = 0; i < n/2; i++)
            {
                Console.Write(new string('.', outD));
                Console.Write(new string('#', 2));
                Console.Write(new string('.', ininD));
                Console.Write(new string('#', 1));
                Console.Write(new string('.', inD));
                Console.Write(new string('#', 1));
                Console.Write(new string('.', ininD));
                Console.Write(new string('#', 2));
                Console.Write(new string('.', outD));
                Console.WriteLine();

                outD -= 2;
                ininD += 2;
            }

            for (int i = 0; i < n / 2; i++)
            {
                outD += 2;
                ininD -= 2;

                Console.Write(new string('.', outD));
                Console.Write(new string('#', 2));
                Console.Write(new string('.', ininD));
                Console.Write(new string('#', 1));
                Console.Write(new string('.', inD));
                Console.Write(new string('#', 1));
                Console.Write(new string('.', ininD));
                Console.Write(new string('#', 2));
                Console.Write(new string('.', outD));
                Console.WriteLine();
            }

            Console.Write(new string('.', n));
            Console.Write(new string('#', n));
            Console.Write(new string('.', n));
            Console.WriteLine();
        }
    }
}