(index.html)
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simple Multiplier</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            max-width: 300px;
            margin: auto;
        }
        label {
            font-size: 14px;
            color: #555;
        }
        input[type="number"] {
            width: 100%;
            padding: 8px;
            margin: 10px 0;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
        #result {
            margin-top: 20px;
            font-size: 18px;
            color: #333;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Simple Multiplier</h1>
    <div class="form-container">
        <label for="num1">Enter First Number:</label>
        <input type="number" id="num1" placeholder="First number" required>

        <label for="num2">Enter Second Number:</label>
        <input type="number" id="num2" placeholder="Second number" required>

        <button id="multiplyButton">Multiply Numbers</button>

        <h2 id="result"></h2>
    </div>

    <script>
        // Using event listener instead of inline event handlers
        document.getElementById('multiplyButton').addEventListener('click', function() {
            const num1 = parseFloat(document.getElementById('num1').value);
            const num2 = parseFloat(document.getElementById('num2').value);

            if (!isNaN(num1) && !isNaN(num2)) {
                const result = num1 * num2;
                document.getElementById('result').innerText = `The result is: ${result}`;
            } else {
                document.getElementById('result').innerText = "Please enter valid numbers.";
            }
        });
    </script>
</body>
</html>
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
(test.js)
const { Builder, By, until } = require('selenium-webdriver');
const path = require('path');
require('chromedriver'); // WebDriver Manager will handle ChromeDriver setup automatically.

(async function testMultiplicationApp() {
    // Initialize the Chrome WebDriver
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        // Open the local HTML file in the browser
        const filePath = path.resolve(__dirname, 'index.html');
        await driver.get(`file://${filePath}`);

        // Wait for the first input field to be present before interacting
        await driver.wait(until.elementLocated(By.id('num1')), 1000);
        await driver.findElement(By.id('num1')).sendKeys('4');  // Entering the first number

        // Wait for the second input field to be present before interacting
        await driver.wait(until.elementLocated(By.id('num2')), 1000);
        await driver.findElement(By.id('num2')).sendKeys('5');  // Entering the second number

        // Wait for the "Multiply Numbers" button to be clickable before clicking
        await driver.wait(until.elementIsVisible(driver.findElement(By.id('multiplyButton'))), 1000);
        await driver.findElement(By.id('multiplyButton')).click();  // Click the "Multiply Numbers" button

        // Wait for the result to be displayed
        await driver.wait(until.elementLocated(By.id('result')), 1000);

        // Retrieve the result text
        const resultText = await driver.findElement(By.id('result')).getText();

        // Verify the result and log the outcome
        if (resultText === "The result is: 20") {
            console.log("Test Passed: 4 * 5 = 20");
        } else {
            console.log("Test Failed: Expected 'The result is: 20', but got " + resultText);
        }
    } finally {
        await driver.quit(); // Close the browser
    }
})();

