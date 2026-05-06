#  Expense Tracker

An Android app built with **Kotlin** and **Jetpack Compose** to help you track your daily expenses and visualize your spending habits through clean, interactive charts.

---

##  Features

- **Add & Delete Expenses** — Quickly log expenses and remove them when needed
- **Spending Analytics** — Visual charts to understand where your money is going
- **Clean Material 3 UI** — Modern, intuitive interface built with Jetpack Compose

---

##  Tech Stack

| Layer | Technology |
|---|---|
| Language | Kotlin |
| UI | Jetpack Compose + Material 3 |
| Architecture | MVVM |
| Local Database | Room |
| Build System | Gradle (KSP) |

---

##  Getting Started

### Prerequisites

- Android Studio Hedgehog or later
- Android SDK 26+
- Kotlin 1.9+

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Maanit5117/expense-tracker.git
   ```

2. **Open in Android Studio**
   ```
   File → Open → Select the cloned folder
   ```

3. **Let Gradle sync**, then hit **Run**

---

## 📂 Project Structure

```
app/
├── data/
│   ├── local/          # Room database, DAOs, entities
│   └── repository/     # Repository layer
├── ui/
│   ├── screens/        # Composable screens
│   ├── components/     # Reusable UI components
│   └── theme/          # Material 3 theming
└── viewmodel/          # ViewModels
```

---

##  Planned Features

- [ ] Expense categories with icons
- [ ] Monthly budget limits & alerts
- [ ] Export data to CSV
- [ ] Dark mode support

---

##  Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to change.

---

> Built with ❤️ using Jetpack Compose
