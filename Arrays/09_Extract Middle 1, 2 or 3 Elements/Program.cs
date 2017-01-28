using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09_Extract_Middle_1__2_or_3_Elements
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine().Split().Select(int.Parse).ToArray();

            if (nums.Length == 1)
            {
                Console.WriteLine("{ " + nums[0] + " }");
                return;
            }
            
            switch (nums.Length % 2)
            {
                case 1:
                    Console.WriteLine("{ " + nums[nums.Length / 2 - 1] + ", " 
                        + nums[nums.Length / 2] + ", " + nums[nums.Length / 2 + 1] + " }");
                    break;
                case 0:
                    Console.WriteLine("{ " + nums[nums.Length / 2 - 1] 
                        + ", " + nums[nums.Length / 2] + " }");
                    break;
            }

            if (nums.Length == 1)
            {
                Console.WriteLine("{ " + nums[0] + " }");
            }
        }
    }
}