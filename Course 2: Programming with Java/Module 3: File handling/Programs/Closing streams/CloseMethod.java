try {

                 FileInputStream inFile = null;
        FileOutputStream outFile = null;

            inFile = new FileInputStream("input.txt");
            outFile = new FileOutputStream("output.txt");
            int c;
            while ((c = inFile.read()) != -1) {
                outFile.write(c);
            }
        }
        catch (IOException e) {
            System.out.println(
                    "IOException encountered");
        }
        finally {
            try {
                if (inFile != null)
                    inFile.close();
                if (outFile != null)
                    outFile.close();
            }
            catch (IOException e) {
                System.out.println( "could not close streams");
            } 
        }

