def sortString(arr):
    _map = {}
    for i in arr:
        local_k, local_v  = i.split()
        
        value = _map.get(local_k)
        if value:
            count, word, ord_val = value
            
            current_word_ord_value = fetch_ord_value(local_v)
            if current_word_ord_value > ord_val:
                count += 1
                word = local_v
                ord_val = current_word_ord_value
            else:
                count += 1
                
            
            _map[local_k] = [count, word, ord_val]
        else:
            _map[local_k] = [1, local_v, fetch_ord_value(local_v)]
            
    arr.clear()
    for k,v in _map.items():
        arr.append('{}:{},{}'.format(k, v[0], v[1]))
    return arr
    
def fetch_ord_value(string):
    ord_val = 0
    for char in string:
        ord_val += ord(char)
        
    return ord_val
    
# -----------------
# Driver code
    

_input = [
"key1 abcd",
"key2 zzz",
"key1 hello",
"key3 world",
"key1 hello"
]

output = sortString(_input)
for chunk in output:
    print(chunk)


# Sample output
# ------------------
# "key1:3,hello",
# "key2:1,zzz",
# "key3:1,world"

