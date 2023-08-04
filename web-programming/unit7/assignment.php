<!-- 1. Write a program in PHP using a ‘for’ loop to add all the integers between 0 and 50 and
display the total.: -->
<?php
// Initialize the variable to store the total sum
$total = 0;
// Loop over integers between 0 and 50 and add them to the total
for ($i = 0; $i <= 50; $i++) {
$total += $i;
}
// Display the total sum
echo "The total sum of integers between 0 and 50: " . $total;
?>

<!-- 2. Write a PHP program to check if a person is eligible to vote using control structure.
(Criteria: Minimum age required to vote is 18): -->
<?php
// Define the minimum age to vote
$minVotingAge = 18;
// Get the person's age
$personAge = 20;
// Overwrite the person's age
$personAge = 17;
// Check if the person is eligible to vote
if ($personAge >= $minVotingAge) {
echo "You are eligible to vote.";
} else {
echo "You are NOT eligible to vote.";
}
?>

<!-- 3. Write a PHP program to check whether a number is prime or not: -->
<?php
// Function to check if a number is prime
function isPrime($number) {
// 0 and 1 are not prime numbers
if ($number <= 1) {
return false;
}
// Check for divisors from 2 to sqrt(number)
for ($i = 2; $i * $i <= $number; $i++) {
if ($number % $i == 0) {
return false;
}
}
return true;
}
// Test
// $num = 1;
// $num = 17;
$num = 728;
// Check if the number is prime and display the result
if (isPrime($num)) {
echo "$num is a prime number.";
} else {
echo "$num is NOT a prime number.";
}
?>