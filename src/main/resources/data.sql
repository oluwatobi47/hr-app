INSERT INTO company_info (id, created_date, address, company_culture_statement, date_founded, mission_statement, name, vision)
SELECT '845bfe0e-538d-4c38-897e-3b30b0d3458b',
        '1701777597000',
        'Mountain View, California, USA',
        'A problem isn''t truly solved until it''s solved for all. Googlers build products that help create opportunities for everyone, whether down the street or across the globe. Bring your insight, imagination and a healthy disregard for the impossible. Bring everything that makes you unique. Together, we can build for everyone',
        '904867200000',
        'To organize the world''s information and make it universally accessible and useful',
        'Test Google',
        'To provide access to the world''s information in one click'
WHERE NOT EXISTS (SELECT 1 FROM company_info WHERE id = '845bfe0e-538d-4c38-897e-3b30b0d3458b');
