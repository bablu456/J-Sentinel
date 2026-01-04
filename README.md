# 🛡️ J-Sentinel | System Health Monitor

![Java](https://img.shields.io/badge/Language-Java_17%2B-orange) ![Build](https://img.shields.io/badge/Build-Maven-blue) ![Status](https://img.shields.io/badge/Status-Active_Development-green)

> **A lightweight, CLI-based real-time system monitoring tool designed for servers and developer environments.**

---

## 📖 About The Project
**J-Sentinel** is a terminal-based application that monitors your computer's vital signs (CPU Load, Memory Usage, Disk Space) in real-time.

Unlike heavy GUI-based task managers, J-Sentinel is designed to be:
* **Lightweight:** Minimal resource consumption.
* **Headless Friendly:** Runs perfectly on servers via SSH.
* **Proactive:** Alerts you *before* your system crashes.

---

## 🚀 Key Features (Planned & Implemented)
- [x] **Core Architecture:** Maven-based modular structure.
- [ ] **Real-Time Dashboard:** Updates CPU & RAM usage every second.
- [ ] **Intelligent Alerts:** Visual/Audio warnings when resources hit >90%.
- [ ] **Logging System:** Auto-saves critical events to `system-health.log`.
- [ ] **Cross-Platform:** Works on Windows, Linux, and macOS.

---

## 🛠️ Tech Stack
* **Language:** Core Java (JDK 17)
* **Build Tool:** Apache Maven
* **Hardware Abstraction:** OSHI (Open System Hardware Intelligence)
* **Concurrency:** Java `ExecutorService` & Multithreading

---

## 📅 The 7-Day Dev Journey
*This project is being built as part of a rigorous "7-Day Open Source Challenge" to simulate a production-level sprint.*

| Day | Date | Focus Area | Status |
| :--- | :--- | :--- | :--- |
| **Day 1** | Jan 04 | **Inception & Setup:** Initialized Repo, Maven Architecture, & Main Entry Point. | ✅ Completed |
| **Day 2** | Jan 05 | **Data Harvesting:** Implementing CPU & Memory logic using OSHI. | ⏳ Pending |
| **Day 3** | Jan 06 | **The UI:** Building the CLI Dashboard & Render logic. | ⏳ Pending |
| **Day 4** | Jan 07 | **Concurrency:** Implementing Multithreading for real-time updates. | ⏳ Pending |
| **Day 5** | Jan 08 | **Alert System:** Logic for critical warnings (Red Alerts). | ⏳ Pending |
| **Day 6** | Jan 09 | **Logging & Reports:** File I/O for persistent tracking. | ⏳ Pending |
| **Day 7** | Jan 10 | **Release:** Code cleanup, JAR packaging, and Documentation. | ⏳ Pending |

---

## ⚡ How to Run
1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/bablu456/J-Sentinel.git](https://github.com/bablu456/J-Sentinel.git)
    ```
2.  **Navigate to directory:**
    ```bash
    cd J-Sentinel
    ```
3.  **Build the project:**
    ```bash
    mvn clean install
    ```
4.  **Run:**
    ```bash
    java -jar target/j-sentinel-1.0.jar
    ```

---
*Built with ❤️ by Bablu Kumar*