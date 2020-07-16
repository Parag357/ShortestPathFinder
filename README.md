The shortest path problem is to find a path between two vertices/nodes in a digraph with non-negative edge weights G= (V, E) and a distinguished source vertex s belongs to V such that the sum of the weights of its constituent edges is minimized in a graph.

The problem of finding the shortest path between two intersections on a road map may be modelled as a special case of the shortest path problems in graphs, where the vertices correspond to intersections and the edges correspond to road segments, each weighted by the length of the segment.

# Here is a sample test case:

# Enter the total number of cities:

9

# Enter the distances from each city to every other city:

00 04 00 00 00 00 00 08 00

04 00 08 00 00 00 00 11 00

00 08 00 07 00 04 00 00 02

00 00 07 00 09 14 00 00 00

00 00 00 09 00 10 00 00 00

00 00 04 14 10 00 02 00 00

00 00 00 00 00 02 00 01 06

08 11 00 00 00 00 01 00 07

00 00 02 00 00 00 06 07 00

# Enter the source city between 0 to 8:

5

# Enter the destination city between 0 to 8:

7

# The minimum distance between source 7 and destination 5 is: 3 units.

# The shortest path between the two cities is: "City 5 City 6 City 7"
