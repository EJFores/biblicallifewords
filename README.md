# Biblical Life Words 

### What is this?

This is a website created with Next.js/React to return a randomly selected verse from a set list of verses. These bible verses were shared by a pastor friend of 
mine to their youth group to read daily. I decided to turn this list into a website that will present them digitally for those folks who dont carry a 
non-laminated peice of paper around. 

### How does it work?


### Dependencies
    `"antd": "^5.24.6",`
    `"next": "15.2.4",`
    `"react": "^19.0.0",`
    `"react-dom": "^19.0.0"`

### Plans for future updates
- Make a way to fetch from the NLT Bible api to get other versions. 

### Known Bugs 
- Sometimes the verses get cut off by \n. It seems regex pattern matching breaks on bug based reloads?
- Refresh button does not actually call async call. Need to seperate it out from the display function. 