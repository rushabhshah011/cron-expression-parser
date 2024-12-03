# cron-expression-parser

## Getting Started

### Prerequisites

- **Java 8** or higher.
- **Maven** for building the project.

---

## Build Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/rushabhshah011/cron-expression-parser.git
   cd cron-expression-parser/parser
   ```

2. Build the project using Maven:
   ```bash
   mvn clean package
   ```

3. The executable JAR file will be created in the `target` directory:
   ```
   parser/target/parser-1.0-SNAPSHOT.jar
   ```

---

## Usage

### Command Format

```bash
java -jar target/parser-1.0-SNAPSHOT.jar "<cron_expression>"
```

### Example

#### Input

```bash
java -jar target/parser-1.0-SNAPSHOT.jar "*/15 0 1,15 * 1-5 /usr/bin/find"
```

#### Output

```plaintext
minute          0 15 30 45
hour            0
day of month    1 15
month           1 2 3 4 5 6 7 8 9 10 11 12
day of week     1 2 3 4 5
command         /usr/bin/find
```

---

## Cron Expression Format

A valid cron expression has the following structure:

```
<minute> <hour> <day_of_month> <month> <day_of_week> <command>
```

### Fields

- `minute`: Values from `0-59`.
- `hour`: Values from `0-23`.
- `day_of_month`: Values from `1-31`.
- `month`: Values from `1-12`.
- `day_of_week`: Values from `0-6` (`0` is Sunday).

---

## Supported Syntax

1. **Wildcard (`*`)**
    - Matches all values within the field range.
    - Example: `*` in `minute` expands to `0 1 2 ... 59`.

2. **Comma-Separated Values (`1,15`)**
    - Matches any of the specified values.
    - Example: `1,15` in `day_of_month` expands to `1 15`.

3. **Range (`-`)**
    - Matches all values within the specified range.
    - Example: `1-5` in `day_of_week` expands to `1 2 3 4 5`.

4. **Step (`/`)**
    - Matches values at intervals of the specified step.
    - Example: `*/15` in `minute` expands to `0 15 30 45`.

---

## Example Test Cases

### Input

```
*/15 0 1,15 * 1-5 /usr/bin/find
```

### Expected Output

```plaintext
minute          0 15 30 45
hour            0
day of month    1 15
month           1 2 3 4 5 6 7 8 9 10 11 12
day of week     1 2 3 4 5
command         /usr/bin/find
```

---

## Testing

### Run Tests

To execute the unit tests, run the following command:

```bash
mvn test
```


