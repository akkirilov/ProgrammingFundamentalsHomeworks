using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_Rectangle_Position
{
    public class Rectangle
    {
        public double left { get; set; }
        public double top { get; set; }
        public double width { get; set; }
        public double height { get; set; }

        public double bottom => top - height;
        public double right => bottom + width;
    }
}