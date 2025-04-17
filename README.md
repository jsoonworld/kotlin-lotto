# Feature Checklist

- [ ] Lotto numbers must be in the range of 1 to 45.
- [ ] One lotto ticket consists of 6 unique numbers.
- [ ] Winning numbers consist of 6 unique numbers and 1 bonus number.
- [ ] Prizes are awarded from 1st to 5th place, based on the number of matching numbers:
  - [ ] Prize amounts by rank:
    - [ ] 1st: Match 6 numbers / 2,000,000,000 KRW
    - [ ] 2nd: Match 5 numbers + bonus number / 30,000,000 KRW
    - [ ] 3rd: Match 5 numbers / 1,500,000 KRW
    - [ ] 4th: Match 4 numbers / 50,000 KRW
    - [ ] 5th: Match 3 numbers / 5,000 KRW
- [ ] When the purchase amount is entered, the corresponding number of lotto tickets must be issued.
  - [ ] Lotto tickets must be issued based on the purchase amount.
- [ ] The price of one lotto ticket is 1,000 KRW.
  - [ ] Lotto tickets can be purchased in units of 1,000 KRW.
- [ ] The winning numbers and bonus number must be input.
  - [ ] Winning numbers and bonus number must not duplicate.
- [ ] Compare the purchased lotto numbers with the winning numbers, display the results and the yield, then end the game.
  - [ ] Able to compare lotto numbers and winning numbers.
  - [ ] Able to display winning results.
  - [ ] Able to calculate the yield.
- [ ] If the user inputs an invalid value, an `IllegalArgumentException` must be thrown and an error message starting with `[ERROR]` should be printed. Then, prompt the user to re-enter from that point.
  - [ ] Must handle specific exceptions like `IllegalArgumentException`, `IllegalStateException`, etc., not just `Exception`.
  - [ ] After printing the error message, allow re-input from that step.

# Input

- [ ] Ask for the lotto purchase amount.
  - [ ] The purchase amount must be in units of 1,000 KRW. If not divisible by 1,000, an exception should be thrown.

```
14000
```

- Ask for the winning numbers.
  - [ ] Numbers should be separated by commas (`,`).
  - [ ] If not properly comma-separated, an exception should be thrown.
  - [ ] If any non-numeric characters are included, an exception should be thrown.

```
1,2,3,4,5,6
```

- Ask for the bonus number.

```
7
```

# Output

- [x] Display the purchase prompt.
```
Please enter the purchase amount.
```

- [ ] Display the number of lotto tickets purchased and the numbers. Numbers should be displayed in ascending order.
  - [ ] Show the message about the number of tickets purchased.
  - [ ] Display each ticket's numbers in ascending order.

```
You have purchased 8 tickets.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]
```

- [ ] Display the winning number input prompt.
```
Please enter the winning numbers.
```

- [ ] Display the bonus number input prompt.
```
Please enter the bonus number.
```

- [ ] Display the winning statistics message.
```
Winning Statistics
---
```

- [ ] Display the result of winning tickets.
```
3 matches (5,000 KRW) - 1 ticket
4 matches (50,000 KRW) - 0 tickets
5 matches (1,500,000 KRW) - 0 tickets
5 matches + Bonus Ball (30,000,000 KRW) - 0 tickets
6 matches (2,000,000,000 KRW) - 0 tickets
```

- [ ] Display total yield message.
  - [ ] The yield should be rounded to the nearest tenth. (e.g., 100.0%, 51.5%, 1,000,000.0%)
```
The total yield is 62.5%.
```

- [ ] On exception, an error message must be printed starting with `[ERROR]`.
```
[ERROR] Lotto numbers must be between 1 and 45.
```

# Sample Run
```
Please enter the purchase amount.
8000

You have purchased 8 tickets.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]

Please enter the winning numbers.
1,2,3,4,5,6

Please enter the bonus number.
7

Winning Statistics
---
3 matches (5,000 KRW) - 1 ticket
4 matches (50,000 KRW) - 0 tickets
5 matches (1,500,000 KRW) - 0 tickets
5 matches + Bonus Ball (30,000,000 KRW) - 0 tickets
6 matches (2,000,000,000 KRW) - 0 tickets
The total yield is 62.5%.
```

