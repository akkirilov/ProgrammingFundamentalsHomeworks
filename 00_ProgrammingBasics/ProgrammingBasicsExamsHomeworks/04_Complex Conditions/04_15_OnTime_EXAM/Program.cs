using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_15_OnTime_EXAM
{
    class Program
    {
        static void Main(string[] args)
        {
            int hE = int.Parse(Console.ReadLine());
            int mE = int.Parse(Console.ReadLine());
            int hP = int.Parse(Console.ReadLine());
            int mP = int.Parse(Console.ReadLine());

            int e = (hE * 60) + mE;
            int p = (hP * 60) + mP;

            if (e>=p) 
            {
                if (e == p)
                {
                    Console.WriteLine("On time");
                }
                else if ((e - p) <= 30) 
                {
                    Console.WriteLine("On time");
                    Console.WriteLine("{0} minutes before the start", e - p);
                }
                else if (((e - p) > 30)&& ((e - p) < 60))
                {
                    
                    Console.WriteLine("Early");
                    Console.WriteLine("{0} minutes before the start", e-p);
                }
                else if ((e - p) >= 60)
                {
                    int lH = (e - p) / 60;
                    int lM = (e - p) % 60;
                    Console.WriteLine("Early");
                    Console.WriteLine("{0}:{1:00} hours before the start", lH, lM);
                }   
            }
            
            else if (p > e)
            {
                if ((p - e) < 60) 
                {
                    Console.WriteLine("Late");
                    Console.WriteLine("{0} minutes after the start", p - e);
                }
                else if ((p - e) >= 60)
                {
                    int lH = (p - e) / 60;
                    int lM = (p - e) % 60;
                    Console.WriteLine("Late");
                    Console.WriteLine("{0}:{1:00} hours after the start", lH, lM);
                }
            }
        }
    }
}
