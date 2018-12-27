#!/usr/bin/env bash
rm -rf simulation.txt
printf "\033[33msimulation.txt file deleted.\n\n\033[0m"

sleep 1
printf "\033[32m.\n\033[0m"
sleep 1
printf "\033[32m. .\n\033[0m"
sleep 1
printf "\033[32m. . .\n\n\033[0m"
sleep 1

find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java mbortnic.Simulator.Simulator scenario.txt
printf "\033[32msimulation.txt file created.\n\033[0m"
