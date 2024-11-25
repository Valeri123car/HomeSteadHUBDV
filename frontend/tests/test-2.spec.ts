import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://localhost:3000/');
  await page.getByLabel('Maksimalna cena').click();
  await page.getByLabel('Maksimalna cena').fill('-1');
  await page.getByRole('button', { name: 'Filtriraj' }).click();
  await expect(page.locator('.nepItem').first()).not.toBeVisible();
  
  
  
});