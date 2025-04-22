# Небезопасная генерация псевдорандомных чисел
random.seed(len := 6)
for _ in range(len):
    print(random.random())


import random as rnd
# TODO: необходимо уметь обнаруживать
rnd.seed(1234)
for _ in range(10):
    print(rnd.random())

random()

# TODO: необходимо уметь обнаруживать
hardcoded_seed = 11234
random.seed(hardcoded_seed)

# Не хардкод аргументов
secure_seed = getSecureSeed()
random.seed(secure_seed)
random.seed(getSecureSeed())

# Непрямой вызов метода
ghtrk.random[2]()
