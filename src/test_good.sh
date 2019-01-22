#!/usr/bin/bash

RED='\033[1;31m'
GR='\033[0;032m'
REC='\033[0m' # Reset color

for file in ./good_test_scenarios/*.txt
do
    if java mbortnic.Simulator.Simulator $file && [ -e simulation.txt ]; then
        echo "${GR}mbortnic.Simulator.Simulator " $file
	    echo "OK!${RC}\n"
        rm -rf simulation.txt
    else
        echo "${RED}mbortnic.Simulator.Simulator " $file
        echo "WRONG!${RC} Press any key to continue"
        read _
    fi
done