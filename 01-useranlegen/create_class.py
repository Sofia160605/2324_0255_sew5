import argparse

from openpyxl import load_workbook


def read_excel(file: str):
    """
    reads an excel file and yields the lines
    :param file: edcel file
    :return: lines of file
    """

    wb = load_workbook(file, read_only=True)
    ws = wb[wb.sheetnames[0]]
    for row in ws.iter_rows(min_row=1):
        name = row[0].value
        room_nr = row[1].value
        class_teacher = row[2].value

        if name is not None and room_nr is not None and class_teacher is not None:
            yield name, room_nr, class_teacher




def make_parser():
    '''
    creates parser to execute function on command line
    '''

    parser = argparse.ArgumentParser()
    parser.add_argument("filename")
    args = parser.parse_args()


    if args.filename:
        write_script()


def create_bash_file(data, filename):
    pass


def create_users(filename: str):
    for line in read_excel(filename):
        usr_name = "k"+line[0].lower()
        return



if __name__ == '__main__':
    make_parser()
    #create_users("./Klassenraeume_2023.xlsx")