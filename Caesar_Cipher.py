import string

def shift(path):
    org_alpha = list(string.ascii_lowercase)
    ceasar_alpha = list(string.ascii_lowercase)
    
    shiftNum = int(input("Num of spaces: "))
    if path == "left" or path == 'l':
        x, y = 0, 25
    elif path == 'right' or path == 'r':
        x, y, = 25, 0
    for i in range(0,shiftNum):
        shift_letter = ceasar_alpha.pop(x)
        ceasar_alpha.insert(y, shift_letter)
    return [org_alpha, ceasar_alpha]

mesg = input("Enter statement to code: ").lower()
path = input("Shift(l)eft or (r)ight:  ").lower()
[alp, cea] = shift(path)

count = 0;
final_mesg = []
for i in mesg: #look at each position
    if not i.isspace():
        for j in alp:
            if j != i:
                count +=1
            else:
                final_mesg.insert(len(final_mesg),cea[count])
                count = 0
                break
    elif i.isspace():
        final_mesg.insert(len(final_mesg),i)

print("\nOrig. Message: " + mesg)
print("Ceas. Message: " + ''.join(final_mesg))
