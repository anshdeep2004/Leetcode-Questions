# Read from the file file.txt and print its transposed content to stdout.
awk '{
  for (i = 1; i <= NF; i++) {
    # build each transposed row by appending the i-th field
    row[i] = row[i] ? row[i] OFS $i : $i
  }
}
END {
  # print out each accumulated row
  for (i = 1; i <= NF; i++) {
    print row[i]
  }
}' file.txt