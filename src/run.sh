#!/usr/bin/env bash

rm -rf simulation.txt
printf "\033[33msimulation.txt file deleted.\n\n\033[0m"

# sleep 1
# printf "\033[32m.\n\033[0m"
# sleep 1
# printf "\033[32m. .\n\033[0m"
# sleep 1
# printf "\033[32m. . .\n\n\033[0m"
# sleep 1

find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java mbortnic.Simulator.Simulator test_scenarios/Baloon1.txt

if [ -e simulation.txt ]
then 
    printf "\033[1;32msimulation.txt file created.\n\033[0m"
else
    printf "\n\033[1;31mError: Could not create simulation.txt file\n\033[0m"
fi

# find . -name "*.class" -delete
