import java.io.*;
import java.util.Map;

public class Driver {
    public static void main(String[] args) {
        run();
    }

    static void run(){
        BufferedReader reader;
        FileWriter writer;

        var fileName = "CS342/input.txt";

        try{
            reader = new BufferedReader(new FileReader(fileName));
            writer = new FileWriter("CS342/output.txt");

            //string for reading lines
            String line = reader.readLine();
            //Map for char codes; Keys = characters, Values = huffman codes
            Map<Character, String> charCodeMap;

            while(line != null){
                //string to be encoded
                String stringToEncode = line;

                //char array where the ASCII value is the index
                int[] charFreqArray = buildCharArray(stringToEncode);

                //build HuffmanTree in order to be able to access char map to write frequency table
                HuffmanNode rootOfTree = HuffmanTree.buildHuffmanTree(charFreqArray);

                //map of characters and huffman codes; Keys = Characters, Values = Codes
                //needed for writing the frequency table
                charCodeMap = HuffmanTree.buildFreqMap(rootOfTree);

                //encoded string
                String encodedString = HuffmanTree.encode(charFreqArray, stringToEncode);

                //decoded string
                String decodedString = HuffmanTree.decode(encodedString,rootOfTree);

                //compression ratio
                float compressionRatio = (float) decodedString.length() * 8L / (float) encodedString.length();

                writer.write("["+ stringToEncode + "]\n");
                writer.write("""
                        ================================
                        char    frequency    code
                        --------------------------------
                        """);

                //for loop which writes char from index of int array; ASCII char = index of array
                for (char i = 0; i < 256; i++){
                    if (charFreqArray[i] == 0){
                        //nothing
                    }else{
                        //casting int i to corresponding ASCII character
                        writer.write(i + "       ");
                        writer.write(charFreqArray[i] + "            ");
                        writer.write(charCodeMap.get(i) + "\n");
                    }
                }

                //encoded bits = exact length of string after encoding
                writer.write("================================\n" +
                        "[Encoded Bit: " + encodedString + "] [" + encodedString.length() + "]\n");

                //decoded bits = string to encode * 8 (8 bits/character)
                writer.write("[Decoded String: " + decodedString + "] [" + stringToEncode.length()*8 + "]\n");

                //compression ratio = decoded bits / encoded bits
                writer.write("[Compression Ratio: " + compressionRatio + "]");
                writer.write("\n \n");

                line = reader.readLine();

            }

            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int[] buildCharArray(String theString){
        //256 for extended ASCII
        int[] frequency = new int[256];

        for(char character : theString.toCharArray()){
            frequency[character]++;
        }
        return frequency;
    }





}
