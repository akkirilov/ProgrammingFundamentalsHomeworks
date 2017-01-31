using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_02___Basket_Battle
{
    class Program
    {
        static void Main(string[] args)
        {
            //90 min.
            string firstShooter = Console.ReadLine();
            int runds = int.Parse(Console.ReadLine());
            string player = "Nakov";
            if (firstShooter == "Simeon")
            {
                player = "Simeon";
            }
            int simeonScore = 0;
            int nakovScore = 0;
            int count = 0;

            int points = 0;
            string status = "";
            for (int i = 0; i < runds; i++)
            {
                count++;
                if (player == "Simeon")
                {
                    points = int.Parse(Console.ReadLine());
                    status = Console.ReadLine();
                    if (simeonScore + points < 500 && status == "success")
                    {
                        simeonScore += points;
                    }
                    else if (simeonScore + points == 500 && status == "success")
                    {
                        Console.WriteLine("Simeon");
                        Console.WriteLine(count);
                        Console.WriteLine(nakovScore);
                        return;
                    }
                    points = int.Parse(Console.ReadLine());
                    status = Console.ReadLine();
                    if (status == "success")
                    {
                        if (nakovScore + points < 500)
                        {
                            nakovScore += points;
                        }
                        else if (nakovScore + points == 500)
                        {
                            Console.WriteLine("Nakov");
                            Console.WriteLine(count);
                            Console.WriteLine(simeonScore);
                            return;
                        }
                    }
                }
                if (player == "Nakov" )
                {
                    points = int.Parse(Console.ReadLine());
                    status = Console.ReadLine();
                    if (nakovScore + points < 500 && status == "success")
                    {
                        nakovScore += points;
                    }
                    else if (nakovScore + points == 500 && status == "success")
                    {
                        Console.WriteLine("Nakov");
                        Console.WriteLine(count);
                        Console.WriteLine(simeonScore);
                        return;
                    }
                    points = int.Parse(Console.ReadLine());
                    status = Console.ReadLine();
                    if (status == "success")
                    {
                        if (simeonScore + points < 500)
                        {
                            simeonScore += points;
                        }
                        else if(simeonScore + points == 500)
                        {
                            Console.WriteLine("Simeon");
                            Console.WriteLine(count);
                            Console.WriteLine(nakovScore);
                            return;
                        }
                    }
                }
                if (player == "Nakov")
                {
                    player = "Simeon";
                }
                else
                {
                    player = "Nakov";
                }
            }
            if (nakovScore == simeonScore)
            {
                Console.WriteLine("DRAW");
                Console.WriteLine(simeonScore);
            }
            else
            {
                if (nakovScore > simeonScore)
                {
                    Console.WriteLine("Nakov");
                    Console.WriteLine(nakovScore - simeonScore);
                }
                else
                {
                    Console.WriteLine("Simeon");
                    Console.WriteLine(simeonScore - nakovScore);
                }
            }
        }
    }
}