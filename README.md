# Radio-Item-Management-System
Not my very first project, but a big one. It's my second content management back-end project.

Language:
    Java
Challenges:
    - loading properly typecasted items into the ArrayList
    - randomly selecting items to create a playlist as long as the accumulated time is within user input time constraints

I used inheritance to properly load the items in the text file to the ArrayList.

There are 6 major items in the menu
  1. Add an item
  2. Remove and item
  3. Print ALL items
  4. Print a particular type of item
  5. Seach item by ID
  6. Make a random playlist
  7. Exit

The playList() method was a little challenging to make but it was fun. I could have done it a bit better. Instead of adding an item to the ArrayList then checking if that item is within my time constraints, I could have checked if the item is within my time constraints first before adding it to my ArrayList.
