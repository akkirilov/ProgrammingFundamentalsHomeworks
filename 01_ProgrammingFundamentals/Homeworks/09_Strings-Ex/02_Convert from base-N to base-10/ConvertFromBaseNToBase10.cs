using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace _02_Convert_from_base_N_to_base_10
{
    public class ConvertFromBaseNToBase10
    {
        public static void Main()
        {
            string[] parameters = Console.ReadLine()
                .Split()
                .ToArray();

            int toBase = int.Parse(parameters[0]);
            List<int> number = parameters[1].Select(x => (int)(x - '0')).ToList();

            BigInteger result = number[number.Count - 1] + (number[number.Count - 2] * toBase);
            int index = 0;
            int pow = number.Count - 1;

            while (pow > 1)
            {
                result +=  number[index] * PowerNumber(toBase, pow);

                index++;
                pow--;
            }

            Console.WriteLine(result);
        }

        public static BigInteger PowerNumber(int toBase, int pow)
        {
            BigInteger poweredNumber = toBase;
            for (int i = 1; i < pow; i++)
            {
                poweredNumber *= toBase;
            }

            return poweredNumber;
        }
    }
}