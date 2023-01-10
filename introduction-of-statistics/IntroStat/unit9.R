# final exam ###
# You are interested in the number of English-speaking people on the planet who wantto play a new kind of online video game.
# You asked 300 college students if they wereinterested in playing video games, 100 said yes, and of them 20 preferred your gameto an existing game that is widely used.

# 1) How many people were in the sample?
300

# 2) What is the mean of x?
x <- c(12, 14, 11, 14, 13, 15, 12, 16, 10)
mean(x)
13

# 3) Using the value of x from the prior question, what is the standard deviation of x?
sd(x)
1.936492

# There was a very short quiz with ve questions. The following table shows the
# number of correct answers and the cumulative relative frequency for those scores in the class.

# 4) What is the probability that a randomly selected student from the class scored a 3 on the short quiz?
0.55 - 0.13
0.42

# Use this information for the next three questions.
# A random variable called L is defined by the following table, but one of the relative frequencies is missing:

# 5) What is the missing value in the list of relative frequencies for random variable L?
1 - .17 - .11 - .23 - .15
0.34

# 6) What is the probability that a randomly selected item from random variable L
# will be greater than 0 and less than or equal to 3?
.23 + .34
0.57

# 7) What is the expectation of random variable L?
-5 * .17 + 0 * .11 + 1 * .23 + 3 * .34 + 8 * .15
1.6

# 8) What is the variance of random variable L?
x <- c(-5, 0, 1, 3, 8)
p <- c(.17, .11, .23, .34, .15)
sum((x - 1.6)^2 * p)
14.58

# 9) Which distributions are discrete?
#* none of the answers above are accurate

# Note: There are 20 items on this exam. You are at the half-way point.
# Use this information for the next three questions.
# You operate a game at an amusement park where people throw darts at balloonsand try to win prizes.
# Players get to throw 5 darts.
# From prior experience, you knowthat the probability of success (popping a balloon) for each dart is .15.

# 10) What is the expected number of successes (balloons popped) when throwing 5 darts(rounded to two decimal places)?
5 * .15
0.75

# 11) What is the probability of getting 4 or more successes (popped balloons) in 5 throws(rounded to two decimal places)?
1 - pbinom(x = 3, size = 5, prob = .15)
0.00

# 12) A Poisson distribution called Q has an expectation of 4.
# Which of the following R commands would tell you the probability
# that a randomly selected value from Q is less than 6 and greater than or equal to 4 (read the question carefully):
ppois(q = 5, lambda = 4) - ppois(q = 3, lambda = 4)

# 13) At a small store, a customer enters the front door on average every 8 minutes.
# A prior study indicated that the time between customers entering the front door during weekdays follows an exponential distribution.
# What is the probability that the time between customers entering the store on a weekday will be less than or equal to 7?
lambda <- 1 / 8
pexp(q = 7, rate = lambda)
0.58

# 14) You read a research paper that applies to your industry,
# and it says that when people are given a list of facts about your product,
# they are more likely to buy your product and that the difference between the regular amount of sales and the sales when people read the list of facts is 3 standard deviations.
# How would you describe the difference of 3 standard deviations (select the best answer)?
#* It is an important difference because a 3 standard deviation difference would be expected due to random chance in less than 1% of the cases

# Use the following information for the next three questions.
# At a medium sized airport, mechanics need to replace tires on some of the airplanes each week
# because the tread on the tires is below the safe limit.
# You collected 36 weeks of data and observed that the numbers followed a Poisson distribution and that there was an average of 2 tires replaced per week.

# 15) What is the lambda value for the Poisson distribution?
2

# 16) If we know that the expectation is 2, what is the standard deviation of the Poisson distribution?
sqrt(2)

# 17) Traffic at the airport changed recently, and you collected 36 weeks of data in an effort to estimate the new rate of tire replacements.
# You found that the average tire replacements per week was 2 and the numbers followed a Poisson distribution, but you realize that your sample might not be 100% accurate.
# What is the 99th percentile of sampling distribution of the mean of tires replaced per week (based on the observed mean of 2 and the sample size of 36)?
qnorm(p = .99, mean = 2, sd = sqrt(2) / 6)

# 18) The mean weekly sales per employee at a nationwide store is normally distributed with a mean of $7,300 per week and a standard deviation of $700.
# What is the probability that a randomly selected employee will have sales less than $6,500?
pnorm(q = 6500, mean = 7300, sd = 700)
0.13

# 19) The time between incoming customer service calls to a computer-repair hotline follows an exponential distribution with an expectation of 2 minutes between calls.
# What is the probability that the time between calls will be less than 1 minute for a randomly selected period?
lambda <- 1 / 2
pexp(q = 1, rate = lambda)
0.39

# 20) The time between customer service calls to a computer-repair hotline follows an exponential distribution with an expectation of 2 minutes between calls.
# We collect calls for 40 minutes at random times during the month (a sample of size n=40).
# What is the probability that the mean of our sampling distribution will be greater than 2.2 minutes?
sd <- sqrt(2^2) / sqrt(40)
1 - pnorm(q = 2.2, mean = 2, sd = sd)
0.26
