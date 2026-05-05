# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this project is

Academic exercises for the OO2 (Object-Oriented Programming 2) course at UNLP. The focus is on identifying code smells and applying refactoring techniques from Martin Fowler's *Refactoring* book.

## Structure

Each exercise is an independent Maven project:

| Directory | Description |
|---|---|
| `Refactoring/` | Markdown files with exercise statements and written solutions (Ej1–Ej6.3) — no code here |
| `Refactoring_Ej3/` | Circular iterators: `CharRing` / `IntRing` → `Ring` (Extract Superclass, Pull Up Field) |
| `Refactoring_Ej5/` | Travel products: `Product` → `HotelStay` / `CarRental` with `Hotel`, `Company` (Pull Up Method, Encapsulate Field, Move Method) |
| `Repaso_Ej1/` | Twitter model: `Twitter` → `Usuario` → `TweetBase` (`Tweet` / `ReTweet`) |
| `Repaso_Ej2/` | Rock-Paper-Scissors-Lizard-Spock using Double Dispatch pattern |

## Build and test commands

Each sub-project has its own `pom.xml`. Run commands from within the sub-project directory.

```bash
# Compile
mvn compile

# Run all tests
mvn test

# Run a single test class
mvn test -Dtest=CharRingTest

# Run a single test method
mvn test -Dtest=CharRingTest#testNext
```

Java versions: `Refactoring_Ej5` targets Java 11; all others target Java 23.

## Key design patterns

**Refactoring_Ej3 — `Ring` hierarchy:** Abstract superclass holds the shared `protected int idx` field. `CharRing` and `IntRing` extend it but keep their own typed `source` arrays and `next()` methods (Pull Up Field was applied; Pull Up Method was not possible due to different return types).

**Refactoring_Ej5 — `Product` hierarchy:** `Product` holds `protected TimePeriod timePeriod` and the `startDate()`/`endDate()` methods (after Pull Up Field + Pull Up Method). `Hotel.effectiveNightPrice()` and `Company.effectivePrice()` encapsulate the pricing logic moved out of `HotelStay`/`CarRental` (Move Method applied for Feature Envy).

**Repaso_Ej2 — Double Dispatch:** `Juego` is an abstract class with `contra(Juego otro)` that delegates to `juegaContraPiedra()`, `juegaContraPapel()`, etc. Each concrete piece (Piedra, Papel, Tijera, Lagarto, Spock, Empate) implements all these methods.