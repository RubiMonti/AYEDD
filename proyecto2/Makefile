
COMP=javac -cp .:/home/rubimonti/algs4.jar
PROB=java -cp .:/home/rubimonti/algs4.jar
SRC=../src/largeW.txt < ../src/smallT.txt

re: clean all

all: ej2 ej3 interval
	$(COMP) RationalClient.java

clean:
	rm *.class

interval:
	$(COMP) ClienteInterval2D.java
	$(PROB) ClienteInterval2D

rational:
	$(COMP) Rational.java

rationalc:
	$(COMP) RationalClient.java

linear:
	$(COMP) LinearSearchCounter.java
	$(PROB) LinearSearchCounter $(SRC)

slinear:
	$(COMP) SortedLinearSearchCounter.java
	$(PROB) SortedLinearSearchCounter $(SRC)

binary:
	$(COMP) SortedBinarySearchCounter.java
	$(PROB) SortedBinarySearchCounter $(SRC)

ej2: rationalc rational
	$(PROB) RationalClient (añadir numeros de prueba)

ej3: linear slinear binary
