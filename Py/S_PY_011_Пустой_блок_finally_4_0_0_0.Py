from logger import log

def divide(x, y):
    try:
        print("Your answer is: ", x // y)
    finally:
        # S_PY_011 Пустой блок finally x1
        pass

    try:
        print("Your reversed answer is: ", y // x)
    finally:
        # S_PY_011 Пустой блок finally x1
        ...

    try:
        print("Nice try !!", y // x)
    finally:
        # S_PY_011 Пустой блок finally x1
        "I am here !"

def divide(list, y):
    try:
        print("Your answer is: ", num // y)
    finally:
        # S_PY_011 Пустой блок finally x1
        pass; ...
        12345
        "I am just a placeholder"

log(divide(4, 2))
