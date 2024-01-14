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
        return 1
    elif x != ' ':
        return 0

    lab[zeile] = lab[zeile][:spalte] + 'x' + lab[zeile][spalte + 1:]
    result = suchenAlle(zeile+1, spalte, lab) + \
             suchenAlle(zeile-1, spalte, lab) + \
             suchenAlle(zeile, spalte+1, lab) + \
             suchenAlle(zeile, spalte-1, lab)

    lab[zeile] = lab[zeile][:spalte] + ' ' + lab[zeile][spalte + 1:]
    return result


if __name__ == '__main__':
    lab: [str] = from_file("resources/l2.txt")
    print_labyrinth(lab)
    print("Anzahl gefunden:", suchenAlle(5, 5, lab))
