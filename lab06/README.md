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

