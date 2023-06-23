import numpy as np
import matplotlib.pyplot as plt


def algorithmA(n):
    return 1000 * n ** 3


def algorithmB(n):
    return 2 ** n


# Generate x values (problem sizes)
x = np.arange(1, 21)

# Calculate y values (number of steps) for each algorithm
y_algorithmA = algorithmA(x)
y_algorithmB = algorithmB(x)

# Plot the graph
plt.plot(x, y_algorithmA, label='Algorithm A (1000n^3)')
plt.plot(x, y_algorithmB, label='Algorithm B (2^n)')

# Set up the plot
plt.xlabel('Problem Size (n)')
plt.ylabel('Number of Steps')
plt.title('Algorithm Comparison')
plt.legend()

# Display the graph
plt.show()
