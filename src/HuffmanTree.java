import java.util.HashMap;
import java.util.Map;

public class HuffmanTree {


    //takes int array as param where the index of the array is equal to a character's ASCII value
    //O(n)
    static HuffmanNode buildHuffmanTree(int[] freqArray){
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();

        //if index of array contains a non-zero element then add the character
        for (char i = 0; i < 256; i++){
            if (freqArray[i] > 0){
                priorityQueue.add(new HuffmanNode(i, freqArray[i],null,null),freqArray[i]);
            }
        }
        //pops off the top of prio queue and creates nodes which are then assigned as children to new node in prio queue
        while (priorityQueue.getCount() > 1){
            HuffmanNode left = priorityQueue.remove();
            HuffmanNode right = priorityQueue.remove();
            HuffmanNode parent = new HuffmanNode('\0', left.getFrequency() + right.getFrequency(), left,right);
            priorityQueue.add(parent, parent.getFrequency());
        }

        return priorityQueue.remove();
    }
    //helper method for building HashMap of codes :: recursively traverses the tree and builds the corresponding huffman code; left = 0, right = 1
    //O(n) --> visits each node
    static void buildCharTraversalCodes(HuffmanNode theNode, String theString, Map<Character, String> theCharMap){
        if (!theNode.isLeaf()){
            buildCharTraversalCodes(theNode.getLeftChild(), theString + '0', theCharMap);
            buildCharTraversalCodes(theNode.getRightChild(), theString + '1', theCharMap);
        }else {
            theCharMap.put(theNode.getCharacter(), theString);
        }
    }

    //assign codes to map with corresponding keys
    //O(n)
    static Map<Character, String> buildFreqMap(HuffmanNode theRoot){
        final Map<Character, String> map = new HashMap<>();

        buildCharTraversalCodes(theRoot, "", map);

        return map;
    }


    static String encode(int[] theCharArray, String theString ){
        //builds huffman tree
        HuffmanNode root = buildHuffmanTree(theCharArray);
        //builds char map from huffman tree
        Map<Character, String> charCodeMap = buildFreqMap(root);

        String s = "";
        //string to encode as an array
        char[] charArr = theString.toCharArray();

        //loops through the array representation of the string and appends corresponding huffman codes
        for (char c : charArr) {
            s += charCodeMap.get(c);
        }
        return s;

    }

    //traverses tree and adds to decodedString
    static String decode(String theEncodedString, HuffmanNode theNode){
        StringBuilder decodedString = new StringBuilder();
        //temp pointer
        HuffmanNode pointer = theNode;

        for(int i = 0; i < theEncodedString.length(); i++){

            //left if 0
            if (theEncodedString.charAt(i) == '0'){
                pointer = pointer.getLeftChild();
            }
            //right if 1
            if(theEncodedString.charAt(i) == '1'){
                pointer = pointer.getRightChild();
            }
            //once we reach a leaf we add to the string
            if(pointer.isLeaf()){
                decodedString.append(pointer.getCharacter());
                pointer = theNode;
            }

        }

        return decodedString.toString();
    }



}
