#### Monty-Hall problem

This is totally random write-up and it made it here because it inspired post
about Java Random number generation. Here is how it goes...

There are 3 doors and behind each is either a car or a goat. There are 2 goats
and 1 car altogether. If you try to guess behind which door is a car, what is
the chance of getting it right? Easy! 1 out of 3 makes 33,3% chance of getting
it right.

If someone would open a door with a goat (but not the one that you initially
chose) and ask you if you want to change your selection? Would you change your
choice or stay with initial door?  The correct answer is... if you change door
you will have 66,6% of getting a car, but if you stay with initial choice - you
stay with initial 33,3% chance.

Now I though this result is awkward, because when one door opened you have 2
doors to choose, which is essentially 50/50 chance. But the model (which can be
found [here](https://github.com/romanmarkunas/blog-monty-hall)
proves this is incorrect. So Monty-Hall problem suggests that probabilities have
temporal linking as well, meaning probability depends on the moment when
decision is made as well as your odds.
