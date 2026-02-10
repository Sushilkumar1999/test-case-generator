# 🧠 AI Test Case Generator (Java + Ollama + Selenium)

![Java](https://img.shields.io/badge/Java-17+-orange)
![AI](https://img.shields.io/badge/AI-Ollama-Yellow)
![Build](https://img.shields.io/badge/Build-Maven-brightgreen)

## Overview

This project is an **AI-powered Test Case Generator** built using **Java**, **Ollama (LLM)**, and **Apache POI**.

It reads software requirements from **text files**, sends them to a **local LLM (qwen2.5:3b via Ollama)**, automatically generates structured **software test cases**, and exports them into an **Excel file**.

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

✅ Read requirements from .txt files
✅ Generate Positive & Negative Test Cases using local LLM (Ollama)
✅ Enforced structured JSON output (prompt-driven)
✅ Jackson object mapping
✅ Excel export via Apache POI
✅ Configurable model parameters (temperature, token limit, streaming)
✅ Modular Java design
✅ Ready for Selenium automation extension

---

## 🏗 Architecture

```
text requirement file (.txt)
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
* Ollama (qwen2.5:3b model)
* Jackson (JSON Parsing)
* Apache POI (Excel)
* Maven
* Selenium (ready for future extension)

---

## 📂 Flow Diagram:

<img width="1333" height="177" alt="AI_Test_Case_Generator_flowDiagram" src="https://github.com/user-attachments/assets/22585321-dbad-45d8-81f0-0108c173ed00" />

```

```
## 📂 Project Structure

```
src/main/java
│
├── tcGenerator.ai
│   ├── OllamaClient.java        # Calls Ollama API
│   └── OllamaTest.java         # Main runner
│
├── tcGenerator.exporter
│   └── ExcelExporter.java      # Writes Excel output
│
├── tcGenerator.generator.output
│   ├── CERtestcases.xlsx
│   └── testcases.xlsx         # Generated files
│
├── tcGenerator.model
│   ├── FinalResponse.java     # Root AI response
│   ├── OllamaResponse.java    # Raw Ollama wrapper
│   └── TestCase.java          # Test Case POJO
│
├── tcGenerator.parser
│   └── RequirementParser.java # Reads requirement text
│
└── tcGenerator.util
    └── FileUtil.java          # File helpers

src/main/resources
└── requirement
    ├── login.txt
    └── NewRequirement.txt     # Input requirements

pom.xml

```

---

## ⚙ How to Run

### 1️⃣ Install Ollama

Download:

[https://ollama.com](https://ollama.com)

Pull model:

```
ollama pull qwen2.5:3b
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

Place your requirement file here:

```
src/main/resources/requirement/login.txt
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
java -cp target/classes tcGenerator.ai.OllamaTest
```

---

## 📤 Output

Generated Excel appears inside:

```
src/main/java/tcGenerator/generator/output/TestCases.xlsx
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

## 📌 Future Enhancements

* Auto Selenium Test Generation
* CI Pipeline Integration
* Test Case Tagging
* Streaming LLM Responses

---

## 👨‍💻 Author

Built by an SDET engineer as a production-quality AI automation portfolio project.

---

⭐ If this project helps you — star the repo!

---
