# Lab 6: Static Code analysis (with Sonar Qube)

## Task 1: Analyze an existing project (local Sonar Qube)

### e) Has your project passed the defined quality gate? Elaborate your answer.

Yes, despite having the following issues:
* 1 Bug
* 1 Security Hotspot
* 29 code smells

### f) Explore the analysis results and complete with a few sample issues, as applicable. (Place your response in a Readme document/markdown file, along with the code project).

| Issue  | Problem description | How to solve
| :--- | :--- | :--- |
| [Bug] "Random" objects should be reused  | Creating a new random each time is very inefficient | For better efficiency and randomness, create a single Random, then store, and reuse it.  Instantiate the random number before the method `private Random rand = SecureRandom.getInstanceStrong();` | 
| [Vulnerability] 0 Vulnerabilities found  | -  | - |
| [Code smell (major)] "for" loop stop conditions should be invariant | A for loop stop condition should test the loop counter against an invariant value | Content Cell  |
| [Code smell (major)] Remove this unused method parameter "subset" | Method parameter is unused  | Remove unused parameter |
| [Code smell (major)] Standard outputs should not be used directly to log anything | Message logs should be explicit  | Replace use of `System.out` or `System.err` by a logger |

## Task 2: Resolve technical debt

### a)

The technical debt is 2h 20min. This represents the amount of effort needed to fix all code smells, it also means that, in theory, it should take this amount of time for the fix.

### d)

Regarding code coverage, there is 70.2% coverage, as well as 41 lines "uncovered". There are also 52 conditions to cover, making it 75.0% condition coverage.

## Task 3: Define and apply quality gates

For this exercise, I used the previous project.

### a)

| Metric  | Operator | Value | Reason
| :--- | :--- | :--- | :--- |
| Bugs | is greater than | 3 | I believe 3 is a reasonable # of bugs, but this # depends a lot on the size/type of the project |
| Critical Issues | is greater than | 2 | There should be as minimum critical issues as possible, in my opinion, 2 is a acceptable number |
| Duplicated Lines (%) | is greater than | 5.0% | The code should have as few duplicated lines as possible, this being said, 5% sounded reasonable |
| Line Coverage | is less than | 90.0% | 90% felt like an appropriate % |
| Unit Test Failures | is greater than | 0 | For a fully functional application, there shouldn't be any unit test failures |