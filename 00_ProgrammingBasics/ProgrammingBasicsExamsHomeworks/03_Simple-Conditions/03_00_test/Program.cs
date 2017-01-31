using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_00_test
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());
            var str = Console.ReadLine();

            switch (num)
            {
                case 1: Console.WriteLine("1a");break;
                case 2: Console.WriteLine("2a"); break;
                case 3: Console.WriteLine("3a"); break;
                case 4: Console.WriteLine("4a"); break;
                case 5: Console.WriteLine("5a"); break;
                case 6:
                    int n6 = int.Parse(Console.ReadLine());
                    switch (n6)
                    {
                        case 1: Console.WriteLine("So close"); break;
                        case 2: Console.WriteLine("So close"); break;
                        case 3: Console.WriteLine("So close"); break;
                        case 4: Console.WriteLine("So close"); break;
                        case 5: Console.WriteLine("So close"); break;
                        case 6: Console.WriteLine("Well done"); break;
                    }break;

                default: Console.WriteLine("Invalid Number!"); break;
            }

            switch (str)
            {
                case "a": Console.WriteLine("1a"); break;
                case "b": Console.WriteLine("2a"); break;
                case "c": Console.WriteLine("3a"); break;
                case "d": Console.WriteLine("4a"); break;
                case "e": Console.WriteLine("5a"); break;
                default: Console.WriteLine("Invalid String!"); break;
            }


        }
    }
}
