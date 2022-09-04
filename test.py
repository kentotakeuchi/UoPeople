def invert_dict(d: dict) -> dict:
    print('inverting dict..')
    inverse = dict()
    for key in d:
        vals = d[key]
        for v in vals:
            if v not in inverse:
                inverse[v] = [key]
            else:
                inverse[v].append(key)
    return inverse


invert_dict({1: 10, 2: 10, 3: 20})
