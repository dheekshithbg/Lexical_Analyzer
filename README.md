# Lexical Analyzer

This Java program is designed to perform lexical analysis on a given source code file, extracting various tokens such as keywords, operators, variables, constants, literals, special characters, comments, and preprocessors. The program reads the source code from a file named `code.txt`, processes it line by line, and categorizes each element found in the code. The results are printed to the console, providing a detailed breakdown of the different types of tokens and non-tokens in the source code.

## Features

### Token Identification

- **Keywords**: Identifies Java reserved words from a predefined list.
- **Operators**: Recognizes common arithmetic, assignment, and comparison operators.
- **Variables**: Extracts variable names based on their position relative to assignment operators.
- **Constants**: Detects numeric constants, including floating-point numbers.
- **Literals**: Captures string literals enclosed in quotation marks.
- **Special Characters/Delimiters**: Identifies punctuation marks and delimiters like commas, semicolons, and parentheses.

### Non-Token Identification

- **Comments**: Extracts single-line comments starting with `//`.
- **Preprocessors**: Captures preprocessor directives starting with `@`.

### Output Formatting

- Prints a categorized list of tokens and non-tokens.
- Displays the count of operators and lists all detected lexemes in a readable format.

## Implementation Details

### File Reading

- The program reads the source code from `code.txt` using a `Scanner`.

### Character Analysis

- Iterates over each character in the source code to identify operators, special characters, literals, etc.

### String Tokenization

- Splits each line of the source code into words to identify keywords.

### Collections Usage

- Uses an `ArrayList` for keywords and a `String[]` array for variables.

### Handling Edge Cases

- Includes checks for proper handling of special cases like string literals and single-line comments.

## How to Use

1. Place the source code you want to analyze in a file named `code.txt` in the same directory as this Java program.
2. Run the program. It will read `code.txt`, perform lexical analysis, and print the results to the console.
