using System;
using System.Linq;

namespace _02_Ladybugs
{
    public class LadyBugs
    {
        public static void Main()
        {
            int length = int.Parse(Console.ReadLine());
            int[] bugsIndexes = Console.ReadLine().Split().Select(int.Parse).ToArray();

            int[] bugs = new int[length];
            for (int i = 0; i < bugsIndexes.Length; i++)
            {
                if (bugsIndexes[i] >= 0 && bugsIndexes[i] < length)
                {
                    bugs[bugsIndexes[i]] = 1;
                }
            }

            string[] input = Console.ReadLine().Split().ToArray();
            while (!input[0].Equals("end"))
            {
                int bug = int.Parse(input[0]);
                if (bug < 0 || bug >= length || bugs[bug] == 0)
                {
                    input = Console.ReadLine().Split().ToArray();
                    continue;
                }
                
                int flyLength = int.Parse(input[2]);
                
                if (input[1].Equals("left"))
                {
                    FlyLeft(bugs, bug, flyLength);
                }
                else if (input[1].Equals("right"))
                {
                    FlyRight(bugs, bug, flyLength);
                }

                input = Console.ReadLine().Split().ToArray();
            }

            Console.WriteLine(String.Join(" ", bugs));
        }

        public static void FlyLeft(int[] bugs, int bug, int flyLength)
        {
            if (flyLength < 0)
            {
                FlyRight(bugs, bug, Math.Abs(flyLength));
                return;
            }

            bugs[bug] = 0;
            while ((bug - flyLength) >= 0)
            {
                if (!bugs[bug - flyLength].Equals(1))
                {
                    bugs[bug - flyLength] = 1;
                    return;
                }
                bug -= flyLength;
            }
        }

        public static void FlyRight(int[] bugs, int bug, int flyLength)
        {
            if (flyLength < 0)
            {
                FlyLeft(bugs, bug, Math.Abs(flyLength));
                return;
            }

            bugs[bug] = 0;
            while ((bug + flyLength) < bugs.Length)
            {
                if (!bugs[bug + flyLength].Equals(1))
                {
                    bugs[bug + flyLength] = 1;
                    return;
                }
                bug += flyLength;
            }
        }
    }
}