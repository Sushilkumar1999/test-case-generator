# 🧠 AI Test Case Generator (Java + Ollama + Selenium)

## Overview

This project is an **AI-powered Test Case Generator** built using **Java**, **Ollama (LLM)**, and **Apache POI**.

It reads software requirements from **Word documents**, sends them to a **local LLM (llama3 via Ollama)**, automatically generates structured **software test cases**, and exports them into an **Excel file**.

The goal is to eliminate manual test case writing and accelerate QA workflows using AI.

This project is designed as an **SDET portfolio project** demonstrating:

* AI integration
* Java automation
* JSON processing
* Excel generation
* Clean architecture
* Production-grade error handling

---

## 🚀 Features

✅ Read requirements from `.docx` files
✅ Generate Positive & Negative Test Cases using AI
✅ Enforced structured JSON output
✅ Jackson object mapping
✅ Excel export via Apache POI
✅ Handles LLM token limits safely
✅ Detects truncated AI responses
✅ Modular design
✅ Ready for Selenium automation extension

---

## 🏗 Architecture

```
Word Requirement (.docx)
        ↓
    Java Reader
        ↓
     Ollama API
        ↓
   Structured JSON
        ↓
   Java POJO Mapping
        ↓
    Excel Export
```

---

## 🛠 Tech Stack

* Java 8+
* Ollama (llama3 model)
* Jackson (JSON Parsing)
* Apache POI (Excel)
* Maven
* Selenium (ready for future extension)

---

## 📂 Project Structure

```
src/main/java
│
├── tcGenerator/ai
│   └── OllamaClient.java
│
├── tcGenerator/model
│   ├── TestCase.java
│   └── FinalResponse.java
│
├── tcGenerator/util
│   ├── WordUtil.java
│   ├── ExcelExporter.java
│   └── JsonExtractor.java
│
└── tcGenerator/generator
    └── OllamaTest.java

src/main/resources
└── requirement/login.docx
```

---

## ⚙ How to Run

### 1️⃣ Install Ollama

Download:

[https://ollama.com](https://ollama.com)

Pull model:

```
ollama pull llama3
```

Ensure service is running:

```
http://localhost:11434
```

---

### 2️⃣ Clone Project

```
git clone https://github.com/YOUR_USERNAME/test-case-generator.git
cd test-case-generator
```

---

### 3️⃣ Add Requirement

Place your Word file here:

```
src/main/resources/requirement/login.docx
```

---

### 4️⃣ Build

```
mvn clean install
```

---

### 5️⃣ Run Generator

From Eclipse or terminal:

```
java -cp target/classes tcGenerator.generator.OllamaTest
```

---

## 📤 Output

Generated Excel appears inside:

```
generator/output/TestCases.xlsx
```

Contains:

* ID
* Title
* Type
* Steps
* Expected Result
* Priority

---

## 🧪 Sample Test Case Output

| ID     | Title                        | Type     | Steps                 | Expected Result | Priority |
| ------ | ---------------------------- | -------- | --------------------- | --------------- | -------- |
| TC_001 | Login with valid credentials | Positive | Enter email, password | Login success   | High     |

---

## 🧠 AI Safety Handling

The system detects LLM truncation:

```
done_reason = length
```

and fails fast if JSON is incomplete.

Token limits are increased dynamically.

---

## 📌 Future Enhancements

* Auto Selenium Test Generation
* Cucumber Feature Creation
* CI Pipeline Integration
* Test Case Tagging
* Streaming LLM Responses

---

## 👨‍💻 Author

Built by an SDET engineer as a production-quality AI automation portfolio project.

---

⭐ If this project helps you — star the repo!

---

If you’d like next, we can add:

✅ Selenium generation
✅ Architecture diagram
✅ Resume bullets
✅ Demo screenshots

Just tell me 👍
