# Huffman Encoding Implementation in Java

## Overview
This project implements **Huffman Encoding**, a lossless data compression algorithm that assigns variable-length codes to input characters based on their frequencies. It includes:
- **Encoding**: Compressing a string using Huffman coding.
- **Decoding**: Expanding a Huffman-encoded string back to its original form.
- **Compression Analysis**: Generating a frequency table and calculating compression ratios.

## Features
- Uses a **Priority Queue and Binary Tree** to build Huffman codes.
- Supports **encoding, decoding, and compression ratio calculation**.
- Reads input from `input.txt` and writes results to `output.txt`.
- Displays a **character frequency table** for better understanding.

## Files in this Repository
- **`Driver.java`** - Main entry point, handles file I/O and calls encoding/decoding methods.
- **`ArrayHeap.java`** - Implements a min-heap structure for priority queue operations.
- **`PriorityQueue.java`** - Custom priority queue for handling Huffman Nodes.
- **`HuffmanNode.java`** - Defines a node in the Huffman tree.
- **`HuffmanTree.java`** - Builds the Huffman tree and generates encoding mappings.
- **`input.txt`** - Example input for encoding/decoding tests.
- **`output.txt`** - Output file with encoded and decoded results.
- **`readme.txt`** - Notes on complexity, advantages, and reflections on the implementation.

## How to Run
1. **Compile the Java Files**  
   ```sh
   javac Driver.java ArrayHeap.java PriorityQueue.java HuffmanNode.java HuffmanTree.java
   ```
2. **Run the Program**  
   ```sh
   java Driver
   ```
3. The program will read `input.txt`, process encoding/decoding, and store results in `output.txt`.

## Time Complexity
- **Encoding:** O(n log n) (due to heap operations in priority queue)
- **Decoding:** O(n) (traversing the encoded string)
- **Building the Tree:** O(n log n)

## Advantages & Limitations
✅ **Advantages:**
- Highly efficient for text compression, reducing data size significantly.
- Variable-length encoding optimizes space usage.

⚠️ **Limitations:**
- Requires extra storage for the Huffman tree.
- The encoded output is **not fixed-length**, making random access difficult.

## Example

### Encoding
**Input:** `"Eerie eyes seen near lake"`  
**Frequency Table:**  
```
char    frequency    code
--------------------------------
E       1            11010
e       8            10
r       2            1100
y       1            0110
...
```
**Encoded Output:** `"110101011000111110111100110100001110..."`  
**Compression Ratio:** `2.56`

### Decoding
**Encoded Input:** `"110101011000111110111100110100001110..."`  
**Decoded Output:** `"Eerie eyes seen near lake"`
