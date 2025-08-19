import { defineConfig, devices } from '@playwright/test';

export default defineConfig({
  timeout: 120_000,
  expect: { timeout: 10_000 },
  use: {
    baseURL: 'https://stagemarine.oicgulf.ae',
    trace: 'on-first-retry',
    screenshot: 'only-on-failure',
    video: 'retain-on-failure',
  },
  reporter: [['html', { open: 'never' }], ['list']],
  projects: [
    { name: 'chromium', use: { ...devices['Desktop Chrome'] } },
  ],
});

