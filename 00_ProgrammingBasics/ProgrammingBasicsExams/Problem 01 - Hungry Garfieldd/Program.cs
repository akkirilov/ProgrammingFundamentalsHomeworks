using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_01___Hungry_Garfieldd
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal money = decimal.Parse(Console.ReadLine());
            decimal exChange = decimal.Parse(Console.ReadLine());
            decimal pizzaPrice = decimal.Parse(Console.ReadLine());
            decimal lasagnaPrice = decimal.Parse(Console.ReadLine());
            decimal sandwichPrice = decimal.Parse(Console.ReadLine());
            uint pizzaQuantity = uint.Parse(Console.ReadLine());
            uint lasagnaQuantity = uint.Parse(Console.ReadLine());
            uint sandwichQuantity = uint.Parse(Console.ReadLine());

            if (money*exChange >= pizzaPrice * pizzaQuantity + lasagnaPrice * lasagnaQuantity + sandwichPrice * sandwichQuantity)
            {
                Console.WriteLine("Garfield is well fed, John is awesome. Money left: ${0:f2}.", 
                    (money-((pizzaPrice * pizzaQuantity + lasagnaPrice * lasagnaQuantity + sandwichPrice * sandwichQuantity))/exChange));
            }
            if (money * exChange < pizzaPrice * pizzaQuantity + lasagnaPrice * lasagnaQuantity + sandwichPrice * sandwichQuantity)
            {
                Console.WriteLine("Garfield is hungry. John is a badass. Money needed: ${0:f2}.", 
                    (((pizzaPrice * pizzaQuantity + lasagnaPrice * lasagnaQuantity + sandwichPrice * sandwichQuantity) - (money*exChange)) / exChange));
            }
        }
    }
}
