#!/bin/bash

clear


#for i in {1..46}
#do
#  scriptFile="g$i.txt"
#  javaFile="g$i.java"
#  #echo $scriptFile
#  mv $javaFile solutions
#done

test_case_number=$1

# produce java file from our code
java setTranslator "g$test_case_number.txt" > "g$test_case_number.java"

# compile our code
javac "g$test_case_number.java"

# run our code
echo "Our output:"
java "g$test_case_number"




# run Briggs' code
echo "Briggs' output"
java -cp solutions "g$test_case_number"
