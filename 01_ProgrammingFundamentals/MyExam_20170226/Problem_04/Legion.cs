using System.Collections.Generic;

namespace Problem_04
{
    public class Legion
    {
        public string Name { get; set; }
        public long LastActivity { get; set; }
        public Dictionary<string, long> Soldiers { get; set; }
    }
}