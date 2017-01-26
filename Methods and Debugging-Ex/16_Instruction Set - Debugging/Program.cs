using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _16_Instruction_Set___Debugging
{
    class Program
    {
        static void Main()
        {
            string opCode = Console.ReadLine();

            while (true)
            {
                if (opCode == "END" || opCode == "end")
                {
                    break;
                }
                string[] codeArgs = opCode.Split(' ').ToArray();

                long result = 0;
                switch (codeArgs[0])
                {
                    case "INC":
                        {
                            long operandOne = long.Parse(codeArgs[1]);
                            result = operandOne + 1;
                            break;
                        }
                    case "DEC":
                        {
                            long operandOne = long.Parse(codeArgs[1]);
                            result = operandOne - 1;
                            break;
                        }
                    case "ADD":
                        {
                            long operandOne = long.Parse(codeArgs[1]);
                            long operandTwo = long.Parse(codeArgs[2]);
                            result = operandOne + operandTwo;
                            break;
                        }
                    case "MLA":
                        {
                            long operandOne = long.Parse(codeArgs[1]);
                            long operandTwo = long.Parse(codeArgs[2]);
                            result = (operandOne * operandTwo);
                            break;
                        }
                }
                opCode = Console.ReadLine();
                Console.WriteLine(result);
            }
        }
    }
}