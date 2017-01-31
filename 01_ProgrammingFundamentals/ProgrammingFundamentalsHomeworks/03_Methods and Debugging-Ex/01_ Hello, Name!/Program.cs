using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01__Hello__Name_
{
    class Program
    {
        static void Main(string[] args)
        {
            PrintName(Console.ReadLine());
        }

        private static void PrintName(string name)
        {
            Console.WriteLine($"Hello, {name}!");
        }
    }
}