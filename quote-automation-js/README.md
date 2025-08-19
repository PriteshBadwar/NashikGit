## Quote automation (Playwright)

This project automates the quotation journey on `https://stagemarine.oicgulf.ae/quote/` up to quote generation using Playwright.

### Prerequisites

- Node.js 18+ and npm

### Setup

1. Install dependencies and browsers:
   - `npm install`
   - `npx playwright install --with-deps`

2. Configure test data (optional):
   - Copy `data/.env.example` to `.env` and customize values

### Run

- Execute the test:
  - `npm test`
  - View HTML report: `npm run show-report`

### Develop selectors quickly

- Launch code generator against the target page and record steps, then copy selectors into `tests/quote.spec.ts`:
  - `npm run codegen`

### Project structure

- `tests/quote.spec.ts` – main end-to-end flow to generate a quote
- `playwright.config.ts` – configuration (timeouts, retries, reporter)
- `data/.env.example` – example environment variables for credentials/test data

### Notes

- The initial test contains robust, accessible-first locators but you will likely need to adjust some selectors depending on the latest UI. Use `npm run codegen` to capture reliable locators.
- If the journey requires authentication, set `QUOTE_USERNAME` and `QUOTE_PASSWORD` in your `.env`.

