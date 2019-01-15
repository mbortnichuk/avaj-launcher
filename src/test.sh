#!/usr/bin/bash

RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m' # Reset color

for file in ./test_scenarios/*.txt
do
	if java mbortnic.Simulator.Simulator $file | grep -q "Error"; then
		echo "${GREEN}mbortnic.Simulator.Simulator " $file
		echo "OK!${NC}\n"
	else
		echo "${RED}mbortnic.Simulator.Simulator " $file
		echo "WRONG!${NC} Press any key to continue"
		read _
	fi
done