# text ###
# A study involving stress is done on a college campus among the students. The stress scores follow a (continuous) Uniform distribution with the lowest stress score equal to 1 and the highest equal to 5. Using a sample of 75 students, find:
a <- 1
b <- 5
n <- 75
mu.bar <- (a + b) / 2
sig.bar <- sqrt((b - a)^2 / (12 * n))
mu.bar
# [1] 3
sig.bar
# [1] 0.1333333

# 1. The probability that the average stress score for the 75 students is less than 2.
pnorm(2, mu.bar, sig.bar)
# [1] 3.190892e-14

# 2. The 90th percentile for the average stress score for the 75 students.
> qnorm(0.9, mu.bar, sig.bar)
[1] 3.170874

# 3. The probability that the total of the 75 stress scores is less than 200.
pnorm(200/n, mu.bar, sig.bar)
[1] 0.006209665

# 4. The 90th percentile for the total stress score for the 75 students.
n * qnorm(0.9, mu.bar, sig.bar)
[1] 237.8155

# Consider again the same stress study that was described in Example 1 and answer the same questions. However, this time assume that the stress score may obtain only the values 1, 2, 3, 4 or 5, with the same likelihood for obtaining each of the values.
> x <- 1:5
> p <- rep(1/5, 5)
> p
[1] 0.2 0.2 0.2 0.2 0.2
> n <- 75
> mu.X <- sum(x*p)
> mi.X
Error: object 'mi.X' not found
> mu.X
[1] 3
> sig.X <- sum((x-mu.X)^2*p)
> sig.X
[1] 2
> mu.bar <- mu.X
> sig.bar <- sqrt(sig.X/n)
> mu.bar
[1] 3
> sig.bar
[1] 0.1632993
> pnorm(2, mu.bar, sig.bar)
[1] 4.570649e-10
> qnorm(0.9, mu.bar, sig.bar)
[1] 3.209276
> pnorm(200/n, mu.bar, sig.bar)
[1] 0.02061342
> pnorm(199.5/n, mu.bar, sig.bar)
[1] 0.01866821
> n * qnorm(0.9, mu.bar, sig.bar)
[1] 240.6957

# Suppose that a market research analyst for a cellular phone company conducts a study of their customers who exceed the time allowance included on their basic cellular phone contract. The analyst finds that for those customers who exceed the time included in their basic contract, the excess time used follows an exponential distribution with a mean of 22 minutes. Consider a random sample of 80 customers and find
# 1. The probability that the average excess time used by the 80 customers in the sample is longer than 20 minutes.
> 1 - pnorm(20, mu.bar, sig.bar)
[1] 0.7919241

# 2. The 95th percentile for the average excess time for samples of 80 customers who exceed their basic contract time allowances.
> qnorm(0.95, mu.bar, sig.bar)
[1] 26.0458

# A beverage company produces cans that are supposed to contain 16 ounces of beverage. Under normal production conditions the expected amount of beverage in each can is 16.0 ounces, with a standard deviation of 0.10 ounces.
# As a quality control measure, each hour the QA department samples 50 cans from the production during the previous hour and measures the content in each of the cans. If the average content of the 50 cans is below a control threshold then production is stopped and the can filling machine is re-calibrated.
# 1. Compute the probability that the amount of beverage in a random can is below 15.95.


# 2. Compute the probability that the amount of beverage in a sample average of 50 cans is below 15.95.
> pnorm(15.95, 16, 0.1/sqrt(50))
[1] 0.000203476

# 3. Find a threshold with the property that the probability of stopping the machine in a given hour is 5% when, in fact, the production conditions are normal.
> qnorm(0.05, 16, 0.1/sqrt(50))
[1] 15.97674

# 4. Consider the data in the file “QC.csv”2. It contains measurement results of 8 hours. Assume that we apply the threshold that was obtained in Question 4.3. At the end of which of the hours the filling machine needed re-calibration?


# 5. Based on the data in the file “QC.csv”, which of the hours contains mea- surements which are suspected outliers in comparison to the other mea- surements conducted during that hour?



# self quiz ###
x <- c(4.4, 5.3, 4.4, 2.8, 0.9, 6.1, 3.0, 8.6, 10.7, 4.3, 1.9, 12.0, 5.9, 4.8, 7.7)

# graded quiz ###

