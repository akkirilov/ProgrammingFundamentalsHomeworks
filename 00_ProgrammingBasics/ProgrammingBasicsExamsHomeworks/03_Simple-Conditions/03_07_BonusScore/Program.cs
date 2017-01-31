using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_07_BonusScore
{
    class Program
    {
        static void Main(string[] args)
        {
            int score = int.Parse(Console.ReadLine());
            int scoreEven = 0;
            int score5 = 0;
            double countScore = 0;
            
            if (score <= 100)
            {
                countScore += 5;
            }
            else if (score > 1000)
            {
                countScore = score * 0.10;
            }
            else if (score > 100)
            {
                countScore = score * 0.20;
            }
                        
            if (score%2 ==0)
            {
                scoreEven += 1;
            }

            if (score%10 == 5)
            {
                score5 += 2;
            }

            Console.WriteLine(countScore + scoreEven + score5);
            Console.WriteLine(score + countScore + scoreEven + score5);

        }
    }
}
