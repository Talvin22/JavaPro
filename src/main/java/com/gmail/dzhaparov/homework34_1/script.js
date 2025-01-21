
// Метод getElementById() інтерфейсу Document
// повертає об’єкт Element, що представляє елемент,
// властивість id якого відповідає вказаному рядку.
// https://developer.mozilla.org/en-US/docs/Web/API/Document/getElementById
// https://developer.mozilla.org/en-US/docs/Web/API/Document
// https://developer.mozilla.org/en-US/docs/Web/API/Element
let display = document.getElementById('display');
let expression = '';

function inputValue(value) {
    if (expression === '' && (value === '/' || value === '*' || value === '-' || value === '+')) {
        return;
    }
    expression += value;
    // Властивість textContent інтерфейсу Node представляє
    // текстовий вміст вузла та його нащадків.
    // https://developer.mozilla.org/en-US/docs/Web/API/Node
    // https://developer.mozilla.org/en-US/docs/Web/API/Node/textContent
    display.textContent = expression;
}

function calculate() {
    try {
        // Обрабатываем проценты в конце числа (например, 100 - 10%)
        expression = expression.replace(/(\d+)\s*-\s*(\d+)%/g, '($1 - ($2 / 100 * $1))'); // 100 - 10% -> 100 - (10 / 100 * 100)
        expression = expression.replace(/(\d+)\s*\+\s*(\d+)%/g, '($1 + ($2 / 100 * $1))'); // 100 + 10% -> 100 + (10 / 100 * 100)

        // Обрабатываем процентное умножение (например, 100 * 10%)
        expression = expression.replace(/(\d+)\s*\*\s*(\d+)%/g, '($1 * ($2 / 100))'); // 100 * 10% -> 100 * (10 / 100)

        // Обрабатываем процентные вычисления (например, 10% от 100)
        expression = expression.replace(/(\d+)%\s*(\d+)/g, '($1 / 100 * $2)'); // 10%100 -> (10 / 100 * 100)

        // Обрабатываем процент в выражении (например, 10%)
        expression = expression.replace(/(\d+)%/g, '($1 / 100)'); // 10% -> (10 / 100)

        if (expression.includes('/0')) {
            display.textContent = "Error";
            expression = '';
            return;
        }

        let result = eval(expression);
        display.textContent = result;
        expression = result.toString();
    } catch (error) {
        display.textContent = "Error";
        expression = '';
    }
}

function clearDisplay() {
    expression = '';
    display.textContent = '0';
}

function backspace() {
    // Метод slice() значень String витягує частину
    // цього рядка та повертає його як новий рядок,
    // не змінюючи оригінальний рядок.
    // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/slice
    expression = expression.slice(0, -1);
    display.textContent = expression || '0';
}