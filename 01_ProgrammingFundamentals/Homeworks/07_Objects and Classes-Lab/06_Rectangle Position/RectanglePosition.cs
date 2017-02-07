using System;
using System.Collections.Generic;
using System.Linq;

namespace _06_Rectangle_Position
{
    class RectanglePosition
    {
        static void Main()
        {
            double[] input = Console.ReadLine().Split().Select(double.Parse).ToArray();
            Rectangle firstrectangle = new Rectangle { left = input[0], top = input[1], width = input[2], height = input[3] };

            input = Console.ReadLine().Split().Select(double.Parse).ToArray();
            Rectangle secondrectangle = new Rectangle { left = input[0], top = input[1], width = input[2], height = input[3] };

            IsFirstInsideSecondRectangle(firstrectangle, secondrectangle);
        }

        private static void IsFirstInsideSecondRectangle(Rectangle firstrectangle, Rectangle secondrectangle)
        {
            if (firstrectangle.top <= secondrectangle.top 
                && firstrectangle.left >= secondrectangle.left 
                && secondrectangle.bottom <= firstrectangle.bottom 
                && secondrectangle.right >= firstrectangle.right )
            {
                Console.WriteLine("Inside");
                return;
            }
            Console.WriteLine("Not inside");
        }
    }
}