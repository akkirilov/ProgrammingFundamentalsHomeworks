using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_02___Take_the_plane_down
{
    class Program
    {
        static void Main(string[] args)
        {

            int centerX = int.Parse(Console.ReadLine());
            int centerY = int.Parse(Console.ReadLine());
            int countryRadius = int.Parse(Console.ReadLine());

            int detectedPlanes = int.Parse(Console.ReadLine());

            double countryArea = Math.PI * countryRadius * countryRadius;

            for (int i = 1; i <= detectedPlanes; i++)
            {
                int planeX = int.Parse(Console.ReadLine());
                int planeY = int.Parse(Console.ReadLine());

                int planeDistanceX = planeX - centerX;
                int planeDistanceY = planeY - centerY;

                if ((Math.Abs(planeDistanceX)<Math.Abs(countryRadius))&& (Math.Abs(planeDistanceY) < Math.Abs(countryRadius)))
                {
                    Console.WriteLine("You destroyed a plane at [{0},{1}]", planeX, planeY);
                }
            }


        }
    }
}
