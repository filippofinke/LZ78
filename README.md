# LZ78
*LZ78 Encoding and Decoding*

Encodes a user-specified file using LZ78 encoding. Outputs the encoded data to standard out. Uses output from standard out as input for decoding. Outputs the decoded data to standard out.
# Usage
```
cat 'filename.txt' | java LZencode | java LZdecode
```