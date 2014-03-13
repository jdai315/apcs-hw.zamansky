To search for a value in a sorted ArrayList, you won't have to go through every term.
Since the list is sorted, you know that the lowest values are at the start and the highest values are at the end.
To shorten the time to search, you can start searching at the middle index. 
If the value you are looking for is less than the value at the middle index, then you know to only search the lower half of the list.
And vice versa, if the value you are looking for is greater than the middle term, then you look at the greater half of the list. This process can be repeated depending on the size of the list.
