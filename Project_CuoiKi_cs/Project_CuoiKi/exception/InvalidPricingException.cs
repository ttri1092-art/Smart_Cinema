using System;

namespace exception
{
    public class InvalidPricingException : Exception
    {
        public InvalidPricingException(string message) : base(message) { }
    }
}