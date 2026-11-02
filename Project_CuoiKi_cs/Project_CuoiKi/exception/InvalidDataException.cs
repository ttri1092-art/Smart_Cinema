using System;

namespace exception
{
    public class InvalidDataException : Exception
    {
        public InvalidDataException(string message) : base(message) { }
    }
}