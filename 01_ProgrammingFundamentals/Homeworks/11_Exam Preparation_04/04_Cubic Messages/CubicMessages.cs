using System;
using System.Text;
using System.Text.RegularExpressions;

namespace _04_Cubic_Messages
{
    public class CubicMessages
    {
        public static void Main()
        {
            while (true)
            {
                string line = Console.ReadLine();
                if (line.Equals("Over!"))
                {
                    break;
                }

                int count = int.Parse(Console.ReadLine());

                string pattern = @"^([0-9]+)([a-zA-z]{" + count + @"})([^a-zA-Z]*)$";

                StringBuilder decrypted = new StringBuilder();

                Match isMatch = Regex.Match(line, pattern);
                if (Regex.IsMatch(line, pattern))
                {
                    string massage = isMatch.Groups[2].ToString();
                    decrypted.Append(massage + " == ");

                    GetVerificationCode(massage, isMatch.Groups[1].ToString().ToCharArray(), decrypted);
                    GetVerificationCode(massage, isMatch.Groups[3].ToString().ToCharArray(), decrypted);

                    Console.WriteLine(decrypted.ToString());
                }
            }
        }

        private static void GetVerificationCode(string massage, char[] digits, StringBuilder decrypted)
        {
            for (int i = 0; i < digits.Length; i++)
            {
                int index = (int)(digits[i] - '0');
                if (index < massage.Length && index >= 0)
                {
                    decrypted.Append(massage[(int)(digits[i] - '0')]);
                }
                else
                {
                    decrypted.Append(" ");
                }
            }
        }
    }
}