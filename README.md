# AI Book Recommendation System

A Spring Boot backend application that generates intelligent book recommendations using the Google Gemini API.

This project demonstrates how to integrate Generative AI into a Java backend system using direct API calls, without relying on external AI frameworks.

---

## Project Overview

This application exposes a REST endpoint that returns AI-generated book recommendations. It integrates with the Gemini API, processes the response using JSON parsing, and returns clean, readable output.

---

## Tech Stack

- Java 23  
- Spring Boot 3  
- Maven  
- Google Gemini API  
- Java HTTP Client  
- Jackson (for JSON parsing)  

---

## Requirements

- JDK 23 or later  
- Maven  
- Gemini API Key  

---

## Setup & Installation

### 1. Clone the Repository

git clone https://github.com/Arshdeep-nayan/AI-book-recommendation.git  
cd AI-book-recommendation  

---

### 2. Set up API Key

Set your Gemini API key as an environment variable:

Windows (PowerShell)

[System.Environment]::SetEnvironmentVariable("GEMINI_API_KEY", "your_api_key_here", "User")

---

### 3. Run the Application

mvn spring-boot:run  

Or run BooksApplication.java from your IDE.

---

## API Endpoint

GET /

Returns an AI-generated book recommendation.

Example:

http://localhost:8080  

Sample Response:

For a superb blend of AI concepts and practical coding, "Hands-On Machine Learning..." ...

---

## How It Works

1. User sends a request to the REST endpoint  
2. Spring Boot sends a request to the Gemini API  
3. The API returns a JSON response  
4. Jackson parses the JSON  
5. Clean text is returned to the client  

---

## Key Concepts Demonstrated

- REST API development using Spring Boot  
- External API integration using Java HTTP Client  
- JSON parsing using Jackson  
- Environment variable-based configuration  
- Debugging API errors and handling responses  

---


## Author

**Arshdeep Kumar**  

Developed a Spring Boot backend integrating Google Gemini API to build an AI-powered book recommendation system with clean response handling and secure configuration.
