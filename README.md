# QuadTree Particle Proximity Simulation
 A particle proximity simulation using a quadtree for speed optimisation 

This was a university assignment where we were given a baseline project and tasked with optimising the code to make it run faster / simulate more particles (also referred to as phones - the spec was a bluetooth mesh network communication method I believe).

I began removing inefficient nested loops and using more efficient datatypes where applicable (hashsets), and eventually implementing a quadtree which greatly sped things up and allowed the simulation of significantly more particles, and achieved one of the highest scores in the university.

Most of my own code is in StudentSimulation.java, with the given code also provided for comparison in BaseLineSimulation.java
