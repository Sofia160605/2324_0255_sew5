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


if __name__ == '__main__':
    lab: [str] = from_file("resources/l1.txt")
    print_labyrinth(lab)
    print("Ausgang gefunden:", suchen(5, 5, lab))