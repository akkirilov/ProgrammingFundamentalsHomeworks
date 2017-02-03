using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_Hands_of_Cards
{
    class Program
    {
        public static Dictionary<string, string> playersPoints = new Dictionary<string, string>();

        static void Main(string[] args)
        {
            Dictionary<string, string> playersCards = new Dictionary<string, string>();

            string input = Console.ReadLine();

            while (input != "JOKER")
            {
                List<string> inputEll = input.Split(':').ToList();

                if (playersCards.ContainsKey(inputEll[0]))
                {
                    playersCards[inputEll[0]] += inputEll[1];
                }
                else
                {
                    playersCards[inputEll[0]] = inputEll[1];
                }

                input = Console.ReadLine();
            }

            foreach (var plaeyr in playersCards)
            {
                int points = CountPoints((plaeyr.Value));
                Console.WriteLine($"{plaeyr.Key}: {points}");
            }
        }

        private static int CountPoints(string playerValue)
        {
            List<string> cards = playerValue.Split(new char[] { ' ', ',' }, StringSplitOptions.RemoveEmptyEntries).Distinct().ToList();
            int points = 0;

            for (int i = 0; i < cards.Count; i++)
            {
                points += CountCardPoints(cards[i]);
            }
            return points;
        }

        private static int CountCardPoints(string card)
        {
            int power = 0;
            for (int i = 2; i < 10; i++)
            {
                if ((int)(card[0] - '0') == i)
                {
                    power = i;
                }
            }
            switch (card[0])
            {
                case '1':
                    power = 10;
                    break;
                case 'J':
                    power = 11;
                    break;
                case 'Q':
                    power = 12;
                    break;
                case 'K':
                    power = 13;
                    break;
                case 'A':
                    power = 14;
                    break;
            }

            int type = 0;
            switch (card[card.Length - 1])
            {
                case 'C':
                    type = 1;
                    break;
                case 'D':
                    type = 2;
                    break;
                case 'H':
                    type = 3;
                    break;
                case 'S':
                    type = 4;
                    break;
            }

            return (power * type);
        }
    }
}