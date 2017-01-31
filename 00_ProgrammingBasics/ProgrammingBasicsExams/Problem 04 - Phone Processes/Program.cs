using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_04___Phone_Processes
{
    class Program
    {
        static void Main(string[] args)
        {
            //09:10
            //14:23 - 40 min.
            string battery = Console.ReadLine();
            string [] batteryEll = battery.Split('%');
            int powerStart = int.Parse(batteryEll [0]);
            string command = Console.ReadLine().ToUpper();
            if (powerStart == 0)
            {
                Console.WriteLine("Phone Off");
                return;
            }
            bool over15 = true;
            int currentPower = powerStart;
            int unPrucessed = -1;

            while (command != "END")
            {
                int curDraw = int.Parse(command[command.Length - 3].ToString() + command[command.Length - 2].ToString());
                if (over15)
                {
                    currentPower -= curDraw;
                }
                if (curDraw >= powerStart && over15)
                {
                    Console.WriteLine("Phone Off");
                    return;
                }
                if (powerStart < 15 && over15)
                {
                    currentPower += curDraw;
                    unPrucessed = 1;
                    break;
                }
                else if (currentPower <= 15 && currentPower > 0)
                {
                    unPrucessed++;
                    over15 = false;
                }
                else if (currentPower <= 0)
                {
                    currentPower += curDraw;
                }

                powerStart = currentPower;
                command = Console.ReadLine().ToUpper();
            }
            if ((currentPower <= 15) && currentPower > 0)
            {
                Console.WriteLine("Connect charger -> {0}%", currentPower);
                Console.WriteLine("Programs left -> {0}", unPrucessed);
            }
            else if (currentPower > 15)
            {
                Console.WriteLine("Successful complete -> {0}%", currentPower);
            }
        }
    }
}