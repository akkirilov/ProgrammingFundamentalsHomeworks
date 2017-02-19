using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20161023_04_Roli_The_Coder
{
    public class Event
    {
        public string ID { get; set; }
        public string Name { get; set; }
        public SortedSet<string> Participants { get; set; }
    }
}