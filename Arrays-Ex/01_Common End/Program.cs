using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01_Common_End
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] arr1 = Console.ReadLine().Split();
            string[] arr2 = Console.ReadLine().Split();
            int arr1Length = arr1.Length - 1;
            int arr2Length = arr2.Length - 1;
            bool isSame = false;

            int countFromStart = 0;
            for (int i = 0; i <= Math.Min(arr1Length, arr2Length); i++)
            {
                if (arr1[i] == arr2[i])
                {
                    isSame = true;
                    countFromStart++;
                    continue;
                }
                if (isSame && arr1[i] != arr2[i])
                {
                    break;
                }
            }

            isSame = false;
            int countFromEnd = 0;
            while (arr1Length >= 0)
            {
                if (arr1Length < 0 || arr2Length < 0)
                {
                    break;
                }
                if (arr1[arr1Length] == arr2[arr2Length])
                {
                    isSame = true;
                    countFromEnd++;
                }
                if (isSame==true && arr1[arr1Length] != arr2[arr2Length])
                {
                    break;
                }
                arr1Length--;
                arr2Length--;
            }

            Console.WriteLine(Math.Max(countFromStart, countFromEnd));
        }
    }
}