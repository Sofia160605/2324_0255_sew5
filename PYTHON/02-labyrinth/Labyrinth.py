import argparse
from time import sleep

do_print: bool = False
delay = 0

def from_file(filename: str):
    with open(filename, "r") as f:
        return f.readlines()


def print_labyrinth(lab: [str]):
    for line in lab:
        print(line.strip())


def suchen(zeile: int, spalte: int, lab: [[str]]):
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


def suchenAlle(zeile: int, spalte: int, lab: [[str]]):

    x = lab[zeile][spalte]
    if x == 'A':
        if do_print:
            print_labyrinth(lab)
            sleep(delay)
        return 1
    elif x != ' ':
        return 0

    lab[zeile] = lab[zeile][:spalte] + 'T' + lab[zeile][spalte + 1:]
    result = suchenAlle(zeile+1, spalte, lab) + \
             suchenAlle(zeile-1, spalte, lab) + \
             suchenAlle(zeile, spalte+1, lab) + \
             suchenAlle(zeile, spalte-1, lab)

    lab[zeile] = lab[zeile][:spalte] + ' ' + lab[zeile][spalte + 1:]
    return result


def makeParser():
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
        print(suchenAlle(xstart, ystart, lab))



if __name__ == '__main__':
    makeParser()
    # lab: [str] = from_file("resources/l2.txt")
    # print_labyrinth(lab)
    # print("Anzahl gefunden:", suchenAlle(5, 5, lab))
