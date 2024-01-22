# author: Sofia Angerer

import argparse
import cProfile
from time import sleep

do_print: bool = False
delay = 0


def from_file(filename: str):
    """
    reads a labyrinth from a file
    :param filename: file to read the lab from
    """
    with open(filename, "r") as f:
        return f.readlines()


def print_labyrinth(lab: [str]):
    """
    prints lab line by line
    :param lab: lab to be printed
    """
    for line in lab:
        print(line.strip())


def suchen(zeile: int, spalte: int, lab: [[str]]):
    """
    finds a way out of the given labyrinth
    """
    x = lab[zeile][spalte]
    if x == 'A':
        return True
    elif x == ' ':
        lab[zeile] = lab[zeile][:spalte] + 'T' + lab[zeile][spalte + 1:]
        print_labyrinth(lab)
        return suchen(zeile+1, spalte, lab) or \
               suchen(zeile, spalte+1, lab) or \
               suchen(zeile-1, spalte, lab) or \
               suchen(zeile, spalte-1, lab)
    else:
        return False


def suchen_alle(zeile: int, spalte: int, lab: [[str]]):
    """
    finds all possible ways out of the giben lab and counts the number of ways
    :return: number of possible ways out of the lab
    """
    x = lab[zeile][spalte]
    if x == 'A':
        if do_print:
            print_labyrinth(lab)
            sleep(delay)
        return 1
    elif x != ' ':
        return 0

    lab[zeile] = lab[zeile][:spalte] + 'T' + lab[zeile][spalte + 1:]
    result = suchen_alle(zeile + 1, spalte, lab) + \
             suchen_alle(zeile - 1, spalte, lab) + \
             suchen_alle(zeile, spalte + 1, lab) + \
             suchen_alle(zeile, spalte - 1, lab)

    lab[zeile] = lab[zeile][:spalte] + ' ' + lab[zeile][spalte + 1:]
    return result


def make_parser():
    """
    creates a parser to enable the program to be executed from the command line
    """
    global do_print

    parser = argparse.ArgumentParser()
    parser.add_argument("filename")
    parser.add_argument("-x", "--xstart", help="x-coordinate to start", action="store_true")
    parser.add_argument("-y", "--ystart", help="y-coordinate to start", action="store_true")
    parser.add_argument("-p", "--print", help="print output of every solution", action="store_true")
    parser.add_argument("-t", "--time", help="print total calculation time (in milliseconds)", action="store_true")
    parser.add_argument("-d", "--delay", help="delay after printing a solution (in milliseconds)", action="store_true")
    args = parser.parse_args()

    if args.filename:
        lab = from_file(args.filename)
        xstart = args.xstart if args.xstart else 1
        ystart = args.ystart if args.ystart else 1
        delay = args.delay
        do_print = args.print
        print(suchen_alle(xstart, ystart, lab))


def run_all():
    """
    runs suchen_alle for 3 different labs
    """
    lab1 = from_file("resources/l1.txt")
    lab2 = from_file("resources/l2.txt")
    lab3 = from_file("resources/l3.txt")
    print(suchen_alle(5, 5, lab1))
    print(suchen_alle(5, 5, lab2))
    print(suchen_alle(5, 5, lab3))


if __name__ == '__main__':
    cProfile.run("run_all()")
    print("done")

    # make_parser()
    # lab: [str] = from_file("resources/l2.txt")
    # print_labyrinth(lab)
    # print("Anzahl gefunden:", suchenAlle(5, 5, lab))
