using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace NumbersWrite
{
    class Simple
    {
        public Simple(string path, int num1, int num2)
        {
            // This line creats a file called myFile for the program and
            // called TestFile.dat in the disk. The false value will force
            // the file to rewrite over any existing data. A true value will
            // append data to the end of the file or create the file if it does
            // not exist.
            // StreamWriter opens a file for output from the program.
            StreamWriter myFileOut = new StreamWriter(Path.Combine(path, "Test Data.dat"), false);

            // Write data to a file.
            // .Write() command sends data to the file without the newline command.

            // .WriteLine() command sends data to the file with the newline command.
            myFileOut.WriteLine(num1);
            myFileOut.WriteLine(num2);

            myFileOut.Close();
        }
    }
}

