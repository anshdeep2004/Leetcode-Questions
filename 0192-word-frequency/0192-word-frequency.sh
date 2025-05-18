# Read from the file words.txt and output the word frequency list to stdout.
awk '{for(i=1;i<=NF;i++) count[$i]++} END {for(word in count) print word, count[word]}' words.txt | sort -k2,2nr