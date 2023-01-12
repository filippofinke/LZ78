# LZ78

_LZ78 Encoding and Decoding_

Encodes a user-specified file using LZ78 encoding. Outputs the encoded data to standard out. Uses output from standard out as input for decoding. Outputs the decoded data to standard out.

# Usage

```
cat 'filename.txt' | java LZencode | java LZdecode
```

# Input format

## Decode example

```
0 c
0 a
2 c
3 c
2 a
2 d
```
