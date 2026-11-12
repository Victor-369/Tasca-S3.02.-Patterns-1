# Level 2 – Abstract Factory pattern

## About the exercise

The aim of this exercise is to implement the **Abstract Factory** design pattern through a small contact manager that formats addresses and phone numbers according to the country.

The Abstract Factory pattern lets you create **families of related objects** without depending on their concrete classes. Here, each country is a family: Spain has its own address and phone formats, and so does the USA. The client code works the same way whichever country it receives.

## How the pattern maps to the code

| Role in the pattern | Class(es) |
|---|---|
| Abstract products | `Address`, `Phone` |
| Abstract factory | `ContactFactory` |
| Concrete factories | `SpainContactFactory`, `USAContactFactory` |
| Concrete products | `SpainAddress`, `SpainPhone`, `USAAddress`, `USAPhone` |
| Client | `Contact` |

## Package structure

| Package | Contents |
|---|---|
| `interfaces` | The abstract products and the abstract factory. |
| `factories` | One concrete factory per country. |
| `products` | One address and one phone class per country. |
| `clients` | The `Contact` class, which uses the factory. |

## How it works

1. A concrete factory is created with the contact details (street, city, postcode and phone number) and stores them.
2. `Contact` receives the factory as a `ContactFactory`, so it never knows which country it belongs to.
3. `Contact` calls `createAddress()` and `createPhone()`. The factory creates the products for its own country at that moment.
4. Each product formats itself through `getAddress()` or `getPhoneNumber()`, and `Contact.toString()` joins both results.

## Formats

| | Spain | USA |
|---|---|---|
| Address | `street, postcode city` | `street, city, STATE ZIP` |
| Postcode input | 5 digits, e.g. `08001` | 2 capital letters, a space and 5 digits, e.g. `NY 10001` |
| Phone input | 9 digits | 9 digits |
| Phone output | `+34 XXX XX XX XX` | `+1 (0XX) XXX-XXXX` (a leading `0` is added) |

Example outputs:

```
Address: Carrer Major 34, 08001 Barcelona | Phone: +34 623 45 67 89
Address: 154 5th Avenue, New York, NY 10001 | Phone: +1 (098) 765-4321
```

## Validation

The products check their data when they are created and throw an `IllegalArgumentException` if something is wrong:

- The street and the city cannot be `null`, empty or blank.
- The postcode must follow the country's format.
- The phone number must contain exactly 9 digits.

## Adding a new country

To support a new country, you only need to create:

- An address class that implements `Address`.
- A phone class that implements `Phone`.
- A factory that implements `ContactFactory`.

`Contact` and the interfaces stay exactly as they are.

## Unit tests

The implementation is verified with JUnit Jupiter and AssertJ:

- `ContactTest` checks that the same `Contact` class produces the right output with the Spanish factory and with the American one.
- `SpainAddressTest` and `USAAddressTest` check the address format and that a wrong street, city or postcode is rejected.
- `SpainPhoneTest` and `USAPhoneTest` check the phone format and that a wrong phone number is rejected.

Parameterised tests are used to try several invalid inputs at once, such as `null`, empty or blank values, values that are too short or too long, and values with letters where only digits are allowed.

## How to run the tests

From the project root, run only the tests for this level:

```bash
mvn test -Dtest='ContactTest,SpainAddressTest,SpainPhoneTest,USAAddressTest,USAPhoneTest'
```

[← Back to the main README](../../../../../../README.md)
