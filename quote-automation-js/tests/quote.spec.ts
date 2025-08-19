import { test, expect } from '@playwright/test';
import fs from 'fs';
import dotenv from 'dotenv';
dotenv.config();

const QUOTE_USERNAME = process.env.QUOTE_USERNAME || '';
const QUOTE_PASSWORD = process.env.QUOTE_PASSWORD || '';

test.describe('Marine quote flow', () => {
  test('generate quote end-to-end', async ({ page }) => {
    // Navigate to quote entry
    await page.goto('/quote/');
    await page.waitForLoadState('networkidle');
    await expect(page).toHaveTitle(/quote|marine|insurance/i);

    // Capture initial landing snapshot
    await page.screenshot({ path: 'artifacts/landing.png', fullPage: true }).catch(() => {});
    await page.content().then(html => fs.writeFileSync('artifacts/landing.html', html)).catch(() => {});

    // Click Get Full Quote if visible
    if (await page.getByRole('button', { name: /full quote/i }).isVisible().catch(() => false)) {
      await page.getByRole('button', { name: /full quote/i }).click();
      await page.waitForLoadState('networkidle');
      await page.screenshot({ path: 'artifacts/full-quote-step1.png', fullPage: true }).catch(() => {});
      await page.content().then(html => fs.writeFileSync('artifacts/full-quote-step1.html', html)).catch(() => {});
    } else if (await page.getByRole('button', { name: /quick quote/i }).isVisible().catch(() => false)) {
      await page.getByRole('button', { name: /quick quote/i }).click();
      await page.waitForLoadState('networkidle');
      await page.screenshot({ path: 'artifacts/quick-quote-step1.png', fullPage: true }).catch(() => {});
      await page.content().then(html => fs.writeFileSync('artifacts/quick-quote-step1.html', html)).catch(() => {});
    }

    // If login is required
    if (await page.getByLabel(/email|username|user/i).first().isVisible().catch(() => false)) {
      const userField = page.getByLabel(/email|username|user/i).first();
      const passField = page.getByLabel(/password|pass/i).first();
      if (QUOTE_USERNAME && QUOTE_PASSWORD) {
        await userField.fill(QUOTE_USERNAME);
        await passField.fill(QUOTE_PASSWORD);
        await page.getByRole('button', { name: /sign in|log in|continue/i }).click();
        await page.waitForLoadState('networkidle');
      }
    }

    // Example placeholders for journey steps — replace selectors as needed
    // 1) Quote details
    if (await page.getByRole('combobox', { name: /product|plan/i }).isVisible().catch(() => false)) {
      await page.getByRole('combobox', { name: /product|plan/i }).selectOption({ index: 1 });
    }
    if (await page.getByPlaceholder(/vessel name|boat name/i).isVisible().catch(() => false)) {
      await page.getByPlaceholder(/vessel name|boat name/i).fill('Test Vessel');
    }
    if (await page.getByPlaceholder(/year|built/i).isVisible().catch(() => false)) {
      await page.getByPlaceholder(/year|built/i).fill('2018');
    }
    if (await page.getByPlaceholder(/value|sum insured/i).isVisible().catch(() => false)) {
      await page.getByPlaceholder(/value|sum insured/i).fill('100000');
    }
    if (await page.getByRole('button', { name: /next|continue|proceed/i }).isVisible().catch(() => false)) {
      await page.getByRole('button', { name: /next|continue|proceed/i }).click();
      await page.waitForLoadState('networkidle');
    }

    // 2) Insured details
    if (await page.getByPlaceholder(/full name|insured name|name/i).isVisible().catch(() => false)) {
      await page.getByPlaceholder(/full name|insured name|name/i).fill('Test Customer');
    }
    if (await page.getByPlaceholder(/mobile|phone/i).isVisible().catch(() => false)) {
      await page.getByPlaceholder(/mobile|phone/i).fill('0501234567');
    }
    if (await page.getByPlaceholder(/email/i).isVisible().catch(() => false)) {
      await page.getByPlaceholder(/email/i).fill('test@example.com');
    }
    if (await page.getByRole('button', { name: /next|continue|proceed/i }).isVisible().catch(() => false)) {
      await page.getByRole('button', { name: /next|continue|proceed/i }).click();
      await page.waitForLoadState('networkidle');
    }

    // 3) Coverage / summary
    if (await page.getByRole('checkbox', { name: /terms|conditions|privacy/i }).isVisible().catch(() => false)) {
      await page.getByRole('checkbox', { name: /terms|conditions|privacy/i }).check();
    }
    if (await page.getByRole('button', { name: /generate quote|get quote|submit/i }).isVisible().catch(() => false)) {
      await page.getByRole('button', { name: /generate quote|get quote|submit/i }).click();
    }

    // Expect a confirmation or quote number appears (be specific to avoid landing matches)
    const successLocator = page.getByText(/reference number|quote number|your quote|successfully generated/i);
    await expect(successLocator).toBeVisible({ timeout: 60_000 });
  });
});

