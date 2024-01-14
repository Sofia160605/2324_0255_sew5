def fromFile(filename: str):
    with open(filename, "r") as f:
        return f.readlines()


def printLabyrinth(lab: [str]):
    for line in lab:
        print(line.strip())


if __name__ == '__main__':
    lab: [str] = fromFile("resources/l1.txt")
    printLabyrinth(lab)