# AI Book Recommendation System

A Spring Boot backend application that generates AI-powered book recommendations by integrating directly with the Google Gemini API — built using the JDK's native HTTP client rather than a wrapper framework, to demonstrate a clear understanding of what's happening under the hood of an AI API integration.

---

## Project Overview

This application exposes a REST endpoint that calls the Gemini `generateContent` API, parses the raw JSON response, and returns a clean, readable book recommendation as plain text.

The focus of this project is the integration layer itself — request construction, API authentication via environment variables, and JSON response parsing — rather than building a full-featured product on day one.

---

## Tech Stack

- Java 23
- Spring Boot 3.3.4
- Maven
- Google Gemini API (`gemini-2.5-flash`)
- Java's native `HttpClient` (`java.net.http`)
- Jackson (for JSON parsing)

---

## Design Decisions

- **No AI framework (e.g. Spring AI) used intentionally.** The Gemini API is called directly via `HttpClient`, with the request body and JSON response parsed manually using Jackson. This was a deliberate choice to understand the full request/response lifecycle of an LLM API call before relying on abstractions.
- **Environment-variable-based API key configuration**, keeping credentials out of source control via `.gitignore`.

---

## Requirements

- JDK 23 or later
- Maven
- Gemini API Key

---

## Setup & Installation

### 1. Clone the Repository

```bash
git clone https://github.com/Arshdeep-nayan/AI-book-recommendation.git
cd AI-book-recommendation
```

### 2. Set up API Key

Set your Gemini API key as an environment variable.

**Windows (PowerShell):**
```powershell
[System.Environment]::SetEnvironmentVariable("GEMINI_API_KEY", "your_api_key_here", "User")
```

**Linux / macOS:**
```bash
export GEMINI_API_KEY=your_api_key_here
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

Or run `BooksApplication.java` directly from your IDE.

---

## API Endpoint

`GET /`

Returns an AI-generated book recommendation as plain text.

**Example:**
```
http://localhost:8080
```

**Sample Response:**
```
For a superb blend of AI concepts and practical coding, "Hands-On Machine Learning..." ...
```

> Note: The prompt sent to Gemini is currently fixed ("Recommend a book on AI and coding in 100 words"). It does not yet accept a genre or topic as user input.

---

## How It Works

1. Client sends a `GET` request to `/`.
2. The controller reads `GEMINI_API_KEY` from the environment.
3. A request is built and sent to the Gemini `generateContent` endpoint via `HttpClient`.
4. The JSON response is parsed with Jackson to extract the generated text.
5. The plain-text recommendation is returned to the client.

---

## Data Model

A `BookRecommendation` record has been defined to represent a structured recommendation:

```java
public record BookRecommendation(
    String title,
    String author,
    int publicationYear,
    String genre,
    int pageCount,
    String summary
) { }
```

This is scaffolding for an upcoming change: parsing Gemini's response into structured fields instead of returning free-form text.

---

## Key Concepts Demonstrated

- REST API development using Spring Boot
- External AI API integration using Java's native HTTP Client (no third-party HTTP/AI library)
- Manual JSON request construction and response parsing with Jackson
- Environment variable-based configuration to keep API keys out of version control

---

## Author

**Arshdeep Kumar**

Built a Spring Boot backend integrating the Google Gemini API directly via Java's native HTTP client, covering manual request construction, JSON parsing, and environment-based configuration for an AI-powered book recommendation service.
