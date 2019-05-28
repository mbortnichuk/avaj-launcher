# avaj-launcher
This project is the introduction to the Java world at 42. This is an implementation of an aircraft simulation program based on the class UML diagram.

## Description
Aim of this project is to implement an aircraft simulation program based on the UML class diagram. All classes are required to be implemented respecting every detail provided in the diagram.
If necessary, add more classes or include additional attributes, but changing access modifiers and class hireharchy for the classes provided in the diagram are forbidden.

## UML Diagram
![foo](https://github.com/mbortnichuk/avaj-launcher/blob/master/src/pictures/avaj_uml.jpg "diagram")

## Compile and run
```
git clone https://github.com/mbortnichuk/avaj-launcher.git
cd avaj-launcher/src/
````
Before launching make sure that `java` and `javac` commands are available in your terminal.
In the root of project folder run the commands given bellow:
```
find -name *.java > sources.txt
javac -sourcepath @sources.txt
java mbortnic.Simulator.Simulator scenario.txt
````
Or you can use run.sh in the root of project folder. To launch use:
```
sh run.sh
```

## Scenario file example
The first line of the file contains a positive integer number. This number represents the number of times the simulation is run. In our case, this will be the number of times a weather change is triggered.
Each following line describes an aircraft that will be part of the simulation, with this format: TYPE NAME LONGITUDE LATITUDE HEIGHT.
```
25
Baloon B1 2 3 20
Baloon B2 1 8 66
JetPlane J1 23 44 32
Helicopter H1 654 33 20
Helicopter H2 22 33 44
Helicopter H3 98 68 99
Baloon B3 102 22 34
JetPlane J2 11 99 768
Helicopter H4 223 23 54
```

## Example of output
```
cat simulation.txt
```
```
Tower says: Baloon#B1(1) registered to weather tower.
Tower says: Baloon#B2(2) registered to weather tower.
Tower says: JetPlane#J1(3) registered to weather tower.
Tower says: Helicopter#H1(4) registered to weather tower.
Tower says: Helicopter#H2(5) registered to weather tower.
Tower says: Helicopter#H3(6) registered to weather tower.
Tower says: Baloon#B3(7) registered to weather tower.
Tower says: JetPlane#J2(8) registered to weather tower.
Tower says: Helicopter#H4(9) registered to weather tower.

Simulation: 1
Baloon#B1(1): There is some sun, let's enjoy good weather!
Baloon#B2(2): There is some sun, let's enjoy good weather!
JetPlane#J1(3): Gamn fog!
Helicopter#H1(4): Winter is coming!
Helicopter#H2(5): I see no ground!
Helicopter#H3(6): It's so hot!
Baloon#B3(7): It's rain! It messed up my baloon!
JetPlane#J2(8): This sun is getting to my eyes!
Helicopter#H4(9): It's so hot!

Simulation: 2
Baloon#B1(1): I hate fog, I cannot see anything at all!
Baloon#B2(2): I hate fog, I cannot see anything at all!
JetPlane#J1(3): This sun is getting to my eyes!
Helicopter#H1(4): This rain is so depressing...
Helicopter#H2(5): Winter is coming!
Helicopter#H3(6): I see no ground!
Baloon#B3(7): It's rain! It messed up my baloon!
JetPlane#J2(8): This sun is getting to my eyes!
Helicopter#H4(9): This rain is so depressing...

Simulation: 3
Baloon#B1(1): It's snowing! We should be more careful!
Baloon#B2(2): It's snowing! We should be more careful!
JetPlane#J1(3): Watch out for lightnings!
Helicopter#H1(4): It's so hot!
Helicopter#H2(5): I see no ground!
Helicopter#H3(6): It's so hot!
Baloon#B3(7): There is some sun, let's enjoy good weather!
JetPlane#J2(8): We are going to freeze!
Helicopter#H4(9): This rain is so depressing...

Simulation: 4
Baloon#B1(1): It's rain! It messed up my baloon!
Baloon#B2(2): It's snowing! We should be more careful!
JetPlane#J1(3): Watch out for lightnings!
Helicopter#H1(4): I see no ground!
Helicopter#H2(5): It's so hot!
Helicopter#H3(6): This rain is so depressing...
Baloon#B3(7): It's snowing! We should be more careful!
JetPlane#J2(8): Watch out for lightnings!
Helicopter#H4(9): This rain is so depressing...

Simulation: 5
Baloon#B1(1): There is some sun, let's enjoy good weather!
Baloon#B2(2): It's rain! It messed up my baloon!
JetPlane#J1(3): This sun is getting to my eyes!
Helicopter#H1(4): Winter is coming!
Tower says: Helicopter#H1(4) unregistered from weather tower.
Helicopter#H2(5): It's so hot!
Helicopter#H3(6): This rain is so depressing...
Baloon#B3(7): I hate fog, I cannot see anything at all!
JetPlane#J2(8): We are going to freeze!
Helicopter#H4(9): This rain is so depressing...

Simulation: 6
Baloon#B1(1): There is some sun, let's enjoy good weather!
Baloon#B2(2): I hate fog, I cannot see anything at all!
JetPlane#J1(3): This sun is getting to my eyes!
Helicopter#H2(5): This rain is so depressing...
Helicopter#H3(6): It's so hot!
Baloon#B3(7): There is some sun, let's enjoy good weather!
JetPlane#J2(8): Watch out for lightnings!
Helicopter#H4(9): Winter is coming!

Simulation: 7
Baloon#B1(1): It's rain! It messed up my baloon!
Baloon#B2(2): There is some sun, let's enjoy good weather!
JetPlane#J1(3): We are going to freeze!
Helicopter#H2(5): It's so hot!
Helicopter#H3(6): I see no ground!
Baloon#B3(7): I hate fog, I cannot see anything at all!
JetPlane#J2(8): This sun is getting to my eyes!
Helicopter#H4(9): Winter is coming!

Simulation: 8
Baloon#B1(1): There is some sun, let's enjoy good weather!
Baloon#B2(2): There is some sun, let's enjoy good weather!
JetPlane#J1(3): We are going to freeze!
Helicopter#H2(5): Winter is coming!
Helicopter#H3(6): Winter is coming!
Baloon#B3(7): I hate fog, I cannot see anything at all!
JetPlane#J2(8): We are going to freeze!
Helicopter#H4(9): This rain is so depressing...

Simulation: 9
Baloon#B1(1): I hate fog, I cannot see anything at all!
Baloon#B2(2): It's rain! It messed up my baloon!
JetPlane#J1(3): Watch out for lightnings!
Helicopter#H2(5): It's so hot!
Helicopter#H3(6): I see no ground!
Baloon#B3(7): It's snowing! We should be more careful!
Tower says: Baloon#B3(7) unregistered from weather tower.
JetPlane#J2(8): This sun is getting to my eyes!
Helicopter#H4(9): This rain is so depressing...

Simulation: 10
Baloon#B1(1): It's rain! It messed up my baloon!
Tower says: Baloon#B1(1) unregistered from weather tower.
Baloon#B2(2): It's rain! It messed up my baloon!
JetPlane#J1(3): We are going to freeze!
Helicopter#H2(5): I see no ground!
Helicopter#H3(6): I see no ground!
JetPlane#J2(8): This sun is getting to my eyes!
Helicopter#H4(9): Winter is coming!

Simulation: 11
Baloon#B2(2): There is some sun, let's enjoy good weather!
JetPlane#J1(3): Gamn fog!
Helicopter#H2(5): Winter is coming!
Helicopter#H3(6): Winter is coming!
JetPlane#J2(8): This sun is getting to my eyes!
Helicopter#H4(9): I see no ground!

Simulation: 12
Baloon#B2(2): There is some sun, let's enjoy good weather!
JetPlane#J1(3): We are going to freeze!
Helicopter#H2(5): It's so hot!
Helicopter#H3(6): It's so hot!
JetPlane#J2(8): This sun is getting to my eyes!
Helicopter#H4(9): It's so hot!

Simulation: 13
Baloon#B2(2): I hate fog, I cannot see anything at all!
JetPlane#J1(3): This sun is getting to my eyes!
Helicopter#H2(5): It's so hot!
Helicopter#H3(6): Winter is coming!
JetPlane#J2(8): This sun is getting to my eyes!
Helicopter#H4(9): Winter is coming!

Simulation: 14
Baloon#B2(2): There is some sun, let's enjoy good weather!
JetPlane#J1(3): Gamn fog!
Helicopter#H2(5): Winter is coming!
Tower says: Helicopter#H2(5) unregistered from weather tower.
Helicopter#H3(6): Winter is coming!
JetPlane#J2(8): We are going to freeze!
Helicopter#H4(9): Winter is coming!
Tower says: Helicopter#H4(9) unregistered from weather tower.

Simulation: 15
Baloon#B2(2): There is some sun, let's enjoy good weather!
JetPlane#J1(3): This sun is getting to my eyes!
Helicopter#H3(6): It's so hot!
JetPlane#J2(8): This sun is getting to my eyes!

Simulation: 16
Baloon#B2(2): It's snowing! We should be more careful!
JetPlane#J1(3): We are going to freeze!
Helicopter#H3(6): This rain is so depressing...
JetPlane#J2(8): Gamn fog!

Simulation: 17
Baloon#B2(2): There is some sun, let's enjoy good weather!
JetPlane#J1(3): We are going to freeze!
Tower says: JetPlane#J1(3) unregistered from weather tower.
Helicopter#H3(6): It's so hot!
JetPlane#J2(8): Gamn fog!

Simulation: 18
Baloon#B2(2): It's rain! It messed up my baloon!
Helicopter#H3(6): I see no ground!
JetPlane#J2(8): We are going to freeze!

Simulation: 19
Baloon#B2(2): I hate fog, I cannot see anything at all!
Helicopter#H3(6): This rain is so depressing...
JetPlane#J2(8): We are going to freeze!

Simulation: 20
Baloon#B2(2): It's snowing! We should be more careful!
Helicopter#H3(6): I see no ground!
JetPlane#J2(8): Watch out for lightnings!

Simulation: 21
Baloon#B2(2): I hate fog, I cannot see anything at all!
Helicopter#H3(6): I see no ground!
JetPlane#J2(8): Gamn fog!

Simulation: 22
Baloon#B2(2): I hate fog, I cannot see anything at all!
Tower says: Baloon#B2(2) unregistered from weather tower.
Helicopter#H3(6): I see no ground!
JetPlane#J2(8): This sun is getting to my eyes!

Simulation: 23
Helicopter#H3(6): Winter is coming!
JetPlane#J2(8): Watch out for lightnings!

Simulation: 24
Helicopter#H3(6): It's so hot!
JetPlane#J2(8): This sun is getting to my eyes!

Simulation: 25
Helicopter#H3(6): I see no ground!
JetPlane#J2(8): This sun is getting to my eyes!
```

## Additional tests for good and bad scenarios
To run additional avaj tests run in your terminal in the root of project folder:
- For good tests
```
sh test_good.sh
```
- For bad tests
```
sh test_bad.sh
```

`Good Tests Terminal Output`
![foo](https://github.com/mbortnichuk/avaj-launcher/blob/master/src/pictures/goodTests.png "MainFrame")

`Bad Tests Terminal Output`
![foo](https://github.com/mbortnichuk/avaj-launcher/blob/master/src/pictures/badTests.png "MainFrame")

## Author
- Mariana Bortnichuk - [mbortnic](https://github.com/mbortnichuk "mbortnic")

