// Team Rin-Sensei: Julia Kozak(Flopsy), Rin Fukuoka(Tape), John Gupta-She(Po)
// APCS pd08
// HW93 -- exploring tree properties, extracting actionable intel from traversals
// 2022-05-05r
// time spent: 0.5 hrs


DISCO
------------------------------------------------
* A connected acyclic graph is the same as a tree.
* Checking if a graph is balanced/perfect/complete might rely on the fact that
  those properties will hold for its left/right subtrees.
================================================


QCC
------------------------------------------------
* Why is "complete" used to describe a graph that doesn't' have each level full
  (when that seems analogous to what a complete graph is)?
* When would you have to rely on these properties being true for a tree?
================================================


SELF-ASSESSMENT PROMPTS
------------------------------------------------
In which direction does a tree grow?
- A tree grows down
Provide as many alternate definitions as you can for "tree," using graph terminology ("closed/open tours", "paths", "cycles", etc). Maximize clarity, succinctness.
- A(n undirected) tree is a graph that contains a unique path between every
  pair of distinct vertices
- A tree contains no cycles. A connected graph with no cycles is a tree
- Since a tree has no cycles, it has no closed tour. It has an open tour only
  if it is degenerate
Why is a balanced tree allowed a difference of 1 in height between right and left subtrees?
- You want to consider a tree balanced regardless of the number of children the nodes at the bottom have
Alternate (equivalent, but more succinct?) definitions of "balanced" tree?
- When you fold the tree in half (centered at the root) all nodes match except potentially for those at the bottom level
Is a perfect tree complete?
- Yes
Is a complete tree balanced?
- Yes
Is the Man Who Is Tall Happy?
- He is 92% happy
What must be true of perfect trees but not others?
- Perfect trees must have every level be full
================================================


C'EST POSSIBLE?
------------------------------------------------
< your explanation of whether the tree reconstruction challenge given in class is achievable or not >
EGDKINLOW in pre-order:

    E
   /  \
  G    I
 / \  / \
D  K N   L
        / \
       O   W

EKDNIOLWG in in-order:

       O
      /  \
     N    W
    / \  / \
   K  I L   G
  / \
 E   D

================================================
