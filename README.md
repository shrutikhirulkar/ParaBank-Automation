# ParaBank Automation

Test automation for ParaBank, a demo online banking application, using Selenium WebDriver, Java and TestNG.

## Tech stack
- Java
- Selenium WebDriver
- TestNG
- Maven

## Framework
- Page Object Model: LoginPage and AccountsOverviewPage
- Explicit waits inside page classes
- Assertions only in test classes

## Test cases covered
- Valid login: customer logs in and lands on Accounts Overview
- Invalid login: wrong password shows the correct error message
- Empty credentials: login with empty fields shows a validation message

## How to run
Right-click `ParaBankLoginTests` in Eclipse → Run As → TestNG Test

## Known issues
- invalidLogin currently fails because the ParaBank demo site is accepting any username and password (an environment issue on the demo server, confirmed manually on 29 Oct 2026).

## Work in progress
More banking scenarios (fund transfer, bill pay, reports, API tests) are being added step by step.