# Level 3 – Strategy pattern

## About the exercise

The aim of this exercise is to implement the **Strategy** design pattern through a report generation system that can produce reports in different formats.

The Strategy pattern lets you change the behaviour of an algorithm at runtime. Each algorithm lives in its own class behind a common interface, so the code that uses it does not need any `if` or `switch` to choose a behaviour.

## How the pattern maps to the code

| Role in the pattern | Class(es) |
|---|---|
| Strategy | `ReportStrategy` |
| Concrete strategies | `CsvStrategy`, `ExcelStrategy`, `HtmlStrategy`, `JsonStrategy`, `PdfStrategy`, `WordStrategy`, `XmlStrategy` |
| Context | `ReportService` |

## Package structure

| Package | Contents |
|---|---|
| `interfaces` | The `ReportStrategy` interface. |
| `strategies` | One class per report format. |
| `services` | The `ReportService` class, which uses a strategy. |

## How it works

1. `ReportService` receives a `ReportStrategy` in its constructor, so it never depends on a concrete format.
2. `generateReport(data)` checks the data and delegates the work to the current strategy.
3. The strategy can be changed at runtime with `setReportStrategy()`.

## Formats

| Strategy | Output for `data` |
|---|---|
| `CsvStrategy` | `name;price;data` |
| `ExcelStrategy` | `Excel: data` |
| `HtmlStrategy` | `<HTML> data </HTML>` |
| `JsonStrategy` | `{ data }` |
| `PdfStrategy` | `PDF: data` |
| `WordStrategy` | `Word: data` |
| `XmlStrategy` | `data` wrapped in `<information><customer><data>…</data></customer></information>` with an XML header |

## Validation

`ReportService` throws an `IllegalArgumentException` if:

- The strategy is `null`, in the constructor or in `setReportStrategy()`.
- The data is `null`, empty or blank.

## Adding a new format

Create a class that implements `ReportStrategy`. `ReportService` and the existing strategies stay exactly as they are (open for extension, closed for modification).

## Unit tests

The implementation is verified with JUnit Jupiter, AssertJ and Mockito:

- `ReportServiceTest` uses a Mockito mock to check that the service delegates to its strategy and passes the data unchanged.
- One test per strategy (`CsvStrategyTest`, `HtmlStrategyTest`, etc.) checks its output format.

## How to run the tests

From the project root, run only the tests for this level:

```bash
mvn test -Dtest='com.nivell3.strategy.**'
```

[← Back to the main README](../../../../../../README.md)
