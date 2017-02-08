using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_Andrey_and_billiard
{
    public class Costumer
    {
        public string Name { get; set; }
        public Dictionary<string, int> Orders {get;set;}
        public decimal Bill { get; set; }
    }
}