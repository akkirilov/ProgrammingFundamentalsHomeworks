using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_04___Light_the_Torches
{
    class Program
    {
        static void Main(string[] args)
        {
            //104 min.
            int numberOfRooms = int.Parse(Console.ReadLine());
            string stateOfRoom = Console.ReadLine();
            int s = 0;
            int positionB = numberOfRooms / 2;
            int positionA = numberOfRooms / 2;

            string direction = "";
            int steps = 0;

            char[] rooms = new char[numberOfRooms];
            for (int i = 0; i < rooms.Length; i++)
            {
                if (s>=stateOfRoom.Length)
                {
                    s = 0;
                }
                rooms[i] = stateOfRoom[s];
                s++;
            }
            
            string command = Console.ReadLine();

            while (command != "END")
            {
                string[] commandEll = command.Split(' ');
                direction = commandEll[0];
                steps = int.Parse(commandEll[1]) + 1;

                if (direction == "LEFT")
                {
                    positionA = positionB - steps;
                    if (positionA<0)
                    {
                        positionA = 0;
                    }
                    if (rooms[positionA] == 'L' && positionA != positionB)
                    {
                        rooms[positionA] = 'D';
                    }
                    else if (rooms[positionA] == 'D' && positionA != positionB)
                    {
                        rooms[positionA] = 'L';
                    }
                }
                else if (direction == "RIGHT")
                {
                    positionA = positionB + steps;
                    if (positionA > rooms.Length-1)
                    {
                        positionA = rooms.Length - 1;
                    }
                    if (rooms[positionA] == 'L' && positionA != positionB)
                    {
                        rooms[positionA] = 'D';
                    }
                    else if (rooms[positionA] == 'D' && positionA != positionB)
                    {
                        rooms[positionA] = 'L';
                    }
                }

                positionB = positionA;
                command = Console.ReadLine();
            }

            int count = 0;
            for (int i = 0; i < rooms.Length; i++)
            {
                if (rooms[i] == 'D')
                {
                    count++;
                }
            }

            Console.WriteLine(count * (int)'D');
        }
    }
}