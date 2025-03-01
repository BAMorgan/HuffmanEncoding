public class HuffmanNode implements Comparable<HuffmanNode>{

    private final char character;
    private final int frequency;
    private final HuffmanNode leftChild;
    private final HuffmanNode rightChild;


    public HuffmanNode(char character, int frequency, HuffmanNode leftChild, HuffmanNode rightChild) {
        this.character = character;
        this.frequency = frequency;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public HuffmanNode getLeftChild() {
        return leftChild;
    }

    public HuffmanNode getRightChild() {
        return rightChild;
    }

    public HuffmanNode(char a, int frequency) {
        this.character = a;
        this.frequency = frequency;
        this.rightChild = null;
        this.leftChild = null;
    }

    boolean isLeaf(){
        return this.leftChild == null && this.rightChild == null;
    }

    //compares two HuffmanNodes based on frequency
    @Override
    public int compareTo(HuffmanNode compareNode) {
        int frequencyComparison = Integer.compare(this.frequency, compareNode.frequency);

        if (frequencyComparison != 0){
            return  frequencyComparison;
        }

        return Integer.compare(this.character, compareNode.character);
    }

    public char getCharacter() {
        return character;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return "\nHuffmanNode{" +
                "character=" + character +
                ", frequency=" + frequency +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}