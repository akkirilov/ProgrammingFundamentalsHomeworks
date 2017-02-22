using System.Collections.Generic;
using System.Numerics;

namespace _20150619_Population_Counter
{
    public class Country
    {
        public string Name { get; set; }
        public Dictionary<string, int> Cities { get; set; }

        public BigInteger Population { get; set; }
    }
}
