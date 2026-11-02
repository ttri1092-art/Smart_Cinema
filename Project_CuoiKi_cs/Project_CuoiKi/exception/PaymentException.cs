using System;

namespace exception
{
    public class PaymentException : Exception
    {
        public PaymentException(string message) : base(message) { }
    }
}