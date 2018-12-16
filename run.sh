find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java mbortnic.Simulator.Simulator scenario.txt
