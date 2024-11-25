import { test, expect } from '@playwright/test';
import crypto from 'crypto';

test('test', async ({ page }) => {
 await page.goto('http://localhost:3000/');
 await page.getByRole('link', { name: 'Prijava' }).click();
 await page.getByLabel('Mail').click();
 await page.getByRole('link', { name: 'Nimate računa?' }).click();
 await page.getByLabel('Ime', { exact: true }).click();
 await page.getByLabel('Ime', { exact: true }).fill('d');
 await page.getByLabel('Priimek').click();
 await page.getByLabel('Priimek').fill('d');
 const uuid = crypto.randomUUID()
 await page.getByLabel('Mail').click();
 await page.getByLabel('Mail').fill(uuid);
 await page.getByLabel('Telefonska').click();
 await page.getByLabel('Telefonska').fill('3');
 await page.getByLabel('Geslo').click();
 await page.getByLabel('Geslo').fill(uuid);
 await page.getByRole('button', { name: 'Registracija' }).click();
 await page.getByLabel('Mail').click();
 await page.getByLabel('Mail').fill(uuid);
 await page.getByLabel('Geslo').click();
 await page.getByLabel('Geslo').fill(uuid);
 await page.getByRole('button', { name: 'Prijava' }).nth(1).click();
 await expect(page.getByRole('link', { name: 'Dodaj nepremicnino' })).toBeVisible();
})